package com.fan.gupao.demo.zookeeperleader;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 樊高风
 * @date 2020/9/13
 */
public class ZkSchedulerFactoryBean extends SchedulerFactoryBean {


    private static CuratorFramework zkClient;
    private static String ZOOKEEPER_CONNECTION_STRING = "192.168.105.128:2181";
    // leader选举的API
    private LeaderLatch leaderLatch;
    private static final String LEADER_PATH = "/leader";

    private Logger logger = LoggerFactory.getLogger(ZkSchedulerFactoryBean.class);

    public ZkSchedulerFactoryBean() throws Exception {
        // 设置为非自动启动
        this.setAutoStartup(false);
        leaderLatch = new LeaderLatch(getZkClient(), LEADER_PATH);
        leaderLatch.addListener(new ZkJobLeaderLatchListener(getIp(), this));
        // 表示当前节点参与到leader选举中来
        leaderLatch.start();
    }

    @Override
    public void destroy() throws SchedulerException {
        CloseableUtils.closeQuietly(leaderLatch);
        super.destroy();
    }

    @Override
    protected void startScheduler(Scheduler scheduler, int startupDelay) throws SchedulerException {
        // 默认情况下,是true
        if (this.isAutoStartup()) {
            super.startScheduler(scheduler, startupDelay);
        }
    }


    // 初始化连接
    private CuratorFramework getZkClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        zkClient = CuratorFrameworkFactory.builder()
                .connectString(ZOOKEEPER_CONNECTION_STRING)
                .retryPolicy(retryPolicy).build();
        zkClient.start();
        return zkClient;
    }


    private String getIp() {
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host;
    }


    class ZkJobLeaderLatchListener implements LeaderLatchListener {

        private String ip;
        private SchedulerFactoryBean schedulerFactoryBean;

        public ZkJobLeaderLatchListener(String ip, SchedulerFactoryBean schedulerFactoryBean) {
            this.ip = ip;
            this.schedulerFactoryBean = schedulerFactoryBean;
        }

        @Override
        public void isLeader() {
            logger.info("ip:{}成为leader,执行scheduler~", ip);
            schedulerFactoryBean.setAutoStartup(true);
            // 启动 抢占到leader节点的去执行任务
            schedulerFactoryBean.start();

        }

        @Override
        public void notLeader() {
            logger.info("ip:{}不是leader,停止scheduler~", ip);
            schedulerFactoryBean.setAutoStartup(false);
            // 启动 抢占到leader节点的去执行任务
            schedulerFactoryBean.stop();
        }
    }

}

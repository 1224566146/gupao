package com.fan.gupao.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 樊高风
 * @Title: UserService
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:21
 */
public class UserService {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    ArrayBlockingQueue<User> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    {
        init();
    }

    public void init(){
        executorService.execute(()->{  // 不断消费队列的线程
            while (true){
                try {
                   User user = arrayBlockingQueue.take(); // 阻塞式
                    System.out.println("发送优惠卷给:"+user);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean register(){
        User user = new User("樊高风");
        addUser(user);

        try {
            arrayBlockingQueue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void addUser(User user){
        System.out.println("添加用户:"+user);
    }

    public static void main(String[] args) {

        new UserService().register();

    }

}

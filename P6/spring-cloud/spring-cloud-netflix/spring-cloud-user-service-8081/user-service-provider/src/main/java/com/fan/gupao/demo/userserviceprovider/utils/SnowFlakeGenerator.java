package com.fan.gupao.demo.userserviceprovider.utils;

/**
 * 雪花算法
 *
 * @author 樊高风
 * @date 2020/8/4
 */
public class SnowFlakeGenerator {

    // 机房id
    private long roomId;
    // 机器id
    private long wokerId;

    // 占用5个bit位
    private long roomIdBit = 5L;
    // 占用5个bit位
    private long wokerIdBit = 5L;

    //声明roomId最大的正整数32
    private long maxRoomId = -1L ^ (-1L << roomIdBit);
    private long maxWokerId = -1L ^ (-1L << wokerIdBit);

    // 12bit的递增序列
    private long sequenceBits = 12L;

    // 递增开始的序列
    private long sequence;

    public SnowFlakeGenerator(long roomId, long wokerId, long sequence) {
        if (wokerId > maxWokerId || wokerId < 0) {
            throw new IllegalArgumentException("woker Id 错误");
        }
        if (roomId > maxRoomId || roomId < 0) {
            throw new IllegalArgumentException("room Id 错误");
        }
        this.roomId = roomId;
        this.wokerId = wokerId;
        this.sequence = sequence;
    }

    // 记录sequence能够存储的最大的长度
    private long sequenceMask = -1L ^ (-1L << sequenceBits);
    // 存储上一次生成的id的时间戳
    private long lastTimeStamp = -1L;

    // 初始的时间值
    private long twepoch = 1596502678320L;

    private long wokerIdShift = sequenceBits;
    private long roomIdShift = sequenceBits + wokerIdBit;
    private long timeStampShift = sequenceBits + wokerIdBit + roomIdBit;


    public synchronized long nextVal() {
        // 开始去生成ID
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimeStamp) {
            throw new RuntimeException("时间戳异常");
        }
        if (lastTimeStamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 如果==0,表示sequence的值超过了4095
                timestamp = waitToNextMils(lastTimeStamp);
            }
        } else {
            // 如果进入到了新的时间毫秒,sequence从0开始
            sequence = timestamp & 1;
        }
        lastTimeStamp = timestamp;
        return ((timestamp - twepoch) << timeStampShift | (roomId << roomIdShift)
                | (wokerId << wokerIdShift) | sequence);
    }

    // 执行到下一个时间毫秒
    private long waitToNextMils(long lastTimeStamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimeStamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) throws InterruptedException {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator(1, 1, 1);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            System.out.println(snowFlakeGenerator.nextVal());
        }
    }

}

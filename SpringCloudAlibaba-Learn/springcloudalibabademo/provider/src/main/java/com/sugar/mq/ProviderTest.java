package com.sugar.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * MQ 原生调用
 * Provider
 */
public class ProviderTest {
    public static void main(String[] args) throws Exception{
        // 创建消费生产者
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        // 设置NameServer
        producer.setNamesrvAddr("localhost:9876");
        // 启动生产者
        producer.start();
        // 构建消息对象
        Message message = new Message("myTopic", "myTag", ("Test MQ").getBytes());
        // 发送消息
        SendResult result = producer.send(message, 1000);
        System.out.println(result);
        // 关闭生产者
        producer.shutdown();
    }
}

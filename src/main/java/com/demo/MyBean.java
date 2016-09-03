package com.demo;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
	private final AmqpAdmin amqpAdmin;
	private final AmqpTemplate amqpTemplate;

	@Autowired
	public MyBean(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
		this.amqpAdmin = amqpAdmin;
		this.amqpTemplate = amqpTemplate;
	}
	
	@RabbitListener(queues = "someQueue")
	public void processMessage(String content) {
		// TODO 处理消息
		System.out.println(content);
	}

	public AmqpAdmin getAmqpAdmin() {
		return amqpAdmin;
	}

	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

}

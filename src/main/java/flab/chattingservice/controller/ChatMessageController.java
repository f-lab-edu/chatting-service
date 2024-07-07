package flab.chattingservice.controller;

import flab.chattingservice.model.ChatMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ChatMessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/chat")
    public String chatPageRouter() {
        return "chat";
    }
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) throws Exception {
        System.out.println(chatMessage.getMessage());
//        chatMessage.getRoomId()
        rabbitTemplate.convertAndSend("your_exchange_name", "your_routing_key", chatMessage);
    }
}

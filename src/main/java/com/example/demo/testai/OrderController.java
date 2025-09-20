package com.example.demo.testai;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderManagementAIAssistant aiAssistant;

    @PostMapping("/chat")
    public ResponseEntity<String> handleChat(@RequestBody String prompt) {
        ChatResponse response = aiAssistant.callChatClient(Set.of("createOrderFn", "getUserOrdersFn"), prompt);
        return ResponseEntity.ok(response.getResult().getOutput().getContent());
    }
}


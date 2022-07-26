package org.example.controller.impl;

import org.example.dto.ChatForm;
import org.example.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private IMessageService messageService;

    @Autowired
    public ChatController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model, Principal principal) {
        chatForm.setUserName(principal.getName());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "redirect:/chat";
    }

}

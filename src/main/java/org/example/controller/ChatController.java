package org.example.controller;

import org.example.dto.ChatForm;
import org.example.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final IMessageService messageService;

    @Autowired
    public ChatController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model, @CookieValue String userName) {
        chatForm.setUserName(userName);
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "redirect:/chat";
    }

}

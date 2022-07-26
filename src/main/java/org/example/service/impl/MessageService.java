package org.example.service.impl;

import org.example.dto.ChatForm;
import org.example.entity.Message;
import org.example.repository.MessageRepo;
import org.example.service.IMessageService;
import org.example.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    private final MessageRepo messageRepo;
    private final IUserService userService;

    public MessageService(MessageRepo messageRepo, IUserService userService) {
        this.messageRepo = messageRepo;
        this.userService = userService;
    }

    public void addMessage(ChatForm chatForm) {
        Message newMessage = new Message();
        newMessage.setMessage(chatForm.getMessageText());
        newMessage.setUser(userService.getByName(chatForm.getUserName()));
        messageRepo.save(newMessage);
    }

    public List<Message> getLast50Messages() {
        return messageRepo.findTop50ByOrderByDateDesc();
    }
}

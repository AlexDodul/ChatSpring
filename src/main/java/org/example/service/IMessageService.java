package org.example.service;


import org.example.dto.ChatForm;
import org.example.entity.Message;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMessageService {
    @Transactional
    void addMessage(ChatForm chatForm);

    @Transactional(readOnly = true)
    List<Message> getLast50Messages();
}

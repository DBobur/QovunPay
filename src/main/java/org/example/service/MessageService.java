package org.example.service;

import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.example.repository.UserRepository;

public class MessageService extends BaseService<Message, MessageRepository> {
    private static final MessageService messageService = new MessageService();
    private MessageService() {
        super(new MessageRepository());
    }

    public static MessageService getInstance(){
        return messageService;
    }

    @Override
    protected boolean checking(Message message) {
        return false;
    }
}

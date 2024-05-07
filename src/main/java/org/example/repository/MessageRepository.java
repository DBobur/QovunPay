package org.example.repository;

import org.example.model.Message;

public class MessageRepository extends BaseRepository<Message> {
    {
        path += "messages.json";
        type = Message.class;
    }
}

package com.example.serversimulation.service;

import com.example.serversimulation.dto.CreateChat;
import com.example.serversimulation.entity.Chats;

import java.util.List;

public interface ServerSimulationService {
    public Chats createChat(String userId, CreateChat createChat);
    public List<Chats> getChatsByUserId(String userId);
    public boolean deleteAllChats(String userId);
    public boolean deleteOneChats(String userId,Long messageId);
}

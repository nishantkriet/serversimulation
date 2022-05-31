package com.example.serversimulation.serviceimpl;

import com.example.serversimulation.dto.CreateChat;
import com.example.serversimulation.entity.Chats;
import com.example.serversimulation.exceptionhandler.CustomNotFoundException;
import com.example.serversimulation.repository.ChatRepository;
import com.example.serversimulation.service.ServerSimulationService;
import com.example.serversimulation.utility.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServerSimulationServiceImpl implements ServerSimulationService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chats createChat(String userId, CreateChat createChat) {
        Chats chats = new Chats();
        chats.setUserId(userId);
        chats.setCreationDate(createChat.getTimestamp());
        chats.setSent(createChat.getSent());
        chats.setMessage(createChat.getMessage());
        chats.setStatus(ConstantValues.ACTIVE_CHATS);
        //chats.set
        Chats savedChat = chatRepository.save(chats);
        return savedChat;
    }

    @Override
    public List<Chats> getChatsByUserId(String userId) {
        List<Chats> chatsList = chatRepository.findByUserIdAndStatus(userId,ConstantValues.ACTIVE_CHATS);
        return chatsList;
    }

    @Override
    @Transactional
    public boolean deleteAllChats(String userId) {
        try {
            chatRepository.deleteAllChat(ConstantValues.INACTIVE_CHATS, userId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deleteOneChats(String userId, Long messageId) {
        Chats chats = chatRepository.findByUserIdAndStatusAndId(userId,ConstantValues.ACTIVE_CHATS,messageId);
        if(chats == null){
            throw new CustomNotFoundException("No message Found To delete");
        }
        chats.setStatus(ConstantValues.INACTIVE_CHATS);
        chatRepository.save(chats);
        return false;
    }

}

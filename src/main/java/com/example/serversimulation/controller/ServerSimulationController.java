package com.example.serversimulation.controller;

import com.example.serversimulation.dto.CreateChat;
import com.example.serversimulation.entity.Chats;
import com.example.serversimulation.service.ServerSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chatlogs")
public class ServerSimulationController {

    @Autowired
    private ServerSimulationService serverSimulationService;

    @PostMapping(value = "/{user}")
    public ResponseEntity<Chats> createChat(@PathVariable ("user") String user,@Valid @RequestBody CreateChat createChat){
        Chats chats = serverSimulationService.createChat(user,createChat);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping(value = "/{user}")
    public ResponseEntity<List<Chats>> getAllChat(@PathVariable ("user")String user){
        List<Chats> chatsList = serverSimulationService.getChatsByUserId(user);
        if(chatsList == null && chatsList.size() >0){
            return new ResponseEntity<>(chatsList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chatsList, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{user}")
    public ResponseEntity deleteAllChat(@PathVariable ("user")String user){
        serverSimulationService.deleteAllChats(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/{user}/{msgId}")
    public ResponseEntity deleteOneChat(@PathVariable ("user")String user,@PathVariable ("msgId")Long messageId){
        serverSimulationService.deleteOneChats(user,messageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

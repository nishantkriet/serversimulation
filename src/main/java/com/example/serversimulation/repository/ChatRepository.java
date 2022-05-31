package com.example.serversimulation.repository;

import com.example.serversimulation.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chats,Long> {
    public List<Chats> findByUserIdAndStatus(String userId,Integer status);
    public Chats findByUserIdAndStatusAndId(String userId,Integer status,Long id);
    @Modifying
    @Query("update Chats u set u.status = :status where u.userId = :userId")
    void deleteAllChat(@Param(value = "status") Integer status, @Param(value = "userId") String userId);
}

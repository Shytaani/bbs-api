package com.api.bbs.repository

import com.api.bbs.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository extends JpaRepository<Message, Long> {
    
    List<Message> findAllByOrderByIdDesc()
}
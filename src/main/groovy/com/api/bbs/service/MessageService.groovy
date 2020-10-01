package com.api.bbs.service

import com.api.bbs.controller.request.MessageRequest
import com.api.bbs.controller.response.MessageCommand
import com.api.bbs.entity.Message
import com.api.bbs.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MessageService {

    @Autowired
    private MessageRepository repository

    @Transactional(readOnly = true)
    List<MessageCommand> getAllMessages() {
        repository.findAllByOrderByIdDesc().collect {
            new MessageCommand(it.id, it.name, it.email, it.subject, it.content, it.postedDate)
        }
    }

    @Transactional(readOnly = true)
    MessageCommand getMessage(final Long id) {
        def message = repository.getOne(id)
        new MessageCommand(
            message.id,
            message.name,
            message.email,
            message.subject,
            message.content,
            message.postedDate)
    }

    @Transactional
    MessageCommand postMessage(final MessageRequest request) {
        def savedMessage = repository.save(new Message(
                name: request.name,
                email: request.email,
                subject: request.subject,
                content: request.content,
                postedDate: new Date()))
        new MessageCommand(
                savedMessage.id,
                savedMessage.name,
                savedMessage.email,
                savedMessage.subject,
                savedMessage.content,
                savedMessage.postedDate)
    }

    @Transactional
    MessageCommand putMessage(final Long id, final MessageRequest request) {
        def message = repository.getOne(id)
        message.name = request.name
        message.email = request.email
        message.subject = request.subject
        message.content = request.content
        def updatedMessage = repository.save(message)
        new MessageCommand(
                updatedMessage.id,
                updatedMessage.name,
                updatedMessage.email,
                updatedMessage.subject,
                updatedMessage.content,
                updatedMessage.postedDate)
    }

    @Transactional
    void deleteMessage(final Long id) {
        def message = repository.getOne(id)
        repository.delete(message)
    }
}

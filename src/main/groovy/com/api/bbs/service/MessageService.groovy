package com.api.bbs.service

import com.api.bbs.controller.request.MessageRequest
import com.api.bbs.controller.response.MessageResponse
import com.api.bbs.entity.Message
import com.api.bbs.exception.MessageNotFoundException
import com.api.bbs.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MessageService {

    @Autowired
    private MessageRepository repository

    @Autowired
    private MessageSource validationMessageSource

    @Transactional(readOnly = true)
    List<MessageResponse> getAllMessages() {
        repository.findAllByOrderByIdDesc().collect {
            new MessageResponse(it.id, it.name, it.email, it.subject, it.content, it.postedDate)
        }
    }

    @Transactional(readOnly = true)
    MessageResponse getMessage(final Long id) {
        def message = repository.findById(id).orElseThrow(
                () -> new MessageNotFoundException(validationMessageSource.getMessage("message.not.found", null, LocaleContextHolder.locale)))
        new MessageResponse(
            message.id,
            message.name,
            message.email,
            message.subject,
            message.content,
            message.postedDate)
    }

    @Transactional
    MessageResponse postMessage(final MessageRequest request) {
        def savedMessage = repository.save(new Message(
                name: request.name,
                email: request.email,
                subject: request.subject,
                content: request.content,
                postedDate: new Date()))
        new MessageResponse(
                savedMessage.id,
                savedMessage.name,
                savedMessage.email,
                savedMessage.subject,
                savedMessage.content,
                savedMessage.postedDate)
    }

    @Transactional
    MessageResponse putMessage(final Long id, final MessageRequest request) {
        def message = repository.findById(id).orElseThrow(
                () -> new MessageNotFoundException(validationMessageSource.getMessage("message.not.found", null, LocaleContextHolder.locale)))
        message.name = request.name
        message.email = request.email
        message.subject = request.subject
        message.content = request.content
        def updatedMessage = repository.save(message)
        new MessageResponse(
                updatedMessage.id,
                updatedMessage.name,
                updatedMessage.email,
                updatedMessage.subject,
                updatedMessage.content,
                updatedMessage.postedDate)
    }

    @Transactional
    void deleteMessage(final Long id) {
        def message = repository.findById(id).orElseThrow(
                () -> new MessageNotFoundException(validationMessageSource.getMessage("message.not.found", null, LocaleContextHolder.locale)))
        repository.delete(message)
    }
}

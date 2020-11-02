package com.api.bbs.controller

import com.api.bbs.controller.request.MessageRequest
import com.api.bbs.controller.response.MessageResponse
import com.api.bbs.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = "/bbs")
@CrossOrigin
class BbsController {

    @Autowired
    private MessageService service

    @GetMapping(path = "/messages")
    List<MessageResponse> getAll() {
        service.getAllMessages()
    }

    @GetMapping(path = "/message/{id}")
    MessageResponse get(@PathVariable final Long id) {
        service.getMessage(id)
    }

     @PostMapping(path = "/message")
     MessageResponse post(@RequestBody final MessageRequest request) {
         service.postMessage(request)
     }

    @PutMapping(path = "/message/{id}")
    MessageResponse put(@PathVariable final Long id, @RequestBody final MessageRequest request) {
        service.putMessage(id, request)
    }

     @DeleteMapping(path = "/message/{id}")
     void delete(@PathVariable final Long id) {
         service.deleteMessage(id)
     }
}

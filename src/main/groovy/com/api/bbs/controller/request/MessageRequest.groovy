package com.api.bbs.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class MessageRequest {

    @NotEmpty
    @Size(max = 20)
    String name

    @Size(max = 254)
    @Email
    String email

    @Size(max = 40)
    String subject

    @NotEmpty
    @Size(max = 400)
    String content
}
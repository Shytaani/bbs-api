package com.api.bbs.controller.response

import groovy.transform.Canonical

@Canonical
class MessageResponse {
    
    Long id

    String name

    String email

    String subject

    String content

    Date postedDate
}

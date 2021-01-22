package com.api.bbs.exception

class MessageNotFoundException extends Exception {

    MessageNotFoundException(String errorMessage) {
        super(errorMessage)
    }
}

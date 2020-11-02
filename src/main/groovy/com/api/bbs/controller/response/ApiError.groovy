package com.api.bbs.controller.response

import groovy.transform.Canonical

@Canonical
class ApiError {

    String message

    List<Detail> details = []

    void addDetails(String field, String message) {
        details << new Detail(field, message)
    }

    @Canonical
    private static class Detail {

        String field

        String message
    }
}

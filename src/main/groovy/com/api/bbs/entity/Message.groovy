package com.api.bbs.entity

import javax.persistence.*

@Entity
class Message {
    
    @Id
    @GeneratedValue
    Long id

    @Column(nullable = false)
    String name

    @Column
    String email

    @Column
    String subject

    @Column(nullable = false)
    String content

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date postedDate
}

package com.api.bbs.entity

import javax.persistence.*

@Entity
class Message {
    
    @Id
    @GeneratedValue
    Long id

    @Column(nullable = false, length = 20)
    String name

    @Column(length = 254)
    String email

    @Column(length = 40)
    String subject

    @Column(nullable = false, length = 400)
    String content

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date postedDate
}

package com.tucanoo.roomresgroovy.data.entity

import groovy.transform.CompileStatic

import javax.persistence.*

@Entity
@Table(name = "GUEST")
@CompileStatic
class Guest {
    @Id
    @Column(name = "GUEST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long guestId
    @Column(name = "FIRST_NAME")
    String firstName
    @Column(name = "LAST_NAME")
    String lastName
    @Column(name = "EMAIL_ADDRESS")
    String emailAddress
    @Column(name = "ADDRESS")
    String address
    @Column(name = "COUNTRY")
    String country
    @Column(name = "STATE")
    String state
    @Column(name = "PHONE_NUMBER")
    String phoneNumber
}

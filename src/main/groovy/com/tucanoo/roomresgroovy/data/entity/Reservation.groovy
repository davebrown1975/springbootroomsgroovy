package com.tucanoo.roomresgroovy.data.entity

import groovy.transform.CompileStatic

import javax.persistence.*

@Entity
@Table(name = "RESERVATION")
@CompileStatic
class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long reservationId

    @Column(name = "GUEST_ID")
    Long guestId
    @Column(name = "ROOM_ID")
    Long roomId

    @Column(name = "RES_DATE")
    Date reservationDate

}

package com.tucanoo.roomresgroovy.data.entity

import groovy.transform.CompileStatic

import javax.persistence.*

@Entity
@Table(name = "ROOM")
@CompileStatic
class Room {
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long roomId

    @Column(name = "NAME")
    String roomName

    @Column(name = "ROOM_NUMBER")
    String roomNumber

    @Column(name = "BED_INFO")
    String bedInfo
}

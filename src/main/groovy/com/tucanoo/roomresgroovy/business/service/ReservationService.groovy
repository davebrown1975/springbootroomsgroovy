package com.tucanoo.roomresgroovy.business.service

import com.tucanoo.roomresgroovy.business.domain.RoomReservation
import com.tucanoo.roomresgroovy.data.entity.Guest
import com.tucanoo.roomresgroovy.data.entity.Reservation
import com.tucanoo.roomresgroovy.data.entity.Room
import com.tucanoo.roomresgroovy.data.repository.GuestRepository
import com.tucanoo.roomresgroovy.data.repository.ReservationRepository
import com.tucanoo.roomresgroovy.data.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReservationService {
    @Autowired
    RoomRepository roomRepository
    @Autowired
    GuestRepository guestRepository
    @Autowired
    ReservationRepository reservationRepository

    List<RoomReservation> getRoomReservations(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll()
        Map<Long, RoomReservation> roomReservationMap = new HashMap()
        rooms.forEach({ room ->
            RoomReservation reservation = new RoomReservation()
            reservation.setRoomId(room.getRoomId())
            reservation.setRoomName(room.getRoomName())
            reservation.setRoomNumber(room.getRoomNumber())
            roomReservationMap.put(room.getRoomId(), reservation)
        })

        Iterable<Reservation> reservations = this.reservationRepository
                .findReservationByReservationDate(new java.sql.Date(date.getTime()))

        reservations.forEach({ reservation ->
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId())
            roomReservation.setDate(date)
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get()
            roomReservation.setGuestId(guest.getGuestId())
            roomReservation.setFirstName(guest.getFirstName())
            roomReservation.setLastName(guest.getLastName())
        })

        List<RoomReservation> roomReservations = new ArrayList<>()
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id))
        }

        return roomReservations
    }

    /*
        Sorted list now sorts by last and first name, no need to add to list either.
     */

    List<Guest> getGuests() {
        Iterable<Guest> allGuests = guestRepository.findAll()

        return allGuests.sort { a, b ->
            a.lastName <=> b.lastName ?: a.firstName <=> b.firstName
        }
    }
}

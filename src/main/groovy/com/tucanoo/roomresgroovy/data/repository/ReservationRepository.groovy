package com.tucanoo.roomresgroovy.data.repository

import com.tucanoo.roomresgroovy.data.entity.Reservation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.sql.Date

@Repository
interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}

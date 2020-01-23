package com.tucanoo.roomresgroovy.web

import com.tucanoo.roomresgroovy.business.domain.RoomReservation
import com.tucanoo.roomresgroovy.business.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/reservations")
class RoomReservationWebServiceController {
    @Autowired
    ReservationService reservationService

//    @Autowired
//    public RoomReservationWebServiceController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }

    @GetMapping
    List<RoomReservation> getRoomReservations(@RequestParam(value = "date", required = false) String dateString) {
        Date date = DateUtils.createDateFromString(dateString)
        return this.reservationService.getRoomReservations(date)
    }
}

package com.tucanoo.roomresgroovy.web

import com.tucanoo.roomresgroovy.business.domain.RoomReservation
import com.tucanoo.roomresgroovy.business.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/reservations")
class RoomReservationWebController {
    @Autowired
    ReservationService reservationService

//    @Autowired
//    public RoomReservationWebController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }

    @GetMapping
    String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.createDateFromString(dateString)
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservations(date)
        model.addAttribute("roomReservations", roomReservations)

        return "reservations"
    }
}

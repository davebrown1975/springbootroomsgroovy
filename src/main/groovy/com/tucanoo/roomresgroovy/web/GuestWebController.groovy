package com.tucanoo.roomresgroovy.web

import com.tucanoo.roomresgroovy.business.service.ReservationService
import com.tucanoo.roomresgroovy.data.entity.Guest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/guests")
class GuestWebController {
    @Autowired
    ReservationService reservationService

//    @Autowired
//    GuestWebController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }

    @GetMapping
    String getGuests(Model model) {

        List<Guest> guests = this.reservationService.getGuests()
        model.addAttribute("guests", guests)

        return "guests"
    }
}

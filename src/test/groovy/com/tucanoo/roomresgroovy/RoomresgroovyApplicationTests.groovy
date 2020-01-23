package com.tucanoo.roomresgroovy

import com.tucanoo.roomresgroovy.web.RoomReservationWebController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class RoomresgroovyApplicationTests extends Specification {

    @Autowired
    RoomReservationWebController roomReservationWebController

    def "When context is loaded then all beans are created"() {
        expect: "the web controller is created"
        roomReservationWebController
    }
}

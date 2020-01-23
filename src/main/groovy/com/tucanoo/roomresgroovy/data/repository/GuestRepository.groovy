package com.tucanoo.roomresgroovy.data.repository

import com.tucanoo.roomresgroovy.data.entity.Guest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestRepository extends CrudRepository<Guest, Long> {

}

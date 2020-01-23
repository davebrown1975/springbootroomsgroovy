package com.tucanoo.roomresgroovy.data.repository

import com.tucanoo.roomresgroovy.data.entity.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository extends CrudRepository<Room, Long> {

}

package com.github.izacchi16.attendance

import com.airbnb.epoxy.TypedEpoxyController

class MainController : TypedEpoxyController<List<Room>>() {
    override fun buildModels(data: List<Room>) {
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
            return
        }

        data.forEachIndexed { index, room ->
            val id = room.id
            val name = room.name
            itemRoom {
                id("$index")
                roomId(id)
                roomName(name)
            }
        }

    }

}
package com.codeinvestigator.springbootjavaandkotlin.space.station

import com.codeinvestigator.springbootjavaandkotlin.space.NavigationRestController
import com.codeinvestigator.springbootjavaandkotlin.space.navigation.Destination
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class SpaceStationRestController(val navRestController: NavigationRestController) {

    @GetMapping(value=["/station/destinations"],
            produces =[MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun destinations():Flux<Destination>{
        return navRestController.destinations();
    }

}
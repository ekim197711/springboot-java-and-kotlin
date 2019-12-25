package com.codeinvestigator.springbootjavaandkotlin.space;

import com.codeinvestigator.springbootjavaandkotlin.space.navigation.Destination;
import com.codeinvestigator.springbootjavaandkotlin.space.station.SpaceStationRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ShipController {
    private final SpaceStationRestController spaceStationRestController;

    @GetMapping(value = "/ship/destinations", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Destination> destinations(){
        Flux<Destination> destinations = spaceStationRestController.destinations();
        destinations.subscribe(d -> System.out.println(
                String.format("Dest from ship controller! %s", d)));
        return destinations;
    }
}

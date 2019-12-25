package com.codeinvestigator.springbootjavaandkotlin.space;

import com.codeinvestigator.springbootjavaandkotlin.space.navigation.Destination;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class NavigationRestController {

    @GetMapping(value="/nav/destinations", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Destination> destinations(){
        return Flux.just(
                new Destination("Mars"),
                new Destination("Jupiter"),
                new Destination("Venus"),
                new Destination("Pluto"),
                new Destination("Mercury")
        ).delayElements(Duration.ofSeconds(2));
    }
}

package com.digitalinnovationone.heroesapi.controller;

import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
    private final HeroesService heroesService;

    public HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllItems() {
        log.info("Requesting the list of all heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new hero is being created");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity deleteByIdHero(@PathVariable String id) {
        log.info("Deleting hero with id {}", id);
        var success = heroesService.deleteById(id).block();
        return success ? ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
    }
}

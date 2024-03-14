package com.digitalinnovationone.heroesapi.service;

import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.repository.HeroesRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAll() {
        return Flux.fromIterable(heroesRepository.findAll());
    }

    public Mono<Heroes> findById(String id) {
        return Mono.justOrEmpty(heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteById(String id) {
        try {
            heroesRepository.deleteById(id);
            return Mono.just(true);
        } catch (EmptyResultDataAccessException e) {
            return Mono.just(false);
        }
    }
}

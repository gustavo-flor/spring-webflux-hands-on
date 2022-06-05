package com.github.gustavoflor.springwebfluxhandson.controller;

import com.github.gustavoflor.springwebfluxhandson.dto.CreateUserDTO;
import com.github.gustavoflor.springwebfluxhandson.dto.UpdateUserDTO;
import com.github.gustavoflor.springwebfluxhandson.dto.UserDTO;
import com.github.gustavoflor.springwebfluxhandson.entity.User;
import com.github.gustavoflor.springwebfluxhandson.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDTO> create(@Valid @RequestBody final Mono<CreateUserDTO> dtoMono) {
        return userService.create(dtoMono).map(UserDTO::of);
    }

    @PutMapping("/{id}")
    public Mono<UserDTO> update(@PathVariable final String id, @Valid @RequestBody final Mono<UpdateUserDTO> dtoMono) {
        return userService.update(id, dtoMono).map(UserDTO::of);
    }

    @GetMapping("/{id}")
    public Mono<UserDTO> findById(@PathVariable final String id) {
        return userService.findById(id).map(UserDTO::of);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable final String id) {
        return userService.deleteById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> findAll() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(userService.findAll(), interval, (key, value) -> key);
    }
}

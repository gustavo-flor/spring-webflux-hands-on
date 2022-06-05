package com.github.gustavoflor.springwebfluxhandson.service;

import com.github.gustavoflor.springwebfluxhandson.dto.CreateUserDTO;
import com.github.gustavoflor.springwebfluxhandson.dto.UpdateUserDTO;
import com.github.gustavoflor.springwebfluxhandson.entity.User;
import com.github.gustavoflor.springwebfluxhandson.exception.NotFoundException;
import com.github.gustavoflor.springwebfluxhandson.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> create(final Mono<CreateUserDTO> dtoMono) {
        return dtoMono.map(User::of).flatMap(userRepository::save);
    }

    public Mono<User> update(final String id, final Mono<UpdateUserDTO> dtoMono) {
        return dtoMono.flatMap(dto -> findById(id).map(user -> user.merge(dto)).flatMap(userRepository::save));
    }

    public Mono<User> findById(final String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException()));
    }

    public Mono<Void> deleteById(final String id) {
        return userRepository.deleteById(id);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}

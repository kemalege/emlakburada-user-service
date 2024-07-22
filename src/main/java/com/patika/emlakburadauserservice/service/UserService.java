package com.patika.emlakburadauserservice.service;

import com.patika.emlakburadauserservice.converter.UserConverter;
import com.patika.emlakburadauserservice.dto.request.UserGetByEmailRequest;
import com.patika.emlakburadauserservice.dto.request.UserSaveRequest;
import com.patika.emlakburadauserservice.exception.EmlakBuradaException;
import com.patika.emlakburadauserservice.exception.ExceptionMessages;
import com.patika.emlakburadauserservice.model.User;
import com.patika.emlakburadauserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void save(UserSaveRequest request) {

        Optional<User> foundUser = userRepository.findByEmail(request.getEmail());

        if (foundUser.isPresent()) {
            log.error(ExceptionMessages.EMAIL_ALREADY_EXIST);
            throw new EmlakBuradaException(ExceptionMessages.EMAIL_ALREADY_EXIST);
        }

        User customer = UserConverter.toUser(request);

        userRepository.save(customer);

        log.info("customer created. {}", customer.getEmail());
    }

    public List<User> getUserList() {
        log.info("customer listed. ");
        return userRepository.findAll();
    }

    public User getById(Long id) {

        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
            log.error(ExceptionMessages.USER_NOT_FOUND);
            throw new EmlakBuradaException(ExceptionMessages.USER_NOT_FOUND);
        }

        return foundUser.get();
    }

    public User getByEmail(UserGetByEmailRequest email) {

        Optional<User> foundUser = userRepository.findByEmail(email.getEmail());

        if (foundUser.isEmpty()) {
            log.error(ExceptionMessages.USER_NOT_FOUND_BY_EMAIL);
            throw new EmlakBuradaException(ExceptionMessages.USER_NOT_FOUND_BY_EMAIL);
        }
        log.info("customer found. {}", email);
        return foundUser.get();
    }
}

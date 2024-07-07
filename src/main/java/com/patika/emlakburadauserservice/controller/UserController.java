package com.patika.emlakburadauserservice.controller;

import com.patika.emlakburadauserservice.dto.request.UserSaveRequest;
import com.patika.emlakburadauserservice.dto.response.GenericResponse;
import com.patika.emlakburadauserservice.model.User;
import com.patika.emlakburadauserservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void save(@RequestBody UserSaveRequest request) {
        userService.save(request);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public GenericResponse<User> getById(@PathVariable Long id) {

        User user = userService.getById(id);

        return GenericResponse.success(user);
    }

    @GetMapping("/email/{email}")
    public GenericResponse<User> getByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return GenericResponse.success(user);
    }

}
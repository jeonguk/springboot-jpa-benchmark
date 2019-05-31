package com.jeonguk.web.controller;

import com.jeonguk.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/test1")
    public ResponseEntity persistTestOne() {
        userService.jpaPersistBench();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test2")
    public ResponseEntity persistTestTwo() {
        userService.jpaCompositeKeyPersistBench();
        return ResponseEntity.ok().build();
    }

}

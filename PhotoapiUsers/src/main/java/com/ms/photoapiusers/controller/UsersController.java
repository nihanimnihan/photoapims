package com.ms.photoapiusers.controller;

import com.ms.photoapiusers.dto.UserDto;
import com.ms.photoapiusers.model.CreateUserRequestModel;
import com.ms.photoapiusers.model.CreateUserResponseModel;
import com.ms.photoapiusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final Environment env;
    private final UserService userService;

    @GetMapping("/status/check")
    public String status() {

        return "Working on port: " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel requestModel) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto createUser = userService.createUser(mapper.map(requestModel, UserDto.class));

        return new ResponseEntity<>(mapper.map(createUser, CreateUserResponseModel.class), HttpStatus.CREATED);
    }
}

package io.service.user.userservice.api.controllers;

import io.service.user.userservice.core.utilities.results.DataResult;
import io.service.user.userservice.core.utilities.results.Result;
import io.service.user.userservice.entities.dtos.userSaveRequestDto;
import io.service.user.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody userSaveRequestDto user) {
        return this.userService.add(user);
    }
    @GetMapping("/user")
    public DataResult getByName(@RequestParam String username) {
        return this.userService.findByUsername(username);
    }
    @GetMapping("/getUser")
    public DataResult getById(@RequestParam List<Integer> userId){
        return this.userService.getById(userId);
    }

}

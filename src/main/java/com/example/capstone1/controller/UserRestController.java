package com.example.capstone1.controller;

import com.example.capstone1.domain.Board;
import com.example.capstone1.domain.User;
import com.example.capstone1.dto.UserDto;
import com.example.capstone1.service.BoardService;
import com.example.capstone1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/login")
    public UserDto.LoginResDto login(@RequestBody UserDto.LoginReqDto param){
        return userService.login(param);
    }

    @PostMapping("/signup")
    public UserDto.CreateResDto signup(@RequestBody UserDto.CreateReqDto param){
        return userService.signup(param);
    }
    @GetMapping("/id")
    public boolean id(@RequestParam String username){
        return userService.id(username);
    }
    @PostMapping("/create")
    public UserDto.CreateResDto create(@RequestBody UserDto.CreateReqDto param){
        return userService.create(param);
    }
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    @GetMapping("/detail")
    public User detail(@RequestParam Long id){
        return userService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return userService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return userService.delete(Long.parseLong(params.get("id") + ""));
    }
}
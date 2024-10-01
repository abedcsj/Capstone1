package com.example.capstone1.controller;
import com.example.capstone1.domain.User;


import com.example.capstone1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return userService.create(params);
    }
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public User detail(@RequestParam Integer id){
        return userService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return userService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return userService.delete(Integer.parseInt(params.get("id") + ""));
    }
    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam Map<String, Object> params){
       String username = params.get("username") + "";
       String password = params.get("password") + "";
       return userService.login(username, password);
    }
}
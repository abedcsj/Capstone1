package com.example.capstone1.service.impl;
import com.example.capstone1.domain.User;

import com.example.capstone1.repository.UserRepository;
import com.example.capstone1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Map<String, Object> create(Map<String, Object> params) {
        System.out.println("create");
        Map<String, Object> result = new HashMap<String, Object>();

        String username = (String) params.get("username");
        User user = userRepository.findByUsername(username);


        if(user == null){
            user = new User();
            user.setUsername((String) params.get("username"));
            user.setPassword((String) params.get("password"));
            user.setName((String) params.get("name"));
            user.setPhone((String) params.get("phone"));
            user = userRepository.save(user);

            result.put("id", user.getId());
        } else {
            result.put("id duplicated", user.getUsername());
        }
        return result;
    }
    @Override
    public Map<String, Object> update(Map<String, Object> params) {
        System.out.println("update");
        User user = userRepository.findById(Integer.parseInt(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
        if(params.get("username") != null) {
            user.setUsername((String) params.get("username"));
        }
        if(params.get("password") != null) {
            user.setPassword((String) params.get("password"));
        }
        if(params.get("name") != null) {
            user.setName((String) params.get("name"));
        }
        if(params.get("phone") != null) {
            user.setPhone((String) params.get("phone"));
        }
        userRepository.save(user);
        return null;
    }
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
    @Override
    public User detail(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }
    @Override
    public Map<String, Object> login (String username,String password){
        Map<String, Object> result=new HashMap<>();
        User user= userRepository.findByUsernameAndPassword(username,password);
        if(user!=null){
            result.put("status","success");
            return result;
        }else{
            result.put("status","fail");
        }
        return result;
    }
}
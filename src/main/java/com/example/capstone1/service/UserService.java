package com.example.capstone1.service;
import com.example.capstone1.domain.User;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    Map<String, Object> create(Map<String, Object> params);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Integer id);
    List<User> list();
    User detail(Integer id);
    Map<String,Object> login(String username,String password);
}




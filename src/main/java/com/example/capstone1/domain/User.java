package com.example.capstone1.domain;

import com.example.capstone1.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(unique=true, nullable=false)
    String username;
    @Column(nullable=false)
    String password;
    
    String name;
    String phone;

    public UserDto.CreateResDto toCreateResDto(){
        UserDto.CreateResDto res = new UserDto.CreateResDto();
        res.setId(getId());
        return res;
    }

}

package com.example.capstone1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
public class Notice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)@Setter
    private String title;
    @Setter
    private String content;
    @Column
    private Integer ViewCount=0;


    public void incrementViewCount(){
        this.ViewCount++;
    }
}

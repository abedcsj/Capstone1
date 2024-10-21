package com.example.capstone1.domain;


import com.example.capstone1.dto.FaqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Faq {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Setter
    private Long userId;

    @Setter @Column(nullable=false)
    private String title;
    @Setter @Column(nullable=false)
    private String content;

    private Faq(Long userId,String title,String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static Faq of(Long userId,String title,String content) {
        return new Faq(userId,title,content);
    }

    public FaqDto.CreateResDto toCreateResDto() {
        return FaqDto.CreateResDto.builder().id(id).build();
    }






}

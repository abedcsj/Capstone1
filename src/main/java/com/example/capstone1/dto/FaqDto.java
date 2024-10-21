package com.example.capstone1.dto;


import com.example.capstone1.domain.Faq;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class FaqDto {

    @Builder
    @Getter
    @Setter
    public static class CreateReqDto{
        private String title;
        private String content;
        private Long userId;

        public Faq toEntity(){
            return Faq.of(getUserId(), getTitle(), getContent());
        }
    }
    @Getter
    @Setter
    @Builder
    public static class CreateResDto{
        private Long id;
    }
    @Getter
    @Setter
    @Builder
    public static class UpdateReqDto{
        private Long id;
        private String title;
        private String content;
    }
    @Setter
    @Getter
    public static class DetailResDto{
        private Long id;
        private Long userId;
        private String title;
        private String content;
    }
}

package com.example.capstone1.dto;

import com.example.capstone1.domain.Notice;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class NoticeDto {

    @Getter
    @Setter
    public static class CreateReqDto{
        private String title;
        private String content;

    }
    @Getter
    @Setter
    public static class CreateResDto{
        private Long id;
    }
    @Getter
    @Setter
    public static class UpdateReqDto{
        private Long id;
        private String title;
        private String content;

    }
    @Getter
    @Setter
    public static class UpdateResDto{
        private Long id;

    }



}

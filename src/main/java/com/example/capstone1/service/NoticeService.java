package com.example.capstone1.service;

import com.example.capstone1.domain.Notice;
import com.example.capstone1.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {

    NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params);
    NoticeDto.UpdateResDto update(NoticeDto.UpdateReqDto params);
    Map<String, Object> delete(Long id);
    List<Notice> list();
    Notice detail(Long id);
}
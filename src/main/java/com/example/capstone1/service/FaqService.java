package com.example.capstone1.service;

import com.example.capstone1.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaqService {
    FaqDto.CreateResDto create(FaqDto.CreateReqDto param);
    void update(FaqDto.UpdateReqDto param);
    void delete(Long id);
    FaqDto.DetailResDto detail(Long id);
    List<FaqDto.DetailResDto>list();
}

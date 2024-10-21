package com.example.capstone1.mapper;

import com.example.capstone1.dto.FaqDto;

public interface FaqMapper {
    FaqDto.DetailResDto detail(Long id);
}
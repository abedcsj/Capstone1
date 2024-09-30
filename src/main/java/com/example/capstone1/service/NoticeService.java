package com.example.capstone1.service;

import com.example.capstone1.domain.Notice;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {

    Notice getNoticeByTitle(String title);
}

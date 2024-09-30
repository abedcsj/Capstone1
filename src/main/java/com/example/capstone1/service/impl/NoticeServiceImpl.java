package com.example.capstone1.service.impl;

import com.example.capstone1.domain.Notice;
import com.example.capstone1.repository.NoticeRepository;
import com.example.capstone1.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public Notice getNoticeByTitle(String title){
        Notice notice=noticeRepository.findByTitle(title);
        notice.incrementViewCount();
        noticeRepository.save(notice);
        return notice;
    }
}

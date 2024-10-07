package com.example.capstone1.service.impl;

import com.example.capstone1.domain.Notice;
import com.example.capstone1.dto.NoticeDto;
import com.example.capstone1.repository.NoticeRepository;
import com.example.capstone1.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params) {
        System.out.println("create");
        Notice notice = new Notice();
        notice.setTitle(params.getTitle());
        notice.setContent(params.getContent());
        noticeRepository.save(notice);
        NoticeDto.CreateResDto resDto = new NoticeDto.CreateResDto();
        resDto.setId(notice.getId());
        return resDto;
    }

    @Override
    public NoticeDto.UpdateResDto update(NoticeDto.UpdateReqDto params) {
        System.out.println("update");
        Notice notice = noticeRepository.findById(params.getId()).orElse(null);
        if(params.getTitle() != null) {
            notice.setTitle(params.getTitle());
        }
        if(params.getContent() != null) {
            notice.setContent(params.getTitle());
        }
        noticeRepository.save(notice);
        return null;
    }

    @Override
    public List<Notice> list() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList;
    }
    @Override
    public Notice detail(Long id) {
        return noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        noticeRepository.delete(notice);
        return null;
    }
}
package com.example.capstone1.controller;

import com.example.capstone1.domain.Notice;
import com.example.capstone1.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<Notice> getNotice(@PathVariable String title) {
        Notice notice= noticeService.getNoticeByTitle(title);
        return ResponseEntity.ok(notice);
    }
}

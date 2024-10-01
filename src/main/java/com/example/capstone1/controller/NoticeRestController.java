package com.example.capstone1.controller;
import com.example.capstone1.domain.Notice;


import com.example.capstone1.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
@RequiredArgsConstructor
public class NoticeRestController {

    private final NoticeService noticeService;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return noticeService.create(params);
    }
    @GetMapping("/list")
    public List<Notice> list(){
        return noticeService.list();
    }
    @GetMapping("/detail")
    public Notice detail(@RequestParam Long id){
        return noticeService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return noticeService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return noticeService.delete(Long.parseLong(params.get("id") + ""));
    }
}
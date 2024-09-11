package com.example.capstone1.controller.page;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/board")
public class BoardController {


    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "board/"+page;
    }


}

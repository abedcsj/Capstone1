package com.example.capstone1.controller.page;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {


    @GetMapping("board/create")
    public String create() {
        return "board/create";
    }

    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "board/"+page;
    }


}

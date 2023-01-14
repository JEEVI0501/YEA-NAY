package com.poll.votingsystem;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Start {
    @RequestMapping("/start")
    public String getStart(Model model){
        return "home";
    }
}

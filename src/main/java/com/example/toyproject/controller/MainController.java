package com.example.toyproject.controller;

import com.example.toyproject.dto.ItemDto;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "home";
    }

}

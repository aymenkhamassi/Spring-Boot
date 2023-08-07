package com.aymen.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class CounterController {

    @GetMapping("counter")
    public String getCounter(HttpSession session, Model model) {
        int counter = getSessionCounter(session);
        model.addAttribute("counter", counter);
        return "counter.jsp";
    }

    @PostMapping("counter/increment")
    public String incrementCounter(HttpSession session) {
        int counter = getSessionCounter(session);
        session.setAttribute("counter", counter + 1);
        return "redirect:/counter";
    }

    @PostMapping("counter/incrementByTwo")
    public String incrementCounterByTwo(HttpSession session) {
        int counter = getSessionCounter(session);
        session.setAttribute("counter", counter + 2);
        return "redirect:/counter";
    }

    @PostMapping("counter/reset")
    public String resetCounter(HttpSession session) {
        session.setAttribute("counter", 0);
        return "redirect:/counter";
    }

    private int getSessionCounter(HttpSession session) {
        Object counterObj = session.getAttribute("counter");
        if (counterObj == null) {
            return 0;
        }
        return (int) counterObj;
    }
}

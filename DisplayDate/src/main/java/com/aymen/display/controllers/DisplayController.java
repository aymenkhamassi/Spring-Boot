package com.aymen.display.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DisplayController {

    @GetMapping("/")
    public String home() {
        return "index.jsp";
    }

    @GetMapping("/date")
    public String date(Model model) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
        String formattedDate = dateFormat.format(currentDate);
        model.addAttribute("formattedDate", formattedDate);
        return "date.jsp";
    }

    @GetMapping("/time")
    public String time(Model model) {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(currentDate);
        model.addAttribute("formattedTime", formattedTime);
        return "time.jsp";
    }
}


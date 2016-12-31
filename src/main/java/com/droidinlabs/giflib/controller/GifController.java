package com.droidinlabs.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {

    @RequestMapping("/")
    @ResponseBody
    public String listGifs() {
        return "List of Gifs";
    }

    @RequestMapping("/gif")
    @ResponseBody
    public String gifDetail() {
        return "Details of Gif";
    }
}

package com.droidinlabs.giflib.controller;

import com.droidinlabs.giflib.data.GifRepository;
import com.droidinlabs.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> gifs = gifRepository.getAllGifs();
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetail(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/search")
    public String getSearch(@RequestParam("q") String q, ModelMap modelMap) {
        List<Gif> gifs = gifRepository.search(q);
        modelMap.put("gifs", gifs);
        return "home";
    }
}

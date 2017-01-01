package com.droidinlabs.giflib.controller;

import com.droidinlabs.giflib.data.GifRepository;
import com.droidinlabs.giflib.model.Category;
import com.droidinlabs.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavoritesController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap map) {
        List<Gif> gifs= gifRepository.findByFavorite();
        map.put("gifs", gifs);
        return "favorites";
    }
}

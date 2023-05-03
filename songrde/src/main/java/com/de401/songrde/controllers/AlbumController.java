package com.de401.songrde.controllers;

import com.de401.songrde.models.Album;
import com.de401.songrde.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model model) {
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);

        return "albums";
    }


    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int lengthInSeconds, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, lengthInSeconds, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

}

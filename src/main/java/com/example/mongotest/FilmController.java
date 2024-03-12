package com.example.mongotest;

import com.example.mongotest.document.Film;
import com.example.mongotest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/all")
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

}

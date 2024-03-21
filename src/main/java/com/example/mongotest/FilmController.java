package com.example.mongotest;

import com.example.mongotest.document.Film;
import com.example.mongotest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/all")
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @GetMapping("/findByName")
    public List<Film> findByName(@RequestParam(name = "name") String name) {
        return filmRepository.findByName(name);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Film film) {
        filmRepository.create(film);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/updateRating/{id}")
    public ResponseEntity updateRating(@PathVariable("id") String id,
                             @RequestParam(name = "rating") Integer rating) {
        filmRepository.updateRating(id, rating);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity remove(@RequestParam(name = "id") String id) {
        filmRepository.remove(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

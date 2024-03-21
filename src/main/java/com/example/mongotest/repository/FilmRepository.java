package com.example.mongotest.repository;

import com.example.mongotest.document.Film;

import java.util.List;

public interface FilmRepository {

    void create(Film film);

    void updateRating(String id, Integer rating);

    List<Film> findAll();

    List<Film> findByName(String name);

    void remove(String id);
}

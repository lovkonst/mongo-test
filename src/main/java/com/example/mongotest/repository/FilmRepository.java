package com.example.mongotest.repository;

import com.example.mongotest.document.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FilmRepository extends MongoRepository<Film, String> {

    @Query("{name:'?0'}")
    Film findByName(String name);

}

package com.example.mongotest.repository.impl;

import com.example.mongotest.document.Film;
import com.example.mongotest.repository.FilmRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    private final MongoTemplate mongoTemplate;

    public FilmRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * db.films.insertOne({
     *     id: "2",
     *     name: "Pulp Fiction",
     *     rating: 8
     * })
     */
    @Override
    public void create(Film film) {
        mongoTemplate.insert(film);
    }

    /**
     * db.films.updateOne(
     *     {_id: ObjectId("65f0ac0085ba37210d40fc75") },
     *     {
     *         $set: {
     *             rating: 5
     *         }
     *     }
     * )
     */
    @Override
    public void updateRating(String id, Integer rating) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("rating", rating);

        mongoTemplate.updateFirst(query, update, Film.class);
    }

    /**
     * db.films.find()
     */
    @Override
    public List<Film> findAll() {
        return mongoTemplate.findAll(Film.class);
    }

    /**
     * db.films.find({
     *     name: 'Pulp Fiction'
     * })
     */
    @Override
    public List<Film> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.find(query, Film.class);
    }

    /**
     * db.films.deleteOne(
     *     { _id : ObjectId("65fc8d45aa81f16c58198754") }
     * )
     */
    @Override
    public void remove(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Film.class);
    }
}

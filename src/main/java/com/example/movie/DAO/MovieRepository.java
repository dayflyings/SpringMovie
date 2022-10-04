package com.example.movie.DAO;

import com.example.movie.model.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<MovieEntity, Long> {
}

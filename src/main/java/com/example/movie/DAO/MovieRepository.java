package com.example.movie.DAO;

import com.example.movie.Model.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<MovieEntity, Long> {
}

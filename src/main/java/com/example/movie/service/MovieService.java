package com.example.movie.service;

import com.example.movie.model.MovieEntity;

import java.util.List;

public interface MovieService {
    List<MovieEntity> getAllMovie();

    MovieEntity getMovieById(Long id);

    MovieEntity addMovie(MovieEntity movie);
}

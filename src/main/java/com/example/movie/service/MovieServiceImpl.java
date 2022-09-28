package com.example.movie.service;

import com.example.movie.DAO.MovieRepository;
import com.example.movie.Model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepo;

    @Override
    public List<MovieEntity> getAllMovie() {
        return movieRepo.findAll();
    }

    @Override
    public MovieEntity getMovieById(Long id) {
        return movieRepo.findById(id).get();
    }

    @Override
    public MovieEntity addMovie(MovieEntity movie) {
        return movieRepo.save(movie);
    }
}

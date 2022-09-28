package com.example.movie.controller;

import com.example.movie.Model.MovieEntity;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieEntity>> getAllMovies() {
        List<MovieEntity> result = movieService.getAllMovie();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}/")
    public ResponseEntity<MovieEntity> getMovieById(@PathVariable Long id) {
        MovieEntity result = movieService.getMovieById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieEntity> saveMovie(@RequestBody MovieEntity movie) {
        MovieEntity savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

}

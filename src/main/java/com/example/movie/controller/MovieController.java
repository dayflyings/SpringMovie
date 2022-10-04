package com.example.movie.controller;

import com.example.movie.exception.GeneralException;
import com.example.movie.exception.MovieNotFoundException;
import com.example.movie.model.ErrorResponse;
import com.example.movie.model.MovieEntity;
import com.example.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieEntity>> getAllMovies() {
        List<MovieEntity> result = movieService.getAllMovie();
        if (result == null || result.size() == 0) throw new MovieNotFoundException("Can't find any movie!");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}/")
    public ResponseEntity<MovieEntity> getMovieById(@PathVariable Long id) {
        MovieEntity result = movieService.getMovieById(id);
        if (result == null) throw new MovieNotFoundException("Can't find movie with id: " + id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieEntity> saveMovie(@RequestBody MovieEntity movie) {
        MovieEntity savedMovie = movieService.addMovie(movie);
        if (savedMovie == null) throw new GeneralException("Save movie failed");
        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        logger.error("An error happened.");
        ErrorResponse er = new ErrorResponse();
        er.setCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerMovieNotFound(Exception e) {
        logger.error("Can't find movie!");
        ErrorResponse er = new ErrorResponse();
        er.setCode(HttpStatus.NOT_FOUND.value());
        er.setMessage(e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

}

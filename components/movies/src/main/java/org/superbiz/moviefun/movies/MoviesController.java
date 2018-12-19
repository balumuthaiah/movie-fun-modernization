package org.superbiz.moviefun.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        moviesRepository.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        moviesRepository.deleteMovieId(id);
    }

    @GetMapping("/count")
    public int count(@RequestParam(name = "field", required = false) String field, @RequestParam(name = "key", required = false) String key) {
        if (field != null && key != null){
            return moviesRepository.count(field, key);
        }
        else{
            return moviesRepository.countAll();
        }
    }

    @GetMapping
    public List<Movie> find(@RequestParam(name = "field", required = false) String field,
                            @RequestParam(name = "key", required = false) String searchTerm,
                            @RequestParam(name = "start", required = false) Integer firstResult,
                            @RequestParam(name = "pageSize", required = false) Integer maxResults) {
        if (field != null && searchTerm != null) {
            return moviesRepository.findRange(field, searchTerm, firstResult, maxResults);
        } else if (firstResult != null && maxResults != null) {
            return moviesRepository.findAll(firstResult, maxResults);
        } else {
            return moviesRepository.getMovies();
        }
    }

}

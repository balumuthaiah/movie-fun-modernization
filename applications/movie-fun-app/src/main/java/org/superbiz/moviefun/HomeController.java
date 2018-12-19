package org.superbiz.moviefun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.superbiz.moviefun.albums.Album;
//import org.superbiz.moviefun.albums.AlbumFixtures;
//import org.superbiz.moviefun.albums.AlbumsClient;
//import org.superbiz.moviefun.albumsapi.AlbumFixtures;
//import org.superbiz.moviefun.albumsapi.AlbumInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MovieFixtures;
import org.superbiz.moviefun.moviesapi.MovieInfo;
import org.superbiz.moviefun.moviesapi.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesClient;
    private final MovieFixtures movieFixtures;
    private final AlbumsClient albumsClient;
//    private final AlbumFixtures albumFixtures;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    public HomeController(MoviesClient moviesClient, AlbumsClient albumsClient,
//                          MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
//        this.moviesClient = moviesClient;
//        this.albumsClient = albumsClient;
//        this.movieFixtures = movieFixtures;
//        this.albumFixtures = albumFixtures;
//    }

    public HomeController(MoviesClient moviesClient, MovieFixtures movieFixtures, AlbumsClient albumsClient) {
        this.moviesClient = moviesClient;
        this.movieFixtures = movieFixtures;
        this.albumsClient = albumsClient;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

//        for (AlbumInfo album : albumFixtures.load()) {
//            albumsClient.addAlbum(album);
//        }
//
        model.put("movies", moviesClient.getMovies());
//        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }

    @GetMapping("/albums")
    public String getAlbums(Map<String, Object> model) {
        model.put("movies", albumsClient.getAlbums());
        return "albums";
    }

    @GetMapping("/albums/{id}")
    public String find(@PathVariable long id, Map<String, Object> model) {
        model.put("movies", albumsClient.findAll(id));
        return "albumDetails";
    }
}

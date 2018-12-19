package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;
import org.superbiz.moviefun.moviesapi.MovieInfo;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private final String albumsUrl;
    private final RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public List<AlbumInfo> findAll(long id) {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
        //return restOperations.exchange(albumsUrl + "/" + id, GET, null, albumListType).getBody().get(1);
    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }
}

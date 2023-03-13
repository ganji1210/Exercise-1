package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.enums.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre>genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;


    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        movies.add(new Movie("TEST1", "Is a nice Movie", Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION)));
        movies.add(new Movie("TEST2", "Strong austrian guy", Arrays.asList(Genre.CRIME, Genre.DOCUMENTARY, Genre.FAMILY)));
        movies.add(new Movie("TEST3", "Is a bad movie", Arrays.asList(Genre.COMEDY, Genre.MUSICAL, Genre.HISTORY)));



        return movies;
    }
}

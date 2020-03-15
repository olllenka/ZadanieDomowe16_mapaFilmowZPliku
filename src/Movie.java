import java.util.ArrayList;

public class Movie {
    private String movieId;
    private String title;
    private ArrayList<String> genres;

    public Movie() {
    }

    public Movie(String movieId, String title, ArrayList<String> genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
}

public class Rating {
    private String userId;
    private String movieId;
    private Double rating;

    public Rating() {
    }

    public Rating(String userId, String movieId, Double rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public Double getRating() {
        return rating;
    }
}

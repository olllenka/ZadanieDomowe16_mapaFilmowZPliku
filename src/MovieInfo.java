import java.io.FileNotFoundException;
import java.util.*;

public class MovieInfo {
    public static void main(String[] args) {

        String fileName = "movies.csv";
        List<Movie> movies = null;
        try {
            movies = MovieReader.createMovieListFromFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku!");
        }

        System.out.println("Ilość filmów: " + movies.size());
        System.out.println("Liczba filmów w każdej kategorii: \n" + MovieReader.createMovieMap((ArrayList<Movie>) movies));
        System.out.println();

        String ratingFileName = "ratings.csv";
        List<Rating> ratings = null;
        try {
            ratings = RatingReader.createRatingListFromFile(ratingFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku!");
        }

        System.out.println("Ilość ocen: " + ratings.size());
        Map<Double, Integer> ratingMap = RatingReader.createRatingMap((ArrayList<Rating>) ratings);
        System.out.println("Ilość poszczególnych ocen: \n" + ratingMap);
        System.out.println("Najczęściej powtarzająca się ocena " + mostPopularRating(ratingMap));
    }

    private static Double mostPopularRating(Map<Double, Integer> ratingMap) {
        Double mostPopularRating = Double.valueOf(0);
        Integer mostPopularRatingValue = 0;
        Set<Double> keys = ratingMap.keySet();
        for (Double key : keys) {
            if(ratingMap.get(key)>mostPopularRatingValue){
                mostPopularRatingValue=ratingMap.get(key);
                mostPopularRating=key;
            }
        }
        return mostPopularRating;
    }
}

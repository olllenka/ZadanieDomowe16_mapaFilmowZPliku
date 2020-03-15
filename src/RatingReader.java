import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RatingReader {

    static List<Rating> createRatingListFromFile(String FileName) throws FileNotFoundException {
        File file = new File(FileName);
        Scanner sc = new Scanner(file);
        sc.nextLine();

        List<Rating> ratings = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] ratingLine = sc.nextLine().split(",");
            Rating rating = createRating(ratingLine);
            ratings.add(rating);
        }
        sc.close();
        return ratings;
    }

    private static Rating createRating(String[] ratingLine) {
        Rating rating = new Rating();
        rating.setUserId(ratingLine[0]);
        rating.setMovieId(ratingLine[1]);
        rating.setRating(Double.valueOf(ratingLine[2]));
        return rating;
    }

    static Map<Double, Integer> createRatingMap(ArrayList<Rating> ratingList) {
        Map<Double, Integer> ratingMap = new TreeMap<>();
        for (Rating rating : ratingList) {
            if (ratingMap.containsKey(rating.getRating())) {
                ratingMap.put(rating.getRating(), ratingMap.get(rating.getRating()) + 1);
            } else {
                ratingMap.put(rating.getRating(), 1);
            }
        }
        return ratingMap;
    }
}

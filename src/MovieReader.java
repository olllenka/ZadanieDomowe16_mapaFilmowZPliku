import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieReader {

    static List<Movie> createMovieListFromFile(String FileName) throws FileNotFoundException {
        File file = new File(FileName);
        Scanner sc = new Scanner(file);
        sc.nextLine();

        List<Movie> movies = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] movieLine = sc.nextLine().split(",");
            if(movieLine.length==3) {
                Movie movie = createMovie(movieLine);
                movies.add(movie);
            }
        }
        sc.close();
        return movies;
    }

    private static Movie createMovie(String[] movieLine) {
        Movie movie = new Movie();
        movie.setMovieId(movieLine[0]);
        movie.setTitle(movieLine[1]);
        movie.setGenres(genresArrayList(movieLine[2]));
        return movie;
    }

    private static ArrayList<String> genresArrayList(String s) {
        ArrayList<String> genresArrayList = new ArrayList<>();
        String[] genresLines = s.split("\\|");
        for(int i=0; i<genresLines.length; i++){
            genresArrayList.add(genresLines[i]);
        }
        return genresArrayList;
    }

    static Map<String, Integer> createMovieMap(ArrayList<Movie> movieList) {
        Map<String, Integer> movieMap = new TreeMap<>();
        for (Movie movie : movieList) {
            List<String> genres = movie.getGenres();
            for (String genre : genres) {
                if (movieMap.containsKey(genre)) {
                    movieMap.put(genre, movieMap.get(genre)+1);
                }
                else {
                    movieMap.put(genre, 1);
                }
            }
        }
        return movieMap;
    }
}

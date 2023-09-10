package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class MovieType implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> movieAnime = new ArrayList<>();
        for(Anime anime: animeList) {
            if(anime.getType().equalsIgnoreCase("Movie")) {
                movieAnime.add(anime);
            }
        }
        return movieAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        return anime.getType().equals("Movie");
    }
}

package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class MovieType implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> movieAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            if(anime.getType().equals("Movie")) {
                movieAnime.add(anime);
            }
        }
        return movieAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        if(anime!=null && anime.getType().equals("Movie"))
            return true;
        return false;
    }
}

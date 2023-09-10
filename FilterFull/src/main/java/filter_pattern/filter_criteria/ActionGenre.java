package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class ActionGenre implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> actionAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Action")) {
                actionAnime.add(anime);
            }
        }
        return actionAnime;
    }

    @Override
    public boolean meetsCriteria(Anime anime) {
        if(anime.getGenre().contains("Action"))
            return true;
        return false;
    }
}

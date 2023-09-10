package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class AdventureGenre implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> adventureAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Adventure")) {
                adventureAnime.add(anime);
            }
        }
        return adventureAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        if(anime.getGenre().contains("Adventure"))
            return true;
        return false;
    }
}

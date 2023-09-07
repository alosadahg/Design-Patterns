package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventureCriteria implements Criteria{

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
        if(anime!=null && anime.getGenre().contains("Adventure"))
            return true;
        return false;
    }
}

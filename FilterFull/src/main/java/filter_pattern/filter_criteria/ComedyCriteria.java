package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComedyCriteria implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> comedyAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Comedy")) {
                comedyAnime.add(anime);
            }
        }
        return comedyAnime;
    }
}

package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanceCriteria implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> romanceAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Romance")) {
                romanceAnime.add(anime);
            }
        }
        return romanceAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        if(anime!=null && anime.getGenre().contains("Romance"))
            return true;
        return false;
    }
}

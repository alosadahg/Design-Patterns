package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysteryCriteria implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> mysteryAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Mystery")) {
                mysteryAnime.add(anime);
            }
        }
        return mysteryAnime;
    }
}

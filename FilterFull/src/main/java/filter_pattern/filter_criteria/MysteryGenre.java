package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class MysteryGenre implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> mysteryAnime = new ArrayList<>();
        for(Anime anime: animeList) {
            List<String> genre = anime.getGenre();
            if(genre.contains("Mystery")) {
                mysteryAnime.add(anime);
            }
        }
        return mysteryAnime;
    }

    @Override
    public boolean meetsCriteria(Anime anime) {
        return anime.getGenre().contains("Mystery");
    }
}

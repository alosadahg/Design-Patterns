package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class SeriesType implements Criteria{

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> TVAnime = new ArrayList<Anime>();
        for(Anime anime: animeList) {
            if(anime!=null && anime.getType().equalsIgnoreCase("TV")) {
                TVAnime.add(anime);
            }
        }
        return TVAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        if(anime.getType().equals("TV"))
            return true;
        return false;
    }
}

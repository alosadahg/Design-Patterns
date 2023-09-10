package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class AndCriteria implements Criteria{
    private final List<Criteria> criterias;

    public AndCriteria(List<Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> filteredAnime = new ArrayList<>();

        for(Anime ani: animeList) {
            if(meetsCriteria(ani)) {
                filteredAnime.add(ani);
            }
        }

        return filteredAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        for (Criteria criteria : criterias) {
            if(!criteria.meetsCriteria(anime)) {
                return false;
            }
        }
        return true;
    }
}

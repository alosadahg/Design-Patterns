package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.ArrayList;
import java.util.List;

public class OrCriteria implements Criteria {
    private List<Criteria> criterias;

    public OrCriteria(List<Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> filteredAnime = new ArrayList<Anime>();

        for (Criteria criteria : criterias) {
            filteredAnime.addAll(criteria.meetsCriteria(animeList));
        }

        return filteredAnime;
    }
}

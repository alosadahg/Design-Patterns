package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.List;

public class AndCriteria implements Criteria{
    private List<Criteria> criterias;

    public AndCriteria(List<Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public List<Anime> meetsCriteria(List<Anime> animeList) {
        List<Anime> filteredAnime = animeList;

        for (Criteria criteria : criterias) {
            filteredAnime = criteria.meetsCriteria(filteredAnime);
        }

        return filteredAnime;
    }
    @Override
    public boolean meetsCriteria(Anime anime) {
        boolean flag = false;
        for (Criteria criteria : criterias) {
            if(criteria.meetsCriteria(anime)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}

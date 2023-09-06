package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.List;

public interface Criteria {
    List<Anime> meetsCriteria(List<Anime> animeList);
}

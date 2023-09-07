package filter_pattern.filter_criteria;

import filter_pattern.Anime;

import java.util.List;

public interface Criteria {
    //filter for entire collection
    List<Anime> meetsCriteria(List<Anime> animeList);
    //filter for a single member of a collection
    boolean meetsCriteria(Anime anime);
}

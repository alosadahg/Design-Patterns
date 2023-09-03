package filter_pattern;

import java.util.ArrayList;
import java.util.List;

public class AnimeFactory {
    public List<Anime> generateAnimeList() {
        List<Anime> animeList = new ArrayList<Anime>();
        animeList.add(new Anime("Assassination Classroom", "Lerche", "Winter 2015","TV", new String[]{"Action", "Comedy"}));
        animeList.add(new Anime("Attack on Titan", "Wit Studio", "Spring 2013","TV", new String[]{"Action", "Mystery"}));
        animeList.add(new Anime("Berserk", "OLM", "Fall 1997","TV", new String[]{"Action", "Adventure", "Romance"}));
        animeList.add(new Anime("Black Butler: Book of the Atlantic", "A-1 Pictures", "Winter 2017","Movie", new String[]{"Action", "Comedy"}));
        animeList.add(new Anime("Dennou Coil", "Madhouse", "Spring 2007","TV", new String[]{"Adventure","Comedy","Mystery"}));
        animeList.add(new Anime("Death Note", "Madhouse", "Fall 2006","TV", new String[]{"Mystery"}));
        animeList.add(new Anime("Erased", "A-1 Pictures", "Winter 2016","TV", new String[]{"Mystery"}));
        animeList.add(new Anime("Fairy Tail", "Satelight", "Fall 2009","TV", new String[]{"Action", "Adventure", "Comedy"}));
        animeList.add(new Anime("Kamisama Kiss", "TMS Entertainment", "Fall 2012","TV", new String[]{"Comedy", "Romance"}));
        animeList.add(new Anime("Kiki's Delivery Service", "Studio Ghibli", "Summer 1989","Movie", new String[]{"Adventure", "Comedy", "Romance"}));
        animeList.add(new Anime("Made In Abyss", "Kinema Citrus", "Summer 2017","TV", new String[]{"Adventure", "Mystery"}));
        animeList.add(new Anime("My Hero Academia", "Bones", "Spring 2016","TV", new String[]{"Action", "Comedy"}));
        animeList.add(new Anime("My Neighbor Totoro", "Studio Ghibli", "Spring 1988","Movie", new String[]{"Adventure", "Comedy"}));
        animeList.add(new Anime("Naruto Shippuuden", "Studio Pierrot", "Winter 2007","TV", new String[]{"Action", "Adventure", "Comedy"}));
        animeList.add(new Anime("Noragami", "Bones", "Winter 2014","TV", new String[]{"Action", "Adventure", "Comedy"}));
        animeList.add(new Anime("One Punch Man", "Madhouse", "Fall 2015","TV", new String[]{"Action", "Comedy"}));
        animeList.add(new Anime("Porco Rosso", "Studio Ghibli", "Summer 1992","Movie", new String[]{"Action", "Adventure", "Comedy", "Romance"}));
        animeList.add(new Anime("Rurouni Kenshin (Samurai X)", "Studio Deen", "Winter 1996","TV", new String[]{"Action", "Adventure", "Comedy", "Romance"}));
        animeList.add(new Anime("The Disappearance of Haruhi Suzumiya", "Kyoto Animation", "Winter 2010","Movie", new String[]{"Comedy", "Mystery", "Romance"}));

        return animeList;
    }
}

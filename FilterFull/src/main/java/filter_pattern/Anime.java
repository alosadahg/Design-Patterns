package filter_pattern;

import java.util.List;

public class Anime {
    private String title;
    private  String studio;
    private  String releaseDate;
    private String type;
    private List<String> genre;

    public Anime(String title, String studio, String releaseDate, String type, List<String> genre) {
        this.title = title;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.type = type;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getStudio() {
        return studio;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getType() {
        return type;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void printAnime(int titleSpacing, int studioSpacing) {
        String titleSpace = "%-" + titleSpacing + "s";
        String studioSpace = "%-" + studioSpacing + "s";
        String format = "Title: " + titleSpace + "  Type: %-5s" + "  Studio: " + studioSpace +
                "  Release Date: %-11s" + "  Genre: ";
        System.out.print(String.format(format, title, type, studio, releaseDate));
        String separator = "";
        for(String g: genre) {
            System.out.print(separator + g);
            separator = ",";
        }
        System.out.println();
    }
}

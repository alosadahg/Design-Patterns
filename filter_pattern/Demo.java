package filter_pattern;

import filter_pattern.filter_criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        AnimeFactory animeFactory = new AnimeFactory();
        System.out.println("Welcome to KBP's Anime Filter!");
        Scanner scan = new Scanner(System.in);

        List<Anime> animeList = animeFactory.generateAnimeList();

        ActionCriteria action = new ActionCriteria();
        AdventureCriteria adventure = new AdventureCriteria();
        ComedyCriteria comedy = new ComedyCriteria();
        MysteryCriteria mystery = new MysteryCriteria();
        RomanceCriteria romance = new RomanceCriteria();

        String input;
        boolean flag = true;

        while(flag==true){
            List<Criteria> criterias = new ArrayList<Criteria>();
            do {
                System.out.println(String.format("Please select a genre:\n%-8s %-11s %-8s %-9s %-10s %-6s", "Action", "Adventure", "Comedy", "Mystery", "Romance", "Done"));
                input = scan.nextLine().toLowerCase();
                switch (input) {
                    case "action":
                        criterias.add(action);
                        break;
                    case "adventure":
                        criterias.add(adventure);
                        break;
                    case "comedy":
                        criterias.add(comedy);
                        break;
                    case "mystery":
                        criterias.add(mystery);
                        break;
                    case "romance":
                        criterias.add(romance);
                        break;
                    case "done":
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            } while (!input.equals("done"));
            if(criterias.isEmpty()) {
                flag = false;
                break;
            }
            System.out.println("Perform an exact-match filter? Y/N");
            String exact = scan.nextLine().toLowerCase();
            System.out.println("\nHere is the generated list of anime:");
            if (exact.charAt(0) == 'y') {
                AndCriteria searchGenre = new AndCriteria(criterias);
                printAnimeList(searchGenre.meetsCriteria(animeList));
            } else {
                OrCriteria searchGenre = new OrCriteria(criterias);
                printAnimeList(searchGenre.meetsCriteria(animeList));
            }

            System.out.println("\nPerform another filter? Y/N");
            String again = scan.nextLine().toLowerCase();
            if (again.charAt(0) != 'y') {
                flag = false;
                break;
            }
        }
        System.out.println("\nThank you for using KBP's Anime Filter!");
    }

    public static void printAnimeList(List<Anime> animeList) {
        List<String> animeTitles = new ArrayList<String>();
        List<String> animeStudios = new ArrayList<String>();
        for(Anime a: animeList) {
            animeTitles.add(a.getTitle());
            animeStudios.add(a.getStudio());
        }
        int titleSpacing = animeTitles.stream().map(String::length).max(Integer::compareTo).get();
        int studioSpacing = animeStudios.stream().map(String::length).max(Integer::compareTo).get();
        for(Anime a: animeList) {
            a.printAnime(titleSpacing,studioSpacing);
        }
    }
}

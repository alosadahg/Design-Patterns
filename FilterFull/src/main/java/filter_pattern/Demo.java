package filter_pattern;

import filter_pattern.filter_criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ExcelReader reader = new ExcelReader();
        System.out.println("Welcome to KBP's Anime Filter!");
        System.out.println("Loading...");

        List<Anime> animeList = reader.generateAnime();

        ActionCriteria action = new ActionCriteria();
        AdventureCriteria adventure = new AdventureCriteria();
        ComedyCriteria comedy = new ComedyCriteria();
        MysteryCriteria mystery = new MysteryCriteria();
        RomanceCriteria romance = new RomanceCriteria();

        String input;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
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
        System.out.println("\nThank you for using " +
                "KBP's Anime Filter!");
    }

    public static void printAnimeList(List<Anime> animeList) {
        int titleMax = 0;
        int studioMax = 0;
        for(Anime a: animeList) {
            int tLen = a.getTitle().length();
            int sLen = a.getStudio().length();
            if(tLen > titleMax)
                titleMax = tLen;
            if(sLen > studioMax)
                studioMax = sLen;
        }
        for(Anime a: animeList) {
            a.printAnime(titleMax,studioMax);
        }
    }
}

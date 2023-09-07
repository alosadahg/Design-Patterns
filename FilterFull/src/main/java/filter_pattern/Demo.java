package filter_pattern;

import filter_pattern.filter_criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        AnimeSource reader = new AnimeSource();
        System.out.println("Welcome to KBP's Anime Filter");
        System.out.println("Find the perfect anime to watch!");

        List<Anime> animeList = reader.generateAnime();

        ActionCriteria action = new ActionCriteria();
        AdventureCriteria adventure = new AdventureCriteria();
        ComedyCriteria comedy = new ComedyCriteria();
        MysteryCriteria mystery = new MysteryCriteria();
        RomanceCriteria romance = new RomanceCriteria();

        String input;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        List<String> criteriasAdded = new ArrayList<>();
        List<Criteria> criterias = new ArrayList<Criteria>();

        while(flag==true){
            System.out.printf("Filter the anime by:\n%-7s %-8s %-7s", "Type", "Genre", "Exit");
            System.out.println("\n(You can select multiple filters, just separate them with a comma.\nIf you select exit, the filter will not execute)");
            String filterS = scan.nextLine().toLowerCase();
            if(filterS.contains("exit")) {
                flag = false;
                break;
            }
            List<String> filter = new ArrayList<String>();
            if(filterS.contains("type")) {
                filter.add("Type");
            }
            if(filterS.contains("genre")) {
                filter.add("Genre");
            }
            if(filterS.contains("studio")) {
                filter.add("Studio");
            }
            printStringList(filter,"filters");
            if(!criteriasAdded.isEmpty()) {
                System.out.println("Do you want to use the same genres you have selected recently? Y/N");
                String reuse = scan.nextLine().toLowerCase();
                if (reuse.charAt(0) != 'y') {
                    criteriasAdded.clear();
                    criterias.clear();
                }
            }
            if(criteriasAdded.isEmpty() && filter.contains("Genre")) {
                System.out.printf("Please enter a genre (you may also select multiple genres, just separate them with a comma):\n%-8s %-11s %-8s %-9s %-10s%n", "Action", "Adventure", "Comedy", "Mystery", "Romance");
                input = scan.nextLine().toLowerCase();
                if(input.contains("action")) {
                    criterias.add(action);
                    criteriasAdded.add("Action");
                }
                if(input.contains("adventure")) {
                    criterias.add(adventure);
                    criteriasAdded.add("Adventure");
                }
                if(input.contains("comedy")) {
                    criterias.add(comedy);
                    criteriasAdded.add("Comedy");
                }
                if(input.contains("mystery")) {
                    criterias.add(mystery);
                    criteriasAdded.add("Mystery");
                }
                if(input.contains("romance")) {
                    criterias.add(romance);
                    criteriasAdded.add("Romance");
                }
                if(criterias.isEmpty()) {
                    flag = false;
                    break;
                }
            }
            printStringList(criteriasAdded,"genres");
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

    public static void printStringList(List<String> sList, String id) {
        System.out.println("Here are the " + id + " selected:");
        int last = sList.size()-1;
        int i = 0;
        for(String s: sList) {
            System.out.print(s);
            if(i!=last) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println();
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

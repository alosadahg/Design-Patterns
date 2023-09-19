package filter_pattern;

import filter_pattern.filter_criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        AnimeSource reader = new AnimeSource();
        System.out.println("Welcome to KBP's Anime Filter");
        System.out.println("Find the perfect anime to watch!\n");

        List<Anime> animeList = reader.generateAnime();

        ActionGenre action = new ActionGenre();
        AdventureGenre adventure = new AdventureGenre();
        ComedyGenre comedy = new ComedyGenre();
        MysteryGenre mystery = new MysteryGenre();
        RomanceGenre romance = new RomanceGenre();
        MovieType movie = new MovieType();
        SeriesType tv = new SeriesType();

        Scanner scan = new Scanner(System.in);
        List<String> genresAdded = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> filter = new ArrayList<>();


        while(true){
            List<Criteria> filtersSelected = new ArrayList<>();
            filter = reuseSelection(filter, "filter","%-7s %-8s %-7s",new String[] {"Type", "Genre", "Exit"});
            if(filter.isEmpty()) {
                break;
            }

            if(filter.contains("Type"))
                type = reuseSelection(type, "type", "%-7s %-4s", new String[]{"Movie", "Series"});
            if(filter.contains("Genre"))
                genresAdded = reuseSelection(genresAdded, "genre","%-8s %-11s %-8s %-9s %-10s", new String[]{"Action", "Adventure", "Comedy", "Mystery", "Romance"});

            if(type.contains("Movie") && !type.contains("Series")) {
                filtersSelected.add(movie);
            }
            else if (type.contains("Series") && !type.contains("Movie")) {
                filtersSelected.add(tv);
            }
            if(genresAdded.contains("Action")) {
                filtersSelected.add(action);
            }
            if(genresAdded.contains("Adventure")) {
                filtersSelected.add(adventure);
            }
            if(genresAdded.contains("Comedy")) {
                filtersSelected.add(comedy);
            }
            if(genresAdded.contains("Mystery")) {
                filtersSelected.add(mystery);
            }
            if(genresAdded.contains("Romance")) {
                filtersSelected.add(romance);
            }

            List<Anime> filtered = null;

            AndCriteria andSearch = new AndCriteria(filtersSelected);

            System.out.println("How do you want to filter? " +
                    "\n1. Include the chosen filters\n");
            int chosen = scan.nextInt();
            scan.nextLine();
            if(chosen==1) {
                filtered = andSearch.meetsCriteria(animeList);
            } else {
                System.out.println("Invalid input.");
            }

            System.out.println("\nHere is the generated list of anime:");

            if(!(filtered != null && filtered.isEmpty()))
                printAnimeList(filtered);
            else
                System.out.println("(There is no anime found with those filters. Please try again.)");

            System.out.println("\nPerform another filter? Y/N");
            String again = scan.next().toLowerCase();
            scan.nextLine();
            if (again.charAt(0) != 'y') {
                break;
            }
        }
        System.out.println("\nThank you for using " +
                "KBP's Anime Filter!");
    }

    public static void printStringList(List<String> sList, String id) {
        System.out.println("\nHere are the " + id + " selected:");
        int last = sList.size()-1;
        int i = 0;
        for(String s: sList) {
            System.out.print(s);
            if(i!=last) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("\n");
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
        int count = 0;
        for(Anime a: animeList) {
            a.printAnime(titleMax,studioMax);
            count++;
        }
        System.out.println("Anime generated: " + count);
    }
    public static List<String> reuseSelection(List<String> l1, String id, String spacing, String[] options) {
        Scanner scan = new Scanner(System.in);
        if(!l1.isEmpty()) {
            System.out.println("Do you want to use the same " + id +
                    " you have selected recently? Y/N");
            String reuse = scan.next().toLowerCase();
            scan.nextLine();
            if (reuse.charAt(0) != 'y')
                l1.clear();
        }
        if(l1.isEmpty()) {
            l1 = getSelection(id,spacing, options);
            while(l1.contains("Invalid")) {
                System.out.println("Invalid input. Please try again");
                l1 = getSelection(id,spacing, options);
            }
        }
        printStringList(l1,id);
        return l1;
    }

    private static List<String> getSelection (String id, String spacing, String[] options) {
        Scanner scan = new Scanner(System.in);
        String input;
        List<String> filter = new ArrayList<>();
        System.out.printf("Please enter a " + id + " (you may also select multiple " + id +"s, " +
                "just separate each " + id + " with a comma)\n"  +
                "Example input: " + options[0] + "," + options[1] +
                "\nAvailable " +id+ "s: " +spacing, (Object[]) options);
        System.out.print("\nInput chosen " + id + "s: ");
        input = scan.nextLine().toLowerCase();
        if(input.contains("exit")) {
            return filter;
        }
        boolean flag = false;
        for(String o: options) {
            if(input.contains(o.toLowerCase())) {
                filter.add(o);
                flag = true;
            }
        }
        if(!flag) filter.add("Invalid");
        return filter;
    }
}

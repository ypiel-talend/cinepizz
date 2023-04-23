package org.cinepizz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CinepizzCli {

    private static List<String> members = new ArrayList<>(Arrays.asList("Yves", "Julien", "Étienne"));
    private static List<String> genres = new ArrayList<>(Arrays.asList("Action", "Animation", "Aventure", "Comédie", "Drame", "fantastique", "Guerre", "Historique", "horreur", "Musical", "Nanar", "Policier", "Science fiction", "Thriller", "Western"));
    private static List<Integer> decads = new ArrayList<>(Arrays.asList(1950, 1960, 1970, 1980, 1990, 2000, 2010, 2020));


    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 2; i++) {
            fakeComputation(3000, 250);
            Random random = new Random();
            String who = members.remove(random.nextInt(members.size()));
            String genreA = genres.remove(random.nextInt(genres.size()));
            String genreB = genres.remove(random.nextInt(genres.size()));
            Integer decad = decads.remove(random.nextInt(decads.size()));
            System.out.printf("%s devra choisir un film de la décennie '%s' correspondant aux genres: %s & %s.\n\n", who, decad, genreA, genreB);
        }
    }

    private static void fakeComputation(int second, int pause) throws InterruptedException {
        System.out.print("Recherche des meilleurs critères...");
        int dots = second / pause;
        for(int i=0; i< dots; i++){
            TimeUnit.MILLISECONDS.sleep(pause);
            System.out.print(".");
        }
        System.out.println("");
    }


}

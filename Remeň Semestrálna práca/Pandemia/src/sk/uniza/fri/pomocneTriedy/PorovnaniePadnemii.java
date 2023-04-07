package sk.uniza.fri.pomocneTriedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PorovnaniePadnemii {

    /**
     * 20. 5. 2021 - 2:45
     *
     * @author Matúš Remeň
     * Trieda slúži na načítanie pandémie, a následné porovnanie
     *
     */
//načíta 2 pandemia a porovná ich v terminále
    public static class PorovnaniePandemie {
        public static void porovnajPandemie() {
            String nazov;
            int pocetLudi;
            int pocetZodpovednych;
            int pocetMrtvych;
            int pocetVyliecenych;
            double priemernyVek;
            double priemernyVekMrtvych;
            int trvanie;

            String nazov2;
            int pocetLudi2;
            int pocetZodpovednych2;
            int pocetMrtvych2;
            int pocetVyliecenych2;
            double priemernyVek2;
            double priemernyVekMrtvych2;
            int trvanie2;


            Scanner s = new Scanner(System.in);
            System.out.println("Zadajte názov 1. pandémie:");
            String nazovPandemie = s.next();

            String cesta = "C:\\Users\\Gamer\\Desktop\\Remeň Semestrálna práca\\Vystupy\\" + nazovPandemie + ".txt";
            try {
                File subor = new File(cesta);
                Scanner sc = new Scanner(subor);
                nazov = sc.nextLine();
                pocetLudi = Integer.parseInt(sc.nextLine());
                pocetZodpovednych = Integer.parseInt(sc.nextLine());
                pocetMrtvych = Integer.parseInt(sc.nextLine());
                pocetVyliecenych = Integer.parseInt(sc.nextLine());
                priemernyVek = Double.parseDouble(sc.nextLine());
                priemernyVekMrtvych = Double.parseDouble(sc.nextLine());
                trvanie = Integer.parseInt(sc.nextLine());
                sc.close();

            } catch (FileNotFoundException e) {
                System.out.println("Súbor neexistuje, skúste skontrolovať názov");
                return;
            }
            System.out.println("Zadajte názov 2. pandémie:");
            String nazovPandemie2 = s.next();
            String cesta2 = "C:\\Users\\Gamer\\Desktop\\Remeň Semestrálna práca\\Vystupy\\" + nazovPandemie2 + ".txt";
            try {
                File subor2 = new File(cesta2);
                Scanner sc2 = new Scanner(subor2);
                nazov2 = sc2.nextLine();
                pocetLudi2 = Integer.parseInt(sc2.nextLine());
                pocetZodpovednych2 = Integer.parseInt(sc2.nextLine());
                pocetMrtvych2 = Integer.parseInt(sc2.nextLine());
                pocetVyliecenych2 = Integer.parseInt(sc2.nextLine());
                priemernyVek2 = Double.parseDouble(sc2.nextLine());
                priemernyVekMrtvych2 = Double.parseDouble(sc2.nextLine());
                trvanie2 = Integer.parseInt(sc2.nextLine());
                sc2.close();

            } catch (FileNotFoundException e) {
                System.out.println("Súbor neexistuje, skúste skontrolovať názov");
                return;
            }

            System.out.println("Porovnanie pandémii: ");
            System.out.printf("%-20s %-20s  %-20s %n" , nazov, "nazov" ,  nazov2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , pocetLudi, "Počet Ľudí" ,  pocetLudi2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , pocetZodpovednych, "Počet Zodpovedných" ,  pocetZodpovednych2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , pocetMrtvych, "Počet Mŕtvych" ,  pocetMrtvych2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , pocetVyliecenych, "Počet Vyliečených" ,  pocetVyliecenych2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , priemernyVek, "Priemerný vek" ,  priemernyVek2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , priemernyVekMrtvych, "Priemerný vek2" ,  priemernyVekMrtvych2);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s  %-20s %n" , trvanie , "Počet Dní" ,  trvanie2);

        }
    }




}

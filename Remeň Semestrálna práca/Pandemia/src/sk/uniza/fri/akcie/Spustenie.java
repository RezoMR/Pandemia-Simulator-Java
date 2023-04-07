package sk.uniza.fri.akcie;


import sk.uniza.fri.pomocneTriedy.PorovnaniePadnemii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */

public class Spustenie {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Chcete Porovnať pandémie alebo simulovať novu?");
        System.out.println("Simulovať--- Napíšte 1");
        System.out.println("Porovnať--- Napíšte 2");
        System.out.println("Ukončiť--- 0");
        int moznost = s.nextInt();

        int pocet;
        int pocetDni;
        int zodpovedni;
        switch (moznost) {
            case 1:
                Pandemia pandemia = new Pandemia();
                System.out.println("Zadajte počet ľudí v každej krajine: ");
                try {
                    pocet = s.nextInt();
                } catch (InputMismatchException I) {
                    System.out.println("Zadali ste zlý vstup, spustite program znova a zadajte správny vstup");
                    return;
                }

                System.out.println("Zadajte počet zodpovedných ľudí v každej krajine: ");
                try {
                    zodpovedni = s.nextInt();
                } catch (InputMismatchException I) {
                    System.out.println("Zadali ste zlý vstup, spustite program znova a zadajte správny vstup");
                    return;
                }
                System.out.println("Zadajte názov pandémie: ");

                String nazov = s.next();


                System.out.println("Zadajte počet dní pandémie: ");
                try {
                    pocetDni = s.nextInt();
                } catch (InputMismatchException I) {
                    System.out.println("Zadali ste zlý vstup, spustite program znova a zadajte správny vstup");
                    return;
                }
                if (pocet < zodpovedni) {
                    System.out.println("Zadali ste viac zodpovedných ako ľudí, začnite program znova (trest za pokúšanie bol zabitý čas v podobe zbytočného vypĺňania :) ");
                    return;
                } else {
                    pandemia.zacniPandemiu(pocet, zodpovedni);


                    pandemia.postavNemocnicu();
                    int i = 0;
                    while (i < pocetDni) {
                        pandemia.pridajDen();
                        pandemia.pridajStarsichNakazenychDoNemocnice();
                        i++;
                    }


                    System.out.println(pandemia.vratPocetLudi() + "Ludia");
                    System.out.println(pandemia.vratPocetNakazenych() + "Nakazeny");
                    System.out.println(pandemia.vratPocetVyliecenych() + "Vylieceny");
                    System.out.println(pandemia.vratPocetMrtvych() + "Mrtvy");
                    System.out.println(pandemia.vratPocetZodpovednych() + "Zodpovedny");
                    System.out.println(pandemia.vratPocetNezodpovednych() + "Nezodpovedny");
                    System.out.println(pandemia.vratPocetLudiVNemocniciach() + "V nemocniciach");
                    System.out.println(pandemia.priemernyVek() + "Priemerny Vek");
                    System.out.println(pandemia.najvacsiPocetMrtvychVKrajine() + " najviac mrtvych bolo v tejto krajine");
                    System.out.println(pandemia.priemernyVekMrtvych() + "priemerny vek mrtvych");


                    //zapis do suboru
                    try {
                        File subor = new File("C:\\Users\\Gamer\\Desktop\\Remeň Semestrálna práca\\Vystupy\\" + nazov + ".txt");
                        if (subor.createNewFile()) {
                            System.out.println("Súbor vytvorený: " + subor.getName());
                        } else {
                            System.out.println("Súbor už existuje.");
                        }
                    } catch (IOException e) {
                        System.out.println("Chybička se vloudila.");
                        e.printStackTrace();
                    }

                    try {
                        FileWriter zapisovac = new FileWriter("C:\\Users\\Gamer\\Desktop\\Remeň Semestrálna práca\\Vystupy\\" + nazov + ".txt");
                        zapisovac.write(nazov + "\n");
                        zapisovac.write(pandemia.vratPocetLudi() + "\n");
                        zapisovac.write(zodpovedni + "\n");
                        zapisovac.write(pandemia.vratPocetMrtvych() + "\n");
                        zapisovac.write(pandemia.vratPocetVyliecenych() + "\n");
                        zapisovac.write(pandemia.priemernyVek() + "\n");
                        zapisovac.write(pandemia.priemernyVekMrtvychZapis() + "\n");
                        //zapisovac.write(pocetDni + "\n");

                        zapisovac.close();
                        System.out.println("Úspešne zapísané");
                    } catch (IOException e) {
                        System.out.println("Chybička se vloudila");
                        e.printStackTrace();
                    }
                }
                return;
            case 2:
                PorovnaniePadnemii.PorovnaniePandemie.porovnajPandemie();
                return;
            case 0:
                return;

            default:
                System.out.println("Zadali ste zlé číslo...");
        }
    }

}



package sk.uniza.fri.akcie;

import sk.uniza.fri.budovy.Nemocnica;
import sk.uniza.fri.kPPH.KRAJINAPOVODU;
import sk.uniza.fri.kPPH.POHLAVIE;
import sk.uniza.fri.lieky.ILieky;
import sk.uniza.fri.lieky.Liecik;
import sk.uniza.fri.lieky.SuperLiek;
import sk.uniza.fri.ludia.Nakazeny;
import sk.uniza.fri.ludia.IClovek;
import sk.uniza.fri.ludia.Nezodpovedny;
import sk.uniza.fri.ludia.Zodpovedny;
import sk.uniza.fri.ludia.Vylieceny;
import sk.uniza.fri.ludia.Mrtvy;
import sk.uniza.fri.ludia.ZoznamLudi;
import sk.uniza.fri.pomocneTriedy.Nahodne;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
//Vytvorí pandémiu, ľudí podľa zadaných parametrov, pridá deň, vracia počty..
public class Pandemia {
    private final ZoznamLudi<IClovek> ludia;
    private Nemocnica nemocnica;


    public Pandemia() {
        this.ludia = new ZoznamLudi<>();
    }

    public int vratPocetLudi() {
        return this.ludia.vratVelkost();
    }

    public int vratPocetZodpovednych() {
        int pocet = 0;
        for (int i = 0; this.ludia.vratVelkost() > i; i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Zodpovedny")) {
                pocet++;
            }
        }
        return pocet;
    }

    public int vratPocetNezodpovednych() {
        int pocet = 0;
        for (int i = 0; this.ludia.vratVelkost() > i; i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Nezodpovedny")) {
                pocet++;
            }
        }
        return pocet;
    }

    public int vratPocetVyliecenych() {
        int pocet = 0;
        for (int i = 0; this.ludia.vratVelkost() > i; i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Vylieceny")) {
                pocet++;
            }
        }
        return pocet;
    }

    public int vratPocetMrtvych() {
        int pocet = 0;
        for (int i = 0; this.ludia.vratVelkost() > i; i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Mrtvy")) {
                pocet++;
            }
        }
        return pocet;
    }

    public int vratPocetNakazenych() {
        int pocet = 0;
        for (int i = 0; this.ludia.vratVelkost() > i; i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Nakazeny")) {
                pocet++;
            }
        }
        return pocet;
    }

    //vytvori ludi a pridá ich do zoznamu
    public void zacniPandemiu(int pocetLudi, int zodpovedny) {
        for (int i = 0; i < zodpovedny; i++) {
            POHLAVIE pohSK;
            if (Nahodne.od1do2() == 1) {
                pohSK = POHLAVIE.ZENA;
            } else {
                pohSK = POHLAVIE.MUZ;
            }
            IClovek slovak = new Zodpovedny(Nahodne.od1do100(), pohSK, KRAJINAPOVODU.SLOVENSKO, "peto" + i);
            this.ludia.pridaj(slovak);
            POHLAVIE pohCZ;
            if (Nahodne.od1do2() == 1) {
                pohCZ = POHLAVIE.ZENA;
            } else {
                pohCZ = POHLAVIE.MUZ;
            }
            IClovek cesko = new Zodpovedny(Nahodne.od1do100(), pohCZ, KRAJINAPOVODU.CESKO, "peto" + i);
            this.ludia.pridaj(cesko);
            POHLAVIE pohMD;
            if (Nahodne.od1do2() == 1) {
                pohMD = POHLAVIE.ZENA;
            } else {
                pohMD = POHLAVIE.MUZ;
            }
            IClovek clovek = new Zodpovedny(Nahodne.od1do100(), pohMD, KRAJINAPOVODU.MADARSKO, "peto" + i);
            this.ludia.pridaj(clovek);
        }
        for (int i = 0; i < (pocetLudi - zodpovedny); i++) {
            POHLAVIE pohSK;
            if (Nahodne.od1do2() == 1) {
                pohSK = POHLAVIE.ZENA;
            } else {
                pohSK = POHLAVIE.MUZ;
            }
            IClovek slovak = new Nezodpovedny(Nahodne.od1do100(), pohSK, KRAJINAPOVODU.SLOVENSKO, "peto" + i);
            this.ludia.pridaj(slovak);
            POHLAVIE pohCZ;
            if (Nahodne.od1do2() == 1) {
                pohCZ = POHLAVIE.ZENA;
            } else {
                pohCZ = POHLAVIE.MUZ;
            }
            IClovek cech = new Nezodpovedny(Nahodne.od1do100(), pohCZ, KRAJINAPOVODU.CESKO, "peto" + (i));
            this.ludia.pridaj(cech);
            POHLAVIE pohMD;
            if (Nahodne.od1do2() == 1) {
                pohMD = POHLAVIE.ZENA;
            } else {
                pohMD = POHLAVIE.MUZ;
            }
            IClovek madar = new Nezodpovedny(Nahodne.od1do100(), pohMD, KRAJINAPOVODU.MADARSKO, "peto" + i);
            this.ludia.pridaj(madar);
        }
    }

    //určuje či sa ludia nakazia, vyliečia, alebo zomru.
    public void pridajDen() {
        for (int i = 0; i < this.ludia.vratVelkost(); i++) {
            if (this.ludia.vratCloveka(i) instanceof Zodpovedny) {
                if (this.ludia.vratCloveka(i).getSancaNakazenia() == 100) {
                    IClovek clovek = new Nakazeny(this.ludia.vratCloveka(i).getVek(), this.ludia.vratCloveka(i).getPohlavie(), this.ludia.vratCloveka(i).getKrajinaPovodu(), this.ludia.vratCloveka(i).getMeno(), this.ludia.vratCloveka(i).getPopis());
                    this.ludia.odober(this.ludia.vratCloveka(i));
                    this.ludia.pridaj(clovek);
                }
            }
            if (this.ludia.vratCloveka(i) instanceof Nezodpovedny) {
                if (this.ludia.vratCloveka(i).getSancaNakazenia() == 100) {
                    IClovek clovek = new Nakazeny(this.ludia.vratCloveka(i).getVek(), this.ludia.vratCloveka(i).getPohlavie(), this.ludia.vratCloveka(i).getKrajinaPovodu(), this.ludia.vratCloveka(i).getMeno(), this.ludia.vratCloveka(i).getPopis());
                    this.ludia.odober(this.ludia.vratCloveka(i));
                    this.ludia.pridaj(clovek);
                }
            }
            if (this.ludia.vratCloveka(i) instanceof Nakazeny) {
                boolean liek = false;
                if (((Nakazeny)this.ludia.vratCloveka(i)).vratDniChoroby() >= 10) {
                    IClovek clovek = new Vylieceny(this.ludia.vratCloveka(i).getVek(), this.ludia.vratCloveka(i).getPohlavie(), this.ludia.vratCloveka(i).getKrajinaPovodu(), this.ludia.vratCloveka(i).getMeno());
                    this.nemocnica.odober(this.ludia.vratCloveka(i));
                    this.ludia.odober(this.ludia.vratCloveka(i));
                    this.ludia.pridaj(clovek);
                } else {
                    if (((Nakazeny)this.ludia.vratCloveka(i)).getSancaUmrtia() == 100) {
                        if (this.nemocnica.ciObsahuje(this.ludia.vratCloveka(i))) {
                            if (this.ludia.vratCloveka(i).getVek() >= 80) {
                                liek = this.nemocnica.spotrebujSuperLiek(this.ludia.vratCloveka(i));
                            }
                        } else {
                            liek = this.nemocnica.spotrebujLiecik(this.ludia.vratCloveka(i));
                        }
                        if (liek) {
                            IClovek mrtvy = new Mrtvy(this.ludia.vratCloveka(i).getVek(), this.ludia.vratCloveka(i).getPohlavie(), this.ludia.vratCloveka(i).getKrajinaPovodu(), this.ludia.vratCloveka(i).getMeno());
                            this.nemocnica.odober(this.ludia.vratCloveka(i));
                            this.ludia.odober(this.ludia.vratCloveka(i));
                            this.ludia.pridaj(mrtvy);
                        }
                    } else {
                        ((Nakazeny)this.ludia.vratCloveka(i)).pridajDenChoroby();
                    }
                }
            }
        }

    }

    //vytvori nemocnicu a prida lieky podla poctu ludi
    public void postavNemocnicu() {
        this.nemocnica = new Nemocnica(this.ludia.vratVelkost() / 4);
        ILieky liek = new SuperLiek(this.vratPocetLudiNad80() / 100);
        ILieky liecik = new Liecik(this.ludia.vratVelkost() / 20);
        this.nemocnica.pridajLieky(liek);
        this.nemocnica.pridajLieky(liecik);
    }

    //prida ludi nad 60 do nemocnice, dokym nenaplni kapacitu
    public void pridajStarsichNakazenychDoNemocnice() {
        for (int i = 0; i < this.ludia.vratVelkost(); i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Nakazeny") && this.ludia.vratCloveka(i).getVek() > 60 && !this.nemocnica.ciObsahuje(this.ludia.vratCloveka(i)) && this.nemocnica.vratPocetVolnychMiest() > 0) {
                this.nemocnica.pridajCloveka(this.ludia.vratCloveka(i));
            }
        }
    }
    public int vratPocetLudiVNemocniciach() {
        return this.nemocnica.vratPocetLudi();
    }

    private int vratPocetLudiNad80() {
        int pocet = 0;
        for (int i = 0; i < this.ludia.vratVelkost(); i++) {
            if (this.ludia.vratCloveka(i).getVek() >= 80) {
                pocet++;
            }
        }
        return pocet;
    }




 //Triedy čo vrátia alebo vypočítaju priemery, počty.

    protected double priemernyVek() {
        double vek = 0;
        double pocetLudi = this.ludia.vratVelkost();
        if (this.ludia.vratVelkost() == 0) {
            return 0;
        } else {
            for (int i = 0; i < this.ludia.vratVelkost(); i++) {
                vek = vek + this.ludia.vratCloveka(i).getVek();
                
            }
        }
        return (vek / pocetLudi);
    }

    protected double priemernyVekMrtvych() {
        double vek = 0;
        double pocetLudi = 0;
        for (int i = 0; i < this.ludia.vratVelkost(); i++) {
            if (this.ludia.vratCloveka(i).getPopis().equals("Mrtvy")) {
                pocetLudi++;
                vek = vek + this.ludia.vratCloveka(i).getVek();
            }
        }

        if (pocetLudi == 0) {
            return 0;
        } else {
            return (vek / pocetLudi);

        }
    }

    public String priemernyVekMrtvychZapis() {
        return String.valueOf(this.priemernyVekMrtvych());

    }


    public String najvacsiPocetMrtvychVKrajine() {
        int madari = 0;
        int slovaci = 0;
        int cesi = 0;
        for (int i = 0; i < this.ludia.vratVelkost(); i++) {
            if (this.ludia.vratCloveka(i).getKrajinaPovodu() == KRAJINAPOVODU.CESKO && this.ludia.vratCloveka(i).getPopis().equals("Mrtvy")) {
                cesi = cesi + 1;
            }
            if ((this.ludia.vratCloveka(i).getKrajinaPovodu() == KRAJINAPOVODU.SLOVENSKO && this.ludia.vratCloveka(i).getPopis().equals("Mrtvy"))) {
                slovaci = slovaci + 1;
            }
            if ((this.ludia.vratCloveka(i).getKrajinaPovodu() == KRAJINAPOVODU.MADARSKO && this.ludia.vratCloveka(i).getPopis().equals("Mrtvy"))) {
                madari = madari + 1;
            }
        }
        String meno = "";
        if (madari > slovaci && madari > cesi) {
            meno =  "madari";
        }
        if (cesi > slovaci && cesi > madari) {
            meno = "cesi";
        }
        if (slovaci > madari && slovaci > cesi) {
            meno = "slovaci";
        }
        if (slovaci == madari &&  madari == cesi) {
            meno = ("V Kazdej krajine zomrelo rovnako ludi" + madari);
        }

        return meno;
    }










}










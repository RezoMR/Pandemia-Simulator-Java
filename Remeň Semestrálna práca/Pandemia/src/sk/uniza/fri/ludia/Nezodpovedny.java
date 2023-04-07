package sk.uniza.fri.ludia;

import sk.uniza.fri.kPPH.KRAJINAPOVODU;
import sk.uniza.fri.kPPH.POHLAVIE;
import sk.uniza.fri.pomocneTriedy.Nahodne;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
//Nezodpovedný nenosí rúško, preto má väčšiu šancu sa nakaziť
public class Nezodpovedny implements IClovek {
    private final int vek;
    private final POHLAVIE pohlavie;
    private final KRAJINAPOVODU krajinapovodu;
    private final String meno;


    public Nezodpovedny(int vek, POHLAVIE pohlavie, KRAJINAPOVODU krajinapovodu, String meno) {
        this.vek = vek;
        this.pohlavie = pohlavie;
        this.krajinapovodu = krajinapovodu;
        this.meno = meno;
    }

    @Override
    public int getVek() {
        return this.vek;
    }

    @Override
    public POHLAVIE getPohlavie() {
        return this.pohlavie;
    }

    @Override
    public KRAJINAPOVODU getKrajinaPovodu() {
        return this.krajinapovodu;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public String getPopis() {
        return ("Nezodpovedny");
    }

    @Override
    public int getSancaNakazenia() {
        return this.vypocitajSancu();
    }

    private int vypocitajSancu() {
        int sanca = 0;
        if (this.getVek() >= 65) {
            if (Nahodne.od1do100() >= 50) {
                sanca = 100;
            }
        } else {
            if (Nahodne.od1do100() >= 65) {
                sanca = 100;
            }
        }
        return sanca;
    }

}

package sk.uniza.fri.ludia;

/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
import sk.uniza.fri.kPPH.KRAJINAPOVODU;
import sk.uniza.fri.kPPH.POHLAVIE;
//RIP
public class Mrtvy implements IClovek {
    private final int vek;
    private final POHLAVIE pohlavie;
    private final KRAJINAPOVODU krajinapovodu;
    private final String meno;


    public Mrtvy(int vek, POHLAVIE pohlavie, KRAJINAPOVODU krajinapovodu, String meno) {
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
        return ("Mrtvy");
    }

    @Override
    public int getSancaNakazenia() {
        return 0;
    }
}


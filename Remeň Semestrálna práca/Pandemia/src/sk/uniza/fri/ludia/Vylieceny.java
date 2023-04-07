package sk.uniza.fri.ludia;

import sk.uniza.fri.kPPH.KRAJINAPOVODU;
import sk.uniza.fri.kPPH.POHLAVIE;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
//vyliečený, už odolný voči ďalšiemu nakazeniu
public class Vylieceny implements IClovek {
    private final int vek;
    private final POHLAVIE pohlavie;
    private final KRAJINAPOVODU krajinapovodu;
    private final String meno;

    public Vylieceny(int vek, POHLAVIE pohlavie, KRAJINAPOVODU krajinapovodu, String meno) {
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
        return ("Vylieceny");
    }

    @Override
    public int getSancaNakazenia() {
        return 0;
    }

}

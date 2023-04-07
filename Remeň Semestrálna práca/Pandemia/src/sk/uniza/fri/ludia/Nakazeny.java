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
import sk.uniza.fri.pomocneTriedy.Nahodne;
//
public class Nakazeny implements IClovek {
    private final int vek;
    private final POHLAVIE pohlavie;
    private final KRAJINAPOVODU krajinapovodu;
    private final String meno;
    private int dniChoroby;
    private final String predok;

    public Nakazeny(int vek, POHLAVIE pohlavie, KRAJINAPOVODU krajinapovodu, String meno, String predok) {
        this.vek = vek;
        this.pohlavie = pohlavie;
        this.krajinapovodu = krajinapovodu;
        this.meno = meno;
        this.dniChoroby = 0;
        this.predok = predok;
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
        return ("Nakazeny");
    }

    @Override
    public int getSancaNakazenia() {
        return 0;
    }
    //prida den choroby, keď ich je nad10 vylieči sa
    public void pridajDenChoroby() {
        this.dniChoroby = this.dniChoroby + 1;
    }

    public int vratDniChoroby() {
        return this.dniChoroby;
    }

    public int getSancaUmrtia() {
        return this.vypocitajSancu();
    }

    //vypocita sancu nakazenia sa, ktora sa odvija od veku
    private int vypocitajSancu() {
        int sanca = 0;
        if (this.getVek() > 65) {
            if (this.predok.equals("Zodpovedny")) {
                if (Nahodne.od1do1000() > 700) {
                    sanca = 100;
                }
            }
            if (this.predok.equals("Nezodpovedny")) {
                if (Nahodne.od1do1000() > 500) {
                    sanca = 100;
                }
            }
            if (this.getVek() > 40 && this.vek < 65) {
                if (this.predok.equals("Zodpovedny")) {
                    if (Nahodne.od1do1000() > 800) {
                        sanca = 100;
                    }
                }
                if (this.predok.equals("Nezodpovedny")) {
                    if (Nahodne.od1do1000() > 550) {
                        sanca = 100;
                    }
                }
                if (this.getVek() < 40) {
                    if (this.predok.equals("Zodpovedny")) {
                        if (Nahodne.od1do1000() > 850) {
                            sanca = 100;
                        }
                    }
                    if (this.predok.equals("Nezodpovedny")) {
                        if (Nahodne.od1do1000() > 750) {
                            sanca = 100;
                        }
                    }
                }
            }
        }
        return sanca;
    }
}
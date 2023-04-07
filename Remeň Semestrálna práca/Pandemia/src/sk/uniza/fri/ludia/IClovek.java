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
//interface clovek od ktorého sa odvíjajú typy ľudí
public interface IClovek {
    int getVek();
    POHLAVIE getPohlavie();
    KRAJINAPOVODU getKrajinaPovodu();
    String getMeno();
    String getPopis();
    int getSancaNakazenia();
}

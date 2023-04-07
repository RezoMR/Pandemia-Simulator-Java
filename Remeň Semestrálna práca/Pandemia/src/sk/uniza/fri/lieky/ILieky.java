package sk.uniza.fri.lieky;

/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
import sk.uniza.fri.ludia.IClovek;
// interface lieky, od ktorého sa odvíjaju lieky
public interface ILieky {
    String getNazov();
    boolean spotrebuj(IClovek clovek);
}

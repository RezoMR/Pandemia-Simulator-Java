package sk.uniza.fri.lieky;

/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
import sk.uniza.fri.ludia.IClovek;
//vylieči človeka v určitý deň keď má zomrieť, ale človek musí mať nad 80 a byť v nemocnici
public class SuperLiek implements ILieky {
    private int pocet;

    public SuperLiek(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public String getNazov() {
        return "SuperLiek";
    }

    @Override
    public boolean spotrebuj(IClovek clovek) {
        boolean spotreboval = false ;
        if (clovek.getVek() >= 80 && this.pocet > 0) {
            this.pocet = this.pocet - 1;
            spotreboval = true;
        }
        return spotreboval;
    }

}




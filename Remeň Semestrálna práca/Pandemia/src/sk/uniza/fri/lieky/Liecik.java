package sk.uniza.fri.lieky;

/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
import sk.uniza.fri.ludia.IClovek;
import sk.uniza.fri.pomocneTriedy.Nahodne;

//Liecik može byť podávaný každému ale šanca že zabráni úmrtiu je 50%.
public class Liecik implements ILieky {

    private int pocet;

    public Liecik(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public String getNazov() {
        return "Liecik";
    }

    @Override
    public boolean spotrebuj(IClovek clovek) {
        boolean spotreboval = false;
        if (this.pocet > 0) {
            this.pocet = this.pocet - 1;
            if (Nahodne.od1do2() == 1) {
                spotreboval = true;
            }
        }
        return spotreboval;
    }

}

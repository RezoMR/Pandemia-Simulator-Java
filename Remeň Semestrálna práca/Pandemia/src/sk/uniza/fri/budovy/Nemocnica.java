package sk.uniza.fri.budovy;
import sk.uniza.fri.lieky.ILieky;
import sk.uniza.fri.ludia.IClovek;

import java.util.ArrayList;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 *
 *
 */
public class Nemocnica {
    private final int kapacita;
    private final ArrayList<IClovek> zoznamLudi;
    private final ArrayList<ILieky> zoznamliekov;


    public Nemocnica(int kapacita) {
        this.kapacita = kapacita;
        this.zoznamLudi = new ArrayList<>(kapacita);
        this.zoznamliekov = new ArrayList<>(2);
    }

    public void pridajCloveka(IClovek clovek) {
        if (!this.zoznamLudi.contains(clovek)) {
            this.zoznamLudi.add(clovek);
        }
    }

    public int vratPocetVolnychMiest() {
        return (this.kapacita - this.zoznamLudi.size());
    }

    public int vratPocetLudi() {
        return this.zoznamLudi.size();
    }

    public boolean ciObsahuje(IClovek clovek) {
        return this.zoznamLudi.contains(clovek);
    }

    public void odober(IClovek clovek) {
       // if (this.zoznamLudi.contains(clovek)) {
        this.zoznamLudi.remove(clovek);
      //  }
    }
    public void pridajLieky(ILieky liek) {
        this.zoznamliekov.add(liek);
    }


    public boolean spotrebujSuperLiek(IClovek clovek) {
        boolean spotrebuj = false;
        for (ILieky liek : this.zoznamliekov) {
            if (liek.getNazov().equals("SuperLiek")) {
                spotrebuj = liek.spotrebuj(clovek);
            }
        }
        return spotrebuj;
    }

    public boolean spotrebujLiecik(IClovek clovek) {
        boolean spotrebuj = false;
        for (ILieky liek : this.zoznamliekov) {
            if (liek.getNazov().equals("Liecik")) {
                spotrebuj = liek.spotrebuj(clovek);
            }
        }
        return spotrebuj;
    }


}

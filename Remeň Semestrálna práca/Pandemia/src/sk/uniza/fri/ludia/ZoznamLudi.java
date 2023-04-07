package sk.uniza.fri.ludia;

import java.util.ArrayList;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 * Trieda slúži ako katalóg
 *
 */
//Katalóg
public class ZoznamLudi<E extends IClovek> {
    private final ArrayList<E> zoznam;

    public ZoznamLudi() {
        this.zoznam = new ArrayList<>();
    }

    public void pridaj(E objekt) {
        this.zoznam.add(objekt);
    }

    public void odober(E objekt) {
        if (this.zoznam.contains(objekt)) {
            this.zoznam.remove(objekt);
        } else {
            System.out.println("Tento objekt v zozname ani nebol");
        }
    }


    public IClovek vratCloveka(int poradie) {
        if (poradie < this.zoznam.size()) {
            return this.zoznam.get(poradie);
        }
        return null;
    }

    public int vratVelkost() {
        return this.zoznam.size();
    }
}

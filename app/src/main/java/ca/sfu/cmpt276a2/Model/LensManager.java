package ca.sfu.cmpt276a2.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * A manager class handling an iterable list of Lens class objects for use.
 */
public class LensManager {

    private List<Lens> lens = new ArrayList<>();

    public LensManager(){
        lens.add(new Lens("Canon", 1.8, 50));
        lens.add(new Lens("Tamron", 2.8, 90));
        lens.add(new Lens("Sigma", 2.8, 200));
        lens.add(new Lens("Nikon", 4, 200));
    }
    public void add(Lens lens)
    {
        this.lens.add(lens);
    }
    public Lens getLensByID(Integer ID) {

        for(int i = 0; i < lens.size(); i++) {
            if (i == ID.intValue())
                return this.lens.get(ID);
            else
                continue;
        }
        throw new IndexOutOfBoundsException("Error: Invalid lens index.");
    }
}

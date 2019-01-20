import animal.Animal;
import animal.Cat;
import animal.Walrus;

import java.util.ArrayList;

public class Main {
    public static boolean allOneType(ArrayList<? extends Animal> a) {
        Class savedClass, currentClass;
        for (Animal animal: a) {
            currentClass = animal.getClass();
            if (savedClass == null) {
                savedClass = currentClass;
            } else if (savedClass != currentClass) {
                return false;
            }
        }
        return true;
    }

    public static boolean oneType(Animal a) {
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Walrus> walrusArray = new ArrayList<>();
        allOneType(walrusArray);
        oneType(new Walrus());
        oneType(new Cat());
    }
}

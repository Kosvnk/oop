

import java.awt.*;

/**
 * Class demonstrates methods from {@link aContainer}
 */
public class Main {

    public static void main(String[] args) {
        aContainer container1 = new aContainer();
        String string1 = new String();
        //Container's methods
        container1.add("asd");
        container1.add("dsa");
        container1.add("zxc");
        container1.add("*cxz*");
        container1.add("reverse");

        System.out.println("\nmethod size()");
        System.out.println("Size: " + container1.size());

        System.out.println("\nmethod toString()");
        System.out.println("toString: " + container1.toString());

        String[] s1 = container1.toArray();
        System.out.println("\nmethod toArray()");
        for (String s : s1) {
            System.out.println(s);
        }

        System.out.println("\nmethod contains()");
        System.out.println(container1.contains("Big"));

        System.out.println("\nmethod containsAll()");
        aContainer container2 = new aContainer();
        container2.add("asd");
        container2.add("dsa");
        container2.add("zxc");
        container2.add("*cxz*");
        container2.add("reverse");
        System.out.println("Should return true");
        System.out.println("Result: " + container1.containsAll(container2));

        System.out.println("\nmethod remove()");
        container1.remove("dsa");
        for (String s : container1) {
            System.out.println(s);
        }

        System.out.println("\nmethod clear()");
        container1.clear();
        for (String s : container1) {
            System.out.println(s);
        }

        // Using iterator's methods
        System.out.println("\nIterator's methods\n");
        aContainer.aIterator iterator = container2.iterator();
        for (String s : container2) {
            System.out.print(s + ' ');
        }
        System.out.println();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.remove();
        for (String s : container2) {
            System.out.print(s + ' ');
        }
        System.out.println();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.remove();
        for (String s : container2) {
            System.out.print(s + ' ');
        }
    }
}


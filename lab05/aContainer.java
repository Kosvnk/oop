


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class aContainer.
 * Contains the range of methods to manipulate a container.
 * Class is iterable - can be iterated element by element.
 */
public class aContainer implements Iterable<String> {

    /**
     * Holds the elements of a container.
     */
    private String[] values;

    /**
     * Constructor for making new string
     */
    public aContainer() {
        values = new String[0];
    }

    /**
     * Method concatenates all container elements into a string.
     *
     * @return container in a string
     */
    public String toString() {
        StringBuilder string = new StringBuilder(new String());
        for (String s : values)
            string.append(s + " ");
        return string.toString();
    }

    /**
     * Method for adding elements to a container.
     *
     * @param string - string to initialize a new container element
     */
    public boolean add(String string) {
        try {
            String[] temp = values;
            values = new String[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = string;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Method for resetting a container.
     */
    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }

    /**
     * Method for removing an exact element by string criteria.
     *
     * @param string string to specify the element to remove
     * @return false if removing cannot be done(no elements in container)
     * true if element has been found and successfully deleted
     */
    boolean remove(String string) {
        int pos = 0;
        for (int i = 0; i < values.length; i++) {
            if (Objects.equals(values[i], string)) {
                break;
            } else pos++;
        }
        try {
            String[] temp = values;
            values = new String[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, pos);
            int elemToDestinate = temp.length - pos - 1; //позиция, в которую нужно начинать копировать кроме вырезанного
            System.arraycopy(temp, pos + 1, values, pos, elemToDestinate);
            return true;
        } catch (ClassCastException ex) {
            System.err.println("Error ClassCastException");
        }
        return false;
    }

    /**
     * Method for converting container to an array.
     *
     * @return an array of container elements
     */
    public String[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    /**
     * Method for receiving the size of container.
     *
     * @return current container size
     */
    public int size() {
        return values.length;
    }

    /**
     * Method for checking a container elements with a specified string.
     *
     * @param string string to find in a container
     * @return true if contains, false if does not contain
     */
    boolean contains(String string) {
        for (String s : values) {
            if (Objects.equals(s, string)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for checking the equality of two containers.
     *
     * @param container for comparing with another container
     * @return true if both containers are the same
     * false if they are different
     */
    boolean containsAll(aContainer container) {
        if (values == null || values.length == 0) {
            return false;
        }
        int il = 0;
        String[] toCompare;
        toCompare = container.toArray();
        for (int i = 0; i < container.size(); i++) {
            if (this.contains(toCompare[i])) {
                il++;
            }
        }
        return il == container.size();
    }

    /**
     * Method for creating a correct iterator.
     *
     * @return a new iterator to a Container object
     */
    public aIterator iterator() {
        return new aIterator(values);
    }

    /**
     * Class aIterator.
     * Contains two fields of lower and higher bound of a container.
     * Constructor gets a storage field from Container and defines
     * both bounds.
     * Contains methods for iterating over a container,
     * checking the existence of the next element and removing.
     *
     * @author Kosinov Vladyslav
     */
    public class aIterator implements Iterator<String> {
        /**
         * Lower bound of the container
         */
        private  int firstBound;

        /**
         * Upper bound of the container
         */
        private  int lastBound;

        /**
         * Constructor for processing the container data.
         * Defines values of lower and higher bound.
         *
         * @param values - array of container elements
         */
        public aIterator(String[] values) {
            firstBound = -1;
            lastBound = values.length - 1;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return firstBound < lastBound;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                firstBound++;
                return values[firstBound];
            }
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         */
        @Override
        public void remove() {
            try {
                String[] temp = values;
                values = new String[temp.length - 1];
                System.arraycopy(temp, 0, values, 0, firstBound);
                int elemToDestinate = temp.length - firstBound - 1; //позиция, в которую нужно начинать копировать кроме вырезанного
                System.arraycopy(temp, firstBound + 1, values, firstBound, elemToDestinate);
            } catch (ClassCastException ex) {
                System.err.println("Error");
            }
        }
    }

}

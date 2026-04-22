package basementCrawl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The {@code Bag} class represents a bag (or multiset) of
 *  generic Ts. It supports insertion and iterating over the
 *  Ts in arbitrary order.
 *  <p>
 *  This implementation uses a singly linked list with a static nested class Node.
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of Ts.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <T> the generic type of an T in this bag
 */
public class Bag<T> implements Iterable<T> {
    private Node<T> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<T> {
        private T T;
        private Node<T> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of Ts in this bag.
     *
     * @return the number of Ts in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the T to this bag.
     *
     * @param T the T to add to this bag
     */
    public void add(T T) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.T = T;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the Ts in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the Ts in this bag in arbitrary order
     */
    public Iterator<T> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T T = current.T;
            current = current.next;
            return T;
        }

    }

    @Override
    public String toString() {
        String returnString = "";
        Node<T> node = first;
        for (int i = 0; i < n; i++) {
            returnString += node.T.toString() + " ";
            node = node.next;
        }
        return returnString;
    }
}

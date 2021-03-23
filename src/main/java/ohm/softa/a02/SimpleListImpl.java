package ohm.softa.a02;

import java.util.Iterator;


// Generic method
// Implementing this interface allows an object to be the target of the "for-each loop" statement.
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private Element head;
    private int length;

    // Constructor
    // first element (empty list)
    public SimpleListImpl() {
        head = null;
    }

    // Helper class, static because the Element does not need to access the SimpleList instance
    private static class Element {
        // content of element
        private Object item;
        private Element next;

        // Constructor
        Element(Object item) {
            // this.item (above), item (Object item)
            this.item = item;
            this.next = null;
        }

        // return content of item
        public Object getItem() {
            return item;
        }

        // get right neighbour, may be null
        public Element getNext() {
            return next;
        }

        // set element to next element
        public void setNext(Element next) {
            this.next = next;
        }
    }

    // add element to the end of the list
    public void add(Object item) {
        // empty list
        if (head == null) {
            head = new Element(item);
        } else {
            // start with head element
            Element current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // create new element
            Element newbie = new Element(item);
            // add newbie to last element
            current.setNext(newbie);
        }
        length++;
    }

    // return list length
    public int length() {
        return length;
    }


    // Get a new SimpleList instance with all items of this list which match the given filter
    // @param filter SimpleFilter instance; testList.filter(o -> ((int)o) % 2 == 0);
    // A(0), B(1), C(2), D(3) => A, C
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl();
        for (Object o : this) {
            if (filter.include(o)) {
                result.add(o);
            }
        }
        // @return new SimpleList instance
        return result;
    }

    //  @inheritDoc
    // Iterator = Objekte, die dem Durchlaufen von Collections dienen
    @Override
    public Iterator<Object> iterator() {
        return new SimpleIteratorImpl();
    }

    // Helper class which implements the Iterator<T> interface
    // Has to be non static because otherwise it could not access the head of the list
    private class SimpleIteratorImpl implements Iterator<Object> {

        // current is head element at the beginning
        private Element current = head;

        // @inheritDoc
        // Methode hasNext() liefert true, solange  Iterator noch nicht das Ende der Collection erreicht hat
        @Override
        public boolean hasNext() {
            // current.next ?
            return current != null;
        }

        // @inheritDoc
        // Next() greift  auf das jeweils nächste Element zu
        @Override
        public Object next() {
            // tmp = Anna
            Object tmp = current.getItem();
            // current = Element2, weiterlaufen
            current = current.getNext();
            // Anna
            return tmp;
        }
    }
}
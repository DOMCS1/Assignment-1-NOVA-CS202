package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/14/2017.
 */
public interface IndexedListI <E>{



    void add(int index, E object) throws ListOverFlowException;

    void add(E object) throws ListOverFlowException;

    E set(int index, E object) throws DuplicateException, EmptyListException;
    E remove(int index) throws IndexOutOfBoundsException;
    int indexOf(E object) throws ElementExistentException;
    boolean contains(E object) throws EmptyListException;
    boolean isEmpty();
    int size();
    E get(int index) throws EmptyListException, IndexOutOfBoundsException;
    String toString();
    void reset();
    E getNext();
}

package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/14/2017.
 */
public interface OrderedListI <E> {

    void add(E object) throws DuplicateException;
    void remove(E removed) throws EmptyListException, ElementExistentException;
    boolean contains(E object) throws EmptyListException;
    boolean isEmpty();
    int size();
    E get() throws ElementExistentException;
    String toString();
    void reset();
    E getNext() throws ElementExistentException;


}

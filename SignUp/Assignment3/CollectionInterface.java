package SignUp.Assignment3; /**
 * Created by Pratyush Gupta on 7/2/2017.
 */
public interface CollectionInterface<E> {

    boolean add(E element);

    E get(E target);

    boolean contains(E target);

    boolean remove(E target);

    boolean isFull();

    boolean isEmpty();

    int size();


}

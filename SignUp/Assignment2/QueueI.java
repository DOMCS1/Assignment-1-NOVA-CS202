package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/14/2017.
 */
public interface QueueI <E> {


void enqueue(E element) throws ListOverFlowException;
E dequeue() throws EmptyListException;
boolean isEmpty();
boolean isFull();
int size();
String toString();


}

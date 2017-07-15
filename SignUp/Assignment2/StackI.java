package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/14/2017.
 */
public interface StackI <E>{


    void push(E element) throws StackOverflowException;
    void pop() throws StackUnderflowException;
    E top() throws StackUnderflowException;
    boolean isEmpty();
    boolean isFull();
    int size();
    String toString();

}

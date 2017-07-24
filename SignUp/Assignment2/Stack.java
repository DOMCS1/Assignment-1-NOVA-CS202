package SignUp.Assignment2;


/**
 * Created by Pratyush Gupta on 6/19/2017.
 */
public class Stack<E> implements StackI<E> {

    private E[] data;
    private int topIndex = -1;
    protected final int def = 100;

    public Stack()
    {
        data = (E[]) new Object[def];

    }

    public Stack(int capacity)
    {
        data = (E[]) new Object[capacity];

    }


    @Override
    public void push(E element) throws StackOverflowException{
        if(isFull())
        {
            throw new StackOverflowException("Push attempted on a full stack.");
        }
        else
        {
            topIndex++;
            data[topIndex] = element;
        }
    }

    @Override
    public void pop() throws StackUnderflowException {
        if (isEmpty())
        {
            throw new StackUnderflowException("Pop attempted on empty stack.");
        }
        else
        {
            data[topIndex]= null;
            topIndex--;
        }
    }

    @Override
    public E top() throws StackUnderflowException {
        E topOfStack = null;
        if (isEmpty())
        {
            throw new StackUnderflowException("Top attempted on empty stack.");
        }
        else
        {
            topOfStack = data[topIndex];
            return topOfStack;
        }
    }

    public String toString()
    {
        String returnable = new String("");
        for(int i = 0; i<data.length;i++)
        {
            returnable += data[i] + " ";
        }
        return returnable;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public boolean isFull() {
        return topIndex == (data.length - 1);
    }

    @Override
    public int size() {
        return topIndex + 1;
    }
}

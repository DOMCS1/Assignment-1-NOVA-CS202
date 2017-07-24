package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/19/2017.
 */
public class Queue <E> implements QueueI<E> {

    private E[] data;
    private final int maxCap = 100;
    private int numElements = 0;

    public Queue()
    {
        data = (E[]) new Object[maxCap];
    }

    public Queue(int size)
    {
        data = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E element) throws ListOverFlowException {

        if (isFull())
            throw new ListOverFlowException("SignUp.Assignment2.Queue is already full");
        else
        {
            data[numElements]= element;
            numElements++;
        }


    }

    @Override
    public E dequeue() throws EmptyListException {
        if (isEmpty())
        {
            throw new EmptyListException("SignUp.Assignment2.Queue is empty; nothing to return");
        }
        else
        {
            E toReturn = data[0];
            numElements--;
            E[] temp = (E[]) new Object[numElements];
            for (int i = 0;i<numElements;i++)
            {
                temp[i] = data[i+1];
            }
            data = temp;
            return toReturn;
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
        return numElements==0;
    }

    @Override
    public boolean isFull() {
        return numElements >= data.length;
    }

    @Override
    public int size() {
        return numElements;
    }
}

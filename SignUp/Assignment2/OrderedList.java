package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/19/2017.
 */
public class OrderedList <E extends Comparable> implements OrderedListI <E>{

    private final int defCap = 100;
    private int cap;
    private E[] data;
    private int numElements = 0;
    private int currentIndex = 0;

    public OrderedList()
    {
        data = (E[]) new Object[defCap];
        cap = defCap;
    }

    public OrderedList(int cap)
    {
        data = (E[]) new Object[cap];
        this.cap = cap;
    }

    @Override
    public void add(E object) throws DuplicateException {


        int i = data.length-1;

        while(object.compareTo(data[i])<0)
        {
            i--;
        }
        if (object.compareTo(data[i])==0)
            throw new DuplicateException("Object is already in list");

        E[] temp = (E[]) new Object[cap];

        for (int j = 0; j<i;j++){
            temp[j] = data[j];
        }
        temp[i] = data[i];
        for (int j = i; j<numElements;j++)
        {
            temp[j+1]=data[j];
        }
        numElements++;
        data = temp;



    }

    @Override
    public void remove(E removed) throws EmptyListException, ElementExistentException {
        if (isEmpty())
        {
            throw new EmptyListException("List is empty!");
        }
        int index = -1 ;
        for(int i = 0; i < numElements; i++)
        {
            if(removed.compareTo(data[i])==0)
            {
                index = i;
            }
        }
        if (index == -1)
        {
            throw new ElementExistentException("Element is not in list");
        }


        E[] temp = (E[]) new Object[cap];
        for (int j = 0; j<index;j++){
            temp[j] = data[j];
        }
        for (int j = index+1; j<numElements;j++)
        {
            temp[j-1]=data[j];
        }
        numElements--;
        data = temp;

    }

    @Override
    public boolean contains(E object) throws EmptyListException{

        if(numElements == 0)
        {
            throw new EmptyListException("List is empty");
        }

        for(int i = 0; i < numElements; i++)
        {
            if(object.compareTo(data[i])==0)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (numElements==0);
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public E get() throws ElementExistentException {
        if (currentIndex>numElements-1)
            throw new ElementExistentException("No element at specified index");

        return data[currentIndex];

    }

    @Override
    public void reset() {
        data = (E[]) new Object[cap];

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
    public E getNext() throws ElementExistentException{
        currentIndex++;
        if (currentIndex>numElements-1)
            throw new ElementExistentException("No element at specified index");

        return data[currentIndex];
    }
}

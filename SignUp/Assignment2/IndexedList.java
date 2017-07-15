package SignUp.Assignment2;

/**
 * Created by Pratyush Gupta on 6/14/2017.
 */
public class IndexedList <E extends Comparable<? super E>> implements IndexedListI<E> {

    private E[] data;
    private final int maxCap = 100;
    private int initialCap;
    private int numElements = 0;
    private int index = 0;


    public IndexedList()
    {
        data = (E[]) new Comparable[maxCap];
        initialCap = maxCap;
    }

    public IndexedList(int initialCap)
    {
        this.initialCap = initialCap;
        data = (E[]) new Comparable[initialCap];
    }

    @Override
    public void add(int index, E object) throws ListOverFlowException{

        try {
            if (contains(object)) {
                throw new ListOverFlowException("Object is already in list");
            }
        } catch (EmptyListException ignored) {
        }

        E[] temp = (E[])new Comparable[numElements+1];

        for(int i = 0; i<index;i++)
        {
            temp[i] = data[i];
        }
        temp[index] = object;
        for(int i = index; i<data.length; i++)
        {
            temp[i+1] = data[i];
        }
        numElements++;
        data = temp;


    }


    @Override
    public void add(E object) throws ListOverFlowException
    {
        try {
            if (contains(object)) {
                throw new ListOverFlowException("Object is already in list");
            }
        } catch (EmptyListException ignored) {
        }

        E[] temp = (E[])new Comparable[initialCap];

        for(int i = 0; i<numElements;i++) {
            temp[i] = data[i];
        }
       temp[numElements] = object;
        numElements++;
        data = temp;
    }


    @Override
    public E set(int index, E object) throws DuplicateException, EmptyListException {
if (contains(object))
    throw new DuplicateException("Object is already in array");
        if((index<0||index>numElements))
            throw new IndexOutOfBoundsException("Index is out of range");

        E toReturn = data[index];
        data[index] = (E)object;
        return toReturn;
    }


    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if ((index<0||index>numElements))
            throw new IndexOutOfBoundsException("Index is out of range");

        E[] temp = (E[])new Object[numElements-1];
        for (int i = 0; i<index;i++)
        {
            temp[i] = data[i];
        }
        for (int i = index + 1; i<data.length; i++)
        {
            temp[i-1]= data[i];
        }
        E toReturn = data[index];
        data = temp;
        numElements--;
        return toReturn;
    }

    @Override
    public int indexOf(E object) throws ElementExistentException {
        for (int i = 0; i<numElements;i++)
        {
            if (object.compareTo(data[i])==0)
            {
                return i;
            }
        }
        throw new ElementExistentException("Element is non Existent!");
    }

    @Override
    public boolean contains(E object) throws EmptyListException{

        if (numElements == 0)
            throw new EmptyListException("List is still empty!");

        for (int i = 0; i<numElements; i++)
        {
            if (data[i].compareTo(object) == 0)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numElements==0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public E get(int index) throws EmptyListException, IndexOutOfBoundsException {
        if ((index<0||index>numElements))
            throw new IndexOutOfBoundsException("Index is out of range");
        if(numElements==0)
        {
            throw new EmptyListException("List is still empty!");
        }
        this.index = index;

        return data[index];
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
    public void reset() {

        data = (E[])new Comparable[numElements];

    }

    @Override
    public E getNext() {
        index++;
        return data[index];
    }
}

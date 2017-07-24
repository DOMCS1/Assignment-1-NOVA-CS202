package SignUp.Assignment3;

/**
 * Created by Pratyush Gupta on 7/22/2017.
 */
import java.util.*;

public class Heap<E extends Comparable>
{
    private ArrayList<E> elements;
    private int lastIndex;
    private int maxIndex;

    public Heap(int maxSize)
    {
        elements = new ArrayList<E>(maxSize);
        lastIndex = -1;
        maxIndex = maxSize - 1;
    }

    public boolean isEmpty()
    {
        return (lastIndex == -1);
    }

    public boolean isFull() {
        return (lastIndex == maxIndex);
    }

    private void reheapUp(E element)
    {
        int hole = lastIndex;
        while ((hole > 0)
                &&
                (element.compareTo(elements.get((hole - 1) / 2)) > 0))
        {

            elements.set(hole,elements.get((hole - 1) / 2));
            hole = (hole - 1) / 2;
        }
        elements.set(hole, element);
    }

    public void enqueue(E element) throws Exception

    {
        if (lastIndex == maxIndex)
            throw new Exception("Priority queue is full");
        else
        {
            lastIndex++;
            elements.add(lastIndex,element);
            reheapUp(element);
        }
    }

    private int newHole(int hole, E element)
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if (left > lastIndex)
            return hole;
        else
        if (left == lastIndex)
            if (element.compareTo(elements.get(left)) < 0)
                return left;
            else
                return hole;
        else
        if (elements.get(left).compareTo(elements.get(right)) < 0)
            if (elements.get(right).compareTo(element) <= 0)
                return hole;
            else
                return right;
        else
        if (elements.get(left).compareTo(element) <= 0)
            return hole;
        else
            return left;
    }

    private void reheapDown(E element)
    {
        int hole = 0;
        int newhole;

        newhole = newHole(hole, element);
        while (newhole != hole)
        {
            elements.set(hole,elements.get(newhole));
            hole = newhole;
            newhole = newHole(hole, element);
        }
        elements.set(hole, element);
    }

    public E dequeue() throws Exception

    {
        E hold;
        E toMove;

        if (lastIndex == -1)
            throw new Exception("Priority queue is empty");
        else
        {
            hold = elements.get(0);
            toMove = elements.remove(lastIndex);
            lastIndex--;
            if (lastIndex != -1)
                reheapDown(toMove);
            return hold;
        }
    }

    public String toString()
    {
        String theHeap = new String("the heap is:\n");
        for (int index = 0; index <= lastIndex; index++)
            theHeap = theHeap + index + ". " + elements.get(index) + "\n";
        return theHeap;
    }
}
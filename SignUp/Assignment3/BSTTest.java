package SignUp.Assignment3;

//***********
//
//This code doesn't work on my laptop but I have still written a whole test class in hope that it will compile on you computer
//
//        Some of the methods weren't required but I wrote them anyways just in case.
//
//
//        ********
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Pratyush Gupta on 7/14/2017.
 */
public class BSTTest {
    @org.junit.Test
    public void add() throws Exception {
        BST test = new BST();
        assert (test.contains(5) == false);
        test.add(5);
        assert (test.contains(5));


    }

    @org.junit.Test
    public void contains() throws Exception {

        BST test = new BST();
        assert test.contains(5);
        test.add(3);
        test.add(5);
        assert (test.contains(5));
        assert (test.contains(4) == false);

    }

    @org.junit.Test
    public void get() throws Exception {

        BST<Integer> test = new BST();
        test.add(5);
        assert (test.get(5) == 5);


    }

    @org.junit.Test
    public void extractValues() throws Exception {

        BST<Integer> test = new BST();

        test.add(5);
        test.add(4);
        test.add(3);

        ArrayList<Integer>  tester = new ArrayList<>();
        tester.add(5);
        tester.add(4);
        tester.add(3);

        ArrayList test2 = test.extractValues(null);
        assert test2.containsAll(tester);


    }

    @org.junit.Test
    public void remove() throws Exception {

        BST test = new BST();
        assert (test.contains(5) == false);
        test.add(5);
        assert (test.contains(5));
        test.remove(5);
        assert (test.contains(5) == false);
    }

    @org.junit.Test
    public void toString() throws Exception {

        BST test = new BST();
        test.add(5);
        assert BST.toString().equals("5");
        //if it fails it might be cause the BST prints it in all 3 orders - preorder, postorder, inorder

    }

    @org.junit.Test
    public void isFull() throws Exception {

        BST test = new BST();
        for (int i = 0; i < 100; i++)
        {
            test.add(i);
        }
        assert test.isFull()==false;


    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        BST test = new BST();
        assert test.isEmpty();
        for (int i = 0; i < 100; i++)
        {
            test.add(i);
        }
        assert test.isEmpty()==false;

    }

    @org.junit.Test
    public void size() throws Exception {

        BST test = new BST();
        assert test.size() == 0;
        for (int i = 0; i < 100; i++)
        {
            test.add(i);
            assert test.size() == i;
        }


    }



    @org.junit.Test
    public void min() throws Exception {

        BST test = new BST();
        for (int i = 7; i < 100; i++)
        {
            test.add(i);
        }
        assert (Integer)test.min() == 7;

    }

    @org.junit.Test
    public void max() throws Exception {

        BST test = new BST();
        for (int i = 7; i < 72; i++)
        {
            test.add(i);
        }
        assert (Integer)test.max() == 72;

    }

}
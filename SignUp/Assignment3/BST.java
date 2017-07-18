package SignUp.Assignment3;
import SignUp.Assignment2.Queue;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Pratyush Gupta on 7/2/2017.
 */
public class BST<E> implements BSTinterface<E>
{
    protected BSTNode<E> root;
    protected Comparator<E> comp;

    protected Queue<E> inOrderQueue;
    protected Queue<E> preOrderQueue;
    protected Queue<E> postOrderQueue;

    protected boolean found;

    public BST()
    {
        root = null;
        comp = (element1, element2) -> ((Comparable)element1).compareTo(element2);
    }

    public BST(Comparator<E> comp)
    {
        root= null;
        this.comp = comp;
    }

    @Override
    public boolean add(E element) {
        root = recAdd(element, root);
        return true;
    }

    private BSTNode<E> recAdd(E element, BSTNode<E> node) {
        if (node == null) {
            node = new BSTNode<E>(element);
        } else if (comp.compare(element, node.getInfo()) <= 0)
        {
            node.setLeft(recAdd(element, node.getLeft()));
        }
        else
            node.setRight(recAdd(element, node.getRight()));
        return node;
    }

    @Override
    public boolean contains(E target) {
        return recContains(target, root);
    }
    @Override
    public E get(E target)
    {
        return recGet(target, root);
    }

    private E recGet(E target, BSTNode<E> node) {
        if(node == null)
        {
            return null;
        }
        else if(comp.compare(target, node.getInfo()) < 0)
            return recGet(target, node.getLeft());
        else
        if(comp.compare(target, node.getInfo()) > 0)
            return recGet(target, node.getRight());
        else
            return node.getInfo();
    }

    private boolean recContains(E target, BSTNode<E> node) {

        if (node == null)
        {
            return false;
        }
        else if (comp.compare(target, node.getInfo()) < 0)
            return recContains(target, node.getLeft());
        else if (comp.compare(target, node.getInfo()) > 0)
            return recContains(target, node.getRight());
        else
            return true;
    }

    public ArrayList<E> extractValues(BSTNode n) {

        if (n == null)
        {
            n = root;
        }
        ArrayList<E> result = new ArrayList<>();
        if (n.getLeft() != null) {
            result.addAll(extractValues(n.getLeft()));
        }

        if (n.getRight() != null) {
            result.addAll(extractValues(n.getRight()));
        }

        result.add((E)(n.getInfo()));

        return result;
    }

    @Override
    public boolean remove(E target) {
        root = recRemove(target, root);
        return found;
    }

    private BSTNode<E> recRemove(E target, BSTNode<E> node) {
        if (node == null)
            found = false;
        else if(comp.compare(target, node.getInfo()) < 0 )
            node.setLeft(recRemove(target, node.getLeft()));
        else if (comp.compare(target, node.getInfo())>0)
            node.setRight(recRemove(target, node.getRight()));
        else
        {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    private BSTNode<E> removeNode(BSTNode<E> node) {
        E data;
        if(node.getLeft() == null)
            return node.getRight();
        else if (node.getRight() == null)
            return node.getLeft();
        else
        {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }
    }

    public String toString()
    {
        return inOrderQueue.toString() + preOrderQueue.toString() + postOrderQueue.toString();
    }

    private E getPredecessor(BSTNode<E> subtree)
    {
        BSTNode<E> temp = subtree;
        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp.getInfo();
    }

    public boolean isFull()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return (root == null);
    }


    private void inOrder(BSTNode<E> tree) throws Exception
    {
        if (tree != null)
        {
            inOrder(tree.getLeft());
            inOrderQueue.enqueue(tree.getInfo());
            inOrder(tree.getRight());
        }
    }

    private void preOrder(BSTNode<E> tree) throws Exception
    {
        if (tree != null)
        {
            preOrderQueue.enqueue(tree.getInfo());
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    private void postOrder(BSTNode<E> tree) throws Exception
    {
        if (tree != null)
        {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            postOrderQueue.enqueue(tree.getInfo());
        }
    }



    @Override
    public int size() {
        if (isEmpty())
        {
            return 0;
        }
        return recursiveSize(root);
    }

    public int recursiveSize(BSTNode<E> node)
    {
        if (node==null)
        {
            return 0;
        }
        else
        {
            return 1 + recursiveSize(node.getLeft()) + recursiveSize(node.getRight());
        }
    }

    public E min()
    {
        if (isEmpty())
            return null;
        else
        {
            BSTNode<E> node = root;
            while (node.getLeft() != null)
                node = node.getLeft();
            return node.getInfo();
        }
    }

    public E max()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            BSTNode<E> node = root;
            while (node.getRight() != null)
                node = node.getRight();
            return node.getInfo();
        }
    }

}

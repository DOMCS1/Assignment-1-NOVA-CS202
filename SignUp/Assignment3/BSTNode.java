package SignUp.Assignment3; /**
 * Created by Pratyush Gupta on 7/2/2017.
 */
public class BSTNode<E> {

    private E info;
    private BSTNode<E> left;
    private BSTNode<E> right;

    public BSTNode(E info)
    {
        this.info = info;
        left=null;
        right=null;

    }


    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public void setRight(BSTNode<E> right) {
        this.right = right;
    }
}

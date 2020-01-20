
public class BTreeNode<T> 
{
	private BTreeNode<T> left;
	private BTreeNode<T> right;
	private T el;
	
	

public BTreeNode(T el)
{
	left = null;
	right = null;
	this.el = el;
}

public T getElement()
{
	return this.el;
}

public void setElement(T el)
{
	this.el = el;
}

public BTreeNode<T> getLeft()
{
	return left;
}

public BTreeNode<T> getRight()
{
	return right;
}

public void setLeft( BTreeNode<T> n )
{	
	this.left = n;
}

public void setRight( BTreeNode<T> n )
{	
	this.right = n;
}

public boolean isLeaf()
{
	return (left == null && right == null);
}

}

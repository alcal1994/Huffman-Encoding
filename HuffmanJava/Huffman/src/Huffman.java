import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Huffman {
	
	private class HuffmanCode
	{
		// the character and the code
		char character;
		// the code
		String code;
		
		// the constructor
		public HuffmanCode(char character,String code)
		{
			// set the data members
			this.character = character;
			this.code = code;
		}
	}

	// the linked list of character frequencies
	private LinkedList<CharFreq> frequencies;
	// the root of the binary tree
	private BTreeNode<CharFreq> root;
	// the list of the codes
	private LinkedList<HuffmanCode> codes;
	
	// to store a code
	private String code;
	
	// the constructor that takes in the linked list of  frequencies
	public Huffman(LinkedList<CharFreq> frequencies)
	{
		this.frequencies = frequencies;
		createTree();
	}
	
	// method to create a list of char frequency BTNodes
	private LinkedList<BTreeNode<CharFreq>> getListOfCharFreqBTreeNodes()
	{
		// the list of the BT nodes to return
		LinkedList<BTreeNode<CharFreq>> nodes = new LinkedList<>();
		
		// for each of the character frequency
		for( CharFreq cf : frequencies )
		{
			// create a binary tree node
			BTreeNode<CharFreq> newNode = new BTreeNode<CharFreq>(cf);
			// place this into the list of the nodes
			nodes.add(newNode);
		}
		
		// return the nodes
		return nodes;
	}
	
	// a method to create a Huffman tree
	private void createTree()
	{
		LinkedList<BTreeNode<CharFreq>> nodes = getListOfCharFreqBTreeNodes();
		
		// build the huffman tree
		
		while( nodes.size() > 1 ) 
		{
			// sort the list
			Collections.sort(nodes, new Comparator<BTreeNode<CharFreq>>() {
				@Override
				public int compare(BTreeNode<CharFreq> o1, BTreeNode<CharFreq> o2) {
					return o1.getElement().getFrequency() - o2.getElement().getFrequency();
				}
			});
			
			// get the first two nodes in the list
			BTreeNode<CharFreq> left = nodes.remove();
			BTreeNode<CharFreq> right = nodes.remove();
			
			// create new node
			BTreeNode<CharFreq> newNode = 
					new BTreeNode<CharFreq>(new CharFreq(' ', left.getElement().getFrequency() + right.getElement().getFrequency()));
			// set the left and the right
			newNode.setLeft(left);
			newNode.setRight(right);
			
			// add this node back into the list
			nodes.add(newNode);
		}
		
		// the final node is the root of my Huffman tree
		root = nodes.get(0);
		// generate all codes
		generateAllCodes();
	}
	
	// method to get the tree
	public BTreeNode<CharFreq> getTreeRoot()
	{
		return root;
	}
	
	private void generateCode(BTreeNode<CharFreq> node,String s,char c)
	{
		if( node == null )
			return;
		
		if( node.getLeft() == null && node.getRight() == null && node.getElement().getCharacter() == c )
		{
			code = s;
			return;
		}
		generateCode(node.getLeft(), s + "0", c);
		generateCode(node.getRight(), s + "1", c);
	}
	
	// method to generate codes
	public String getCode(char c)
	{
		// the code to return
		String code = "";
		
		// look for this code in the linked list
		for( HuffmanCode hc : codes )
		{
			if( hc.character == c )
			{
				code = hc.code;
				break;
			}
		}
		
		// return this code
		return code;
	}
	
	// get character for code
	
	
	private String _getCode(char c)
	{
		
		generateCode(root, "", c);
		
		// return the code
		return code;
	}
	
	// method to generate all codes
	private void generateAllCodes()
	{
		// create all codes list
		codes = new LinkedList<>();
		
		for( CharFreq cf : frequencies) 
		{
			// get the code for this character
			String code = _getCode(cf.getCharacter());
			// add this code to the linked list
			codes.add( new HuffmanCode(cf.getCharacter(), code));
		}
	}
	
	
}

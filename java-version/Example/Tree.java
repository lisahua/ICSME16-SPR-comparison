package Example;
class Tree {
	Node root;
	int size;
	class Node {
		Node()
		{
			parent = null;
			left = null;
			right = null;
		}
		
		Integer key;
		Node parent;
		Node left;
		Node right;
	}
}

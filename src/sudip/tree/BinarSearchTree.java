package sudip.tree;

public class BinarSearchTree {

	Node root;
	
	private void insert(int val) {
		root = insertRec(root, val);
	}
	private Node insertRec(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		else if(root.key > val) {
			root.left = insertRec(root.left, val);
			return root;
		}
		else {
			root.right = insertRec(root.right, val);
			return root;
		}
	}
	
	private Node minVal(Node root) {
		if(root == null || root.left == null) {
			return root;
		}
		else
			return minVal(root.left);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarSearchTree bst = new BinarSearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(4);
		System.out.println(bst.minVal(bst.root).key);

	}

}

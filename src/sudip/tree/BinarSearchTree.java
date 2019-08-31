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
	
	private void delete(int val) {
		root = deleteRec(root, val);
	}
	
	private Node deleteRec(Node root, int val) {
	
		if(root == null) {
			return root;
		}
		else if(val > root.key){
			root.right = deleteRec(root.right, val);
		}
		else if(val < root.key) {
			root.left = deleteRec(root.left, val);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			
			root.key = minVal(root.right).key;
			
			root.right = deleteRec(root.right, root.key);
		}
		
		return root;
	}
	
	private void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
		}
		
	}
	
	private void preorder(Node root) {
		if(root != null) {
			System.out.print(root.key+" ");
			preorder(root.left);
			preorder(root.right);
		}
		
	}
	
	private void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key+" ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarSearchTree bst = new BinarSearchTree();
		bst.insert(50); 
		bst.insert(30); 
		bst.insert(20); 
		bst.insert(40); 
		bst.insert(70); 
		bst.insert(60); 
		bst.insert(80); 

		bst.inorder(bst.root);
		
		System.out.println("\n");
		bst.delete(50);
		bst.inorder(bst.root);
	}

}

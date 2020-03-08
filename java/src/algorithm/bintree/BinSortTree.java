package algorithm.bintree;

public class BinSortTree {
	private Node root = null;
	
	public BinSortTree(int value){
		root = new Node(value);
		root.lChild = null;
		root.rChild = null;
	}
	
	public String insert(int value) {
		String error = "ok";
		
		Node node = new Node(value); //构造一个新节点
		if (root == null)            //根节点是空，则构成根节点，根是第一个被固定的。
		{
			root = node;
			root.lChild = null;
			root.rChild = null;
		}
		else{
			Node current = root;     //当前节点取得根节点
			Node parent = null;      
			
			while(true){				
				if(value < current.value) //如果新节点值小于当前节点值，继续寻找左子树，当前节点调整为父节点，直到当前节点为空，则父亲左孩子为新节点
				{
					parent = current;
					current = current.lChild;
					if (current == null)
					{
						parent.lChild = node;
						break;
					}
				}
			    else if(value>current.value) 
			    {
			    	parent = current;
			    	current = current.rChild;
			    	if(current == null)
			    	{
			    		parent.rChild = node;
			    		break;  
			    	}
			    	
			    }
			    else
			    {
			    	error = "having same value in binary tree";
			    }

			}
				
			
		}
		
		return error;
	}
	
	public void inOrderTraverse()
	{
	    System.out.print("中序遍历:");  
	    inOrderTraverse(root);  
	    System.out.println();  
	}
	
	public void inOrderTraverse(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		inOrderTraverse(node.lChild);
		node.print();
		inOrderTraverse(node.rChild);
	}	
	
	
	public void preOrderTraverse()
	{
	    System.out.print("先根遍历:");  
	    preOrderTraverse(root);  
	    System.out.println();  
	}
	
	public void preOrderTraverse(Node node)
	{
		if(node == null)
		{
			return;
		}
		node.print();
		preOrderTraverse(node.lChild);
		preOrderTraverse(node.rChild);
	}		
	
	public void postOrderTraverse()
	{
	    System.out.print("后根遍历:");  
	    postOrderTraverse(root);  
	    System.out.println();  
	}
	
	public void postOrderTraverse(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		postOrderTraverse(node.lChild);
		postOrderTraverse(node.rChild);
		node.print();
	}		
}

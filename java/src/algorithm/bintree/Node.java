package algorithm.bintree;

public class Node {
	int value;
	Node lChild;
	Node rChild;
	
	Node(int value){
		this.value = value;
	}
	
	public void print()
	{
		System.out.print(this.value+" ");
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.value);
	}

}

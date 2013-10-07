package tree;

public class FenwickTree {

	private int MAX_NUM = 7;
	private int[] arr = new int[MAX_NUM];
	public static void main(String[] args)
	{
		FenwickTree tree = new FenwickTree();
		tree.update(1,2);
		tree.update(2,3);
		tree.update(3,4);
		tree.update(4,5);
		tree.update(5,6);
		tree.update(6,7);
		System.out.println(tree.sumBetweenIndexes(3, 6));
		tree.update(4,100);
		System.out.println(tree.sumBetweenIndexes(3, 6));
	}

	public void update(int index,int value){
		for(;index<MAX_NUM;index += (index & -index)){
			arr[index] += value;
		}
		print(arr);
	}

	private void print(int[] arr2) {
		// TODO Auto-generated method stub
		for(int i:arr2)
			System.out.printf(" %d ",i);
		System.out.println("");
	}

	private int sum(int index){
		int total =0;
		for(int i=index;i>0;i -= (i & -i)){
			total += arr[i];
		}
		return total;
	}

	public int sumBetweenIndexes(int i,int j){
		return sum(j) - sum(i-1); 
	}
}

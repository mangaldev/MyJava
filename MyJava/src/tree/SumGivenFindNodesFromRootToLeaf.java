package tree;

public class SumGivenFindNodesFromRootToLeaf {
	public static void main(String... args){
		int[] tree = new int[9];
		printPath(tree, 0,0,40);
		
	}
	
	public void printPath(int[] tree,int root, int sum, int k){
		if(tree[root] == -1){
			return;
		}
		if(sum + tree[root]== k && tree[2*root + 1] == -1 && tree[2*root + 2] == -1){
			for(int i = root;i >=0 ; i = (i-1)/2){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		printPath(tree, 2*root + 1, sum + tree[root],k);
		printPath(tree, 2*root + 2, sum + tree[root],k);		
	}

}

public  class Percolation {
//	private int[][] input;
//	private  WeightedQuickUnionUF wqu;
//	private  int size;
//	public Percolation(int N)
//	{
//		size = N;
//		input = new int[N][N];
//		wqu = new WeightedQuickUnionUF(N* N+3);
//		for(int i = 0;i < N;i++)
//			for(int j = 0;j < N;j++)
//				input[i][j] = 0;
//
//	}
//
//	public void open(int i, int j){
//		if(i<0 || i>=size || j<0 || j>=size)
//			throw new IndexOutOfBoundsException();
//		if(isOpen(i,j))
//			return;
//
//		input[i][j] = 1;
//		int mainIndex = (i)*size +j;
//		if(i == 0)
//			wqu.union(mainIndex,size*size+1);
//		if(i == size-1)
//			wqu.union(mainIndex,size*size+2);
//		if((i -1 >= 0) && isOpen(i-1,j)){
//			int upIndex = (i-1)*size + j;
//			wqu.union(mainIndex,upIndex);
//		}
//
//		if( (i +1 < size) && isOpen(i+1,j) ){
//			int downIndex  = (i+1)*size + j;
//			wqu.union(mainIndex,downIndex);
//		}
//
//		if(((j+1) <size) && isOpen(i,j+1) ){
//			int leftIndex  = mainIndex+1;
//			wqu.union(mainIndex,leftIndex);
//		}
//
//		if(((j -1) >= 0) && isOpen(i,j-1)){
//			int rightIndex  = mainIndex-1;
//			wqu.union(mainIndex,rightIndex);
//		}
//	}
//
//	public boolean isOpen(int i, int j) {
//		if(i<0 || i>=size || j<0 || j>=size)
//			throw new IndexOutOfBoundsException();
//		return (input[i][j] == 1);
//	}
//
//	public boolean isFull(int i, int j){
//		if(i<0 || i>=size || j<0 || j>=size)
//			throw new IndexOutOfBoundsException();
//		if(!isOpen(i,j))
//			return false;
//		for(int a =0 ;a<size;a++){
//			if(wqu.connected(a, (i)*size + j)){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean percolates() {
//		int N = size;
//		if(wqu.connected(N*N+1, N*N+2))
//			return true;
//		else
//			return false;
//	}
//


}

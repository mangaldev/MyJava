public class PercolationStats {

	private double[] x;
	private int T, N;

	public PercolationStats(int N, int T){
		this.N = N;
		this.T = T;
		x = new double[T];
	}

	public static void main(String[] args){
		int T = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		PercolationStats perStats = new PercolationStats(N,T);
		for(int t = 0;t<T;t++){
			Percolation percolation = new Percolation(N);
			perStats.x[t] = perStats.execute(percolation);
		}
		System.out.println("mean                    = "+perStats.mean());
		System.out.println("stddev                  = "+perStats.stddev());
		System.out.println("95% confidence interval = "+perStats.confidenceLo()+", "+perStats.confidenceHi());

	}
	public double mean() {
		return StdStats.mean(x);
	}
	public double stddev() {
		return StdStats.stddev(x);
	}
	public double confidenceLo() {
		return (mean() - ((1.96 * stddev()) / Math.sqrt(T))); 
	}
	public double confidenceHi() {
		return (mean() + ((1.96 * stddev()) / Math.sqrt(T)));
	}	 
	
	private double execute(Percolation percolation){
		double result;
		int openSites = 0;
		while(true){
			int x = StdRandom.uniform(N);
			int y = StdRandom.uniform(N);
			if(!percolation.isOpen(x,y)){
				openSites++;
			}
			else
				continue;
			percolation.open(x,y);
			if(percolation.percolates()){
				return (openSites*1.0)/(N*N*1.0);
			}
		}
	}
}

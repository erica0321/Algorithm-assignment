package assignment4;

class Graph {
	int noVertex;	// number of vertex
	int[][] m;	//adjacent matrix(graph G)

	void loadData() {	//graph G's data
		int noVertex = 4;
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
		m[0][0] = 0; m[0][1] = 3; m[0][2] = 999; m[0][3] = 7; 
		m[1][0] = 8; m[1][1] = 0; m[1][2] = 2; m[1][3] = 999; 
		m[2][0] = 5; m[2][1] = 999; m[2][2] = 0; m[2][3] = 1;
		m[3][0] = 2; m[3][1] = 999; m[3][2] = 999; m[3][3] = 0;
		
	}
	
	int[][] allShortPath() {
		int n = m.length;
		int[][] a= new int[noVertex][noVertex];
		
		for(int i=0; i<noVertex; i++) {
			for(int j=0; j<noVertex; j++) {
				a[i][j] = m[i][j];
			}
		}
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(a[i][j] > (a[i][k] + a[k][j])) {		//check if path i to j via k is less than path i to j directly
						a[i][j] = a[i][k] + a[k][j];		//if true update a
					}
				}
			}
		}
		return a;
	}
}

public class FloydWarshall {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.loadData();
		int[][] shortLength;
		shortLength = g.allShortPath();
		int line = 0;
		
		System.out.println("Result of FloydWarshall :");
		for(int i=0; i<shortLength.length; i++) {
			for(int j=0; j<shortLength.length; j++) {
				if(line >= shortLength.length) {
					System.out.println();
					line = 0;
				}
				System.out.print(shortLength[i][j]+" ");
				line ++;
			}
		}
	}
}

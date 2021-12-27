package assignment3;

class Graph {
	int noVertex;	// number of vertex
	int[][] m;	//adjacent matrix(graph G)

	void loadData() {	//graph G's data
		int noVertex = 5;
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
		m[0][0] = 0; m[0][1] = 2; m[0][2] = 5; m[0][3] = 999; m[0][4] = 3; 
		m[1][0] = 999; m[1][1] = 0; m[1][2] = 999; m[1][3] = 4; m[1][4] = 10; 
		m[2][0] = 999; m[2][1] = 999; m[2][2] = 0; m[2][3] = 6; m[2][4] = 2; 
		m[3][0] = 999; m[3][1] = 999; m[3][2] = 999; m[3][3] = 0; m[3][4] = 999;
		m[4][0] = 999; m[4][1] = 999; m[4][2] = 1; m[4][3] = 2; m[4][4] = 0;
	}

	int[] dijkstraPath(int startVertex) {	
		int[] dist = new int[noVertex];
		boolean[] Q = new boolean[noVertex];	//if Q[i] = true , it is same as remove u from Q
		
		for(int i = 0; i < dist.length; i++){	//initialize
			dist[i] = m[startVertex][i];
			Q[i] = false;
		}
		Q[startVertex] = true;
		dist[startVertex] = 0;
		
		for(int i = 0; i < dist.length; i++){
			int u = 0;
			int min = 1000;
			for(int j = 0; j < dist.length ; ++j){		//find u which vertex in Q with min dist[u]
				if(dist[j] < min && Q[j] == false){
					min = dist[j];
					u = j;
				}
			}
			Q[u] = true;			//same as number 14 remove u from Q
			for(int w = 0; w < dist.length ; ++w){	
				if(Q[w] == false){				//for each neighbor v of u still in Q
					int alt = dist[u] + m[u][w];
					if(dist[w] > alt){
						dist[w] = alt;
					}
				}
			}
		}		
		return dist;
	}
}

public class Dijkstra {
	public static void main(String[] args) {
		Graph g = new Graph();	// make graph
		g.loadData();	//load graph's data
		
		int startVertex = 0;
		
		int[] dist = g.dijkstraPath(startVertex); //cost of shortest path
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");	//print cost
	}
}


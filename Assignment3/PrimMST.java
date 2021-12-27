package hello;

class ListNode{
	int data;
	ListNode link;
	
	void ListNode() {
		data = 0;
		link = null;
	}
}

class Graph {
	int noVertex;	// number of vertex
	int[][] m;	//adjacent matrix(graph G)

	void loadData() {	//graph G's data
		int noVertex = 5;
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
		m[0][0] = 0; m[0][1] = 2; m[0][2] = 5; m[0][3] = 999; m[0][4] = 3; 
		m[1][0] = 2; m[1][1] = 0; m[1][2] = 999; m[1][3] = 4; m[1][4] = 999; 
		m[2][0] = 5; m[2][1] = 999; m[2][2] = 0; m[2][3] = 6; m[2][4] = 2; 
		m[3][0] = 999; m[3][1] = 4; m[3][2] = 999; m[3][3] = 0; m[3][4] = 999;
		m[4][0] = 3; m[4][1] = 999; m[4][2] = 2; m[4][3] = 999; m[4][4] = 0;
	}
	
	int min(int a) {			//find vertex 'b' which has smallest cost (a to b)
		int minVertex = 0;
		int min = m[a][0];
		if(a == 0) {
			m[a][0] = 999;
		}
		for(int i = 0; i<noVertex; i++) {
			if(m[a][i] < min) {
				min = m[a][i];
				minVertex = i;
			}
		}
		return minVertex;
	}	
}

public class PrimMST {
	public static void main(String[] args) {
		Graph g = new Graph();	// make graph
		g.loadData();	//load graph's data
		
		int start = 0;
		int vertex = 5;
		
		ListNode tree[] = new ListNode[vertex];	//spanningTree
		
		boolean reach[] = new boolean[vertex];			//reachset
		boolean unReach[] = new boolean[vertex];			//unreachset
		reach[start] = true;
		unReach[start] = true;
		
		for(int i=0; i<vertex; i++) {
			if(unReach[i] == false) {			//방문하지 않은 노드
				int j = 0;
				for(j=0; j<vertex; j++) {		//방문한 노드 중 한 노드에서 거리가 짧은 방문하지 않은 노드 구하기
					if(reach[j] == true) {
						int stMinVer = g.min(j);
						ListNode newNode = new ListNode();	//방문한 노드와 연결
						newNode.data = stMinVer;
						tree[i] = newNode;
					}
				}
				reach[j] = true;
				unReach[j] = true;
			}
		}
		for(int i = 0; i<vertex; i++) {
			System.out.println(tree[i].data);
		}
	}
}

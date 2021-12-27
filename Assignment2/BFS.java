package algorithms;

import java.util.Scanner;

class ListNode{
	int data;
	ListNode link;
}
class Queue{
	private ListNode front;
	private ListNode rear;
	private int count;
	
	public Queue(){
		front = null;
		rear = null;
		count = 0;
	}
	public boolean isEmpty(){
		return (count == 0);
	}
	public void enqueue(int x){
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = null;
	
		if(count == 0){
			front = rear = newNode;
		}else{
			rear.link = newNode;
			rear = newNode;
		}
		count ++;
	}
	public Object dequeue(){
		if(count == 0){
			return null;
		}
		Object item = front.data;
		front = front.link;
		if(front == null){
			rear = null;
		}
		count --;
		return item;
	}
}

class Graph {
	int length;
	ListNode list[] = new ListNode[10];
	
	public Graph(int noVertex) {
		this.length = noVertex;
	}
	
	public void addEdge(int i, int j) {		//간선 i->j로 향하는 간선 추가, j->i로 가는 간선은 따로 또 addEdge사용
		ListNode newNode = new ListNode();	
		newNode.data = j;		
		newNode.link = null;
		
		if(list[i] == null){
			list[i] = newNode;
			return;
		}		
		ListNode p = new ListNode();
		p = list[i];
		while(p.link != null){
			p = p.link;
		}
		p.link = newNode;
	}
	
	public void removeEdge(int i, int j) {		//간선 i->j로 향하는 간선삭제, j->i로 가는 간선은 따로 또 removeEdge사용
		ListNode p = new ListNode();
		p = list[i];
		while(p.link.data != j){
			p = p.link;
		}
		if(p.link.link != null){
			p.link = p.link.link;
		}else if(p.link.link == null){
			p.link = null;
		}
	}
	
	public void bfsComponents() {
		int visited[] = new int[length];
		int z = 1;
		for(int j = 0; j < length; j++) {
			visited[j] = 0;
		}
		for(int k = 0 ; k < length; k++) {
			if(visited[k] == 0) {
				System.out.println("\nComponent" + z++);
				Queue q = new Queue();				//이부분부터
				for(int i = 0; i<length; i++){
					visited[i] = 0;
				}
				q.enqueue(k);
				while(!q.isEmpty()){
					int j = (Integer)q.dequeue();
					if(visited[j] == 0){
						visited[j] = 1;
						System.out.print(j + " ");
						ListNode p = new ListNode();
						p = list[j];
						while(p != null){
							if(visited[p.data] == 0){
								q.enqueue(p.data);
							}
							p = p.link;
						}
					}
				}									//여기까지 bfs()
			}
		}
	}
}
/*
	public void bfs(int vertex) {
		int visited[] = new int[length];
		Queue q = new Queue();
		for(int i = 0; i<length; i++){
			visited[i] = 0;
		}
		q.enqueue(vertex);
		while(!q.isEmpty()){
			int j = (Integer)q.dequeue();
			if(visited[j] == 0){
				visited[j] = 1;
				System.out.print(j + " ");
				ListNode p = new ListNode();
				p = list[j];
				while(p != null){
					if(visited[p.data] == 0){
						q.enqueue(p.data);
					}
					p = p.link;
				}
			}
		}
}*/

public class BFS {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int check;
		int i, j;
		System.out.print("방향그래프의 노드 수를 입력하시오(최대 10개까지 가능): ");
		int noVertex = scan.nextInt();		//그래프 노드 수 입력
		Graph g = new Graph(noVertex);		//노드가 noVertex개인 그래프 생성
		
		do {
			System.out.print("간선을 추가하려면 1, 간선을 지우려면 2, 그만 입력하려면 0을 입력하세요: ");
			check = scan.nextInt();
			if(check == 1) {
			System.out.print("사이에 간선을 추가할 노드 2개를 입력하시오(노드는 0부터 " + (noVertex-1) +"번까지 있습니다)(방향그래프입니다): ");
			i = scan.nextInt();
			j = scan.nextInt();
			g.addEdge(i, j);
			}else if(check == 2){
				System.out.print("사이에 간선을 제거할 노드 2개를 입력하시오(노드는 0부터 " + (noVertex-1) +"번까지 있습니다): ");
				i = scan.nextInt();
				j = scan.nextInt();
				g.removeEdge(i, j);
			}
		}while(check != 0);
		
		System.out.print("\nComputing the connected components of a graph G: ");
		g.bfsComponents();
	}
}

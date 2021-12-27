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
	
	public void addEdge(int i, int j) {		//���� i->j�� ���ϴ� ���� �߰�, j->i�� ���� ������ ���� �� addEdge���
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
	
	public void removeEdge(int i, int j) {		//���� i->j�� ���ϴ� ��������, j->i�� ���� ������ ���� �� removeEdge���
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
				Queue q = new Queue();				//�̺κк���
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
				}									//������� bfs()
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
		System.out.print("����׷����� ��� ���� �Է��Ͻÿ�(�ִ� 10������ ����): ");
		int noVertex = scan.nextInt();		//�׷��� ��� �� �Է�
		Graph g = new Graph(noVertex);		//��尡 noVertex���� �׷��� ����
		
		do {
			System.out.print("������ �߰��Ϸ��� 1, ������ ������� 2, �׸� �Է��Ϸ��� 0�� �Է��ϼ���: ");
			check = scan.nextInt();
			if(check == 1) {
			System.out.print("���̿� ������ �߰��� ��� 2���� �Է��Ͻÿ�(���� 0���� " + (noVertex-1) +"������ �ֽ��ϴ�)(����׷����Դϴ�): ");
			i = scan.nextInt();
			j = scan.nextInt();
			g.addEdge(i, j);
			}else if(check == 2){
				System.out.print("���̿� ������ ������ ��� 2���� �Է��Ͻÿ�(���� 0���� " + (noVertex-1) +"������ �ֽ��ϴ�): ");
				i = scan.nextInt();
				j = scan.nextInt();
				g.removeEdge(i, j);
			}
		}while(check != 0);
		
		System.out.print("\nComputing the connected components of a graph G: ");
		g.bfsComponents();
	}
}

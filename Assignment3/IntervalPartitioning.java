package assignment3;

class ListNode{
	int data;
	ListNode link;
	
	void ListNode() {
		data = 0;
		link = null;
	}
}

public class IntervalPartitioning {
	static void selectionSort(int[][] a) {			//selection sort by task start time
		selectionSort(a, a.length);				
	}
	static void selectionSort(int[][] a, int length) {
		int temp[][] = new int[1][2];
		
		for(int i = 0; i<length; i++) {
			int min = i;
			for(int j = i+1 ; j<length; j++) {
				if(a[j][0] < a[min][0]) {
					min = j;
				}
			}
			temp[0][0] = a[i][0];
			temp[0][1] = a[i][1];
			a[i][0] = a[min][0];
			a[i][1] = a[min][1];
			a[min][0] = temp[0][0];
			a[min][1] = temp[0][1];
		}

		for(int i = 0; i<a.length; i++) {
			System.out.print("Start : " + a[i][0]+", ");
			System.out.println("End : " + a[i][1]);
		}
		
	}
	
	public static void main(String[] args) {
		int taskNum = 9;
		int max = 24;
		int array[][] = new int[taskNum][2];
		//Task can start(after 9:00) and end on an hourly basis	//시간단위로 가능
		array[0][0] = 9; array[0][1] = 11;
		array[1][0] = 13; array[1][1] = 16;
		array[2][0] = 11; array[2][1] = 14;
		array[3][0] = 10; array[3][1] = 12;
		array[4][0] = 14; array[4][1] = 15;
		array[5][0] = 15; array[5][1] = 17;
		array[6][0] = 9; array[6][1] = 12;
		array[7][0] = 12; array[7][1] = 17;
		array[8][0] = 17; array[8][1] = 23;
		
		System.out.println("Result of Selection Sort by task's starting time");
		selectionSort(array);
		
		ListNode partition[][] = new  ListNode[taskNum][2]; //first is end time, second has linked list
		int partitionNum = 0;	//number of partition
		for(int i = 0; i<taskNum; i++) {					//initialize partition array
			ListNode newNode1 = new ListNode();				//initialize partition array
			newNode1.data = max;						
			ListNode newNode2 = new ListNode();
			partition[i][0] = newNode1;
			partition[i][1] = newNode2;
		}
		
		for(int i= 0; i<taskNum; i++) {
			if(partitionNum != 0) {
				int flag = 0;
				for(int j = 0; j<partitionNum; j++) {
					if(array[i][0] >= partition[j][0].data) {	//compatible
						flag = 1;
						ListNode head = partition[j][1].link;		
						ListNode newNode = new ListNode();
						newNode.data = array[i][0];
						newNode.link = null;
							
						ListNode p = head;
						if(p != null) {
							while(p.link != null) {
								p = p.link;
							}
							p.link = newNode;
						}else {
							partition[j][1].link = newNode;
						}
						partition[j][0].data = array[i][1];		//renew the partition's ending time 
						break;
					}
				}
				//make new partition and insert memory
				if(flag == 0) {
					partitionNum ++;
					ListNode head = partition[partitionNum-1][1].link;
					ListNode newNode = new ListNode();
					newNode.data = array[i][0];			//각 노드의 data는 시작시간
					newNode.link = null;
							
					partition[partitionNum-1][0].data = array[i][1];
					partition[partitionNum-1][1].link = newNode;
				}
			}else {				//make first partition
				partitionNum ++;
				ListNode head = partition[0][1].link;
				ListNode newNode = new ListNode();
				newNode.data = array[i][0];			//task's starting time
				newNode.link = null;
					
				partition[0][0].data = array[i][1];	
				partition[0][1].link = newNode;
			}
		}
		
		System.out.println("\nResult of Interval Partitioning(It shows the task's starting time)");
		for(int i = 0; i < partitionNum; i++) {
			System.out.print("Partition "+(i+1)+" : ");
			ListNode head = partition[i][1].link;
			ListNode p = head;
			while(p.link!= null){
				System.out.print(p.data + " ");
				p = p.link;
			}
			System.out.print(p.data);
			System.out.println();
		}
	}
}

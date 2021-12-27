package assignment4;

public class WIntervalScheduling {					//based on ppt 57 graph
	static void selectionSort(int a[][]) {
		selectionSort(a, a.length);				
	}
	static void selectionSort(int a[][], int length) {
		int temp[][] = new int[1][3];
		
		for(int i = 0; i<length; i++) {
			int min = i;
			for(int j = i+1 ; j<length; j++) {
				if(a[j][1] < a[min][1]) {
					min = j;
				}
			}
			temp[0][0] = a[i][0];
			temp[0][1] = a[i][1];
			temp[0][2] = a[i][2];
			a[i][0] = a[min][0];
			a[i][1] = a[min][1];
			a[i][2] = a[min][2];
			a[min][0] = temp[0][0];
			a[min][1] = temp[0][1];
			a[min][2] = temp[0][2];
		}
		System.out.println("Sorted accodring to finish times: ");
		for(int i = 0; i<a.length; i++) {
			System.out.print("Interval "+i+" => Start : " + a[i][0]+", ");
			System.out.print("End : " + a[i][1]+", ");
			System.out.println("weight : " + a[i][2]);
		}
	}
	static void findP(int a[][], int p[]) {
		int max = p[0];
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<i; j++) {
				if(a[j][1] >=max && a[j][1] <=a[i][0]) {
					max = j;
				}
			}
			p[i] = max;
		}
		
		System.out.println("\nInterval i's P[i] : ");
		for(int i=0; i<p.length; i++) {
			System.out.println("p["+i+"] : " +p[i]);
		}
	}
	static int totalWeight(int a[][], int p[], int num) {
		int t1;
		int t2;
		if(num == 0) {
			t1 = 0;
			t2 = 0;
		}else {
			t1 = a[num][2] + totalWeight(a, p, p[num]);
			t2 = totalWeight(a, p, num-1);
		}
		int max;
		if(t1>=t2) {
			max = t1;
		}else {
			max = t2;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int interval[][] = new int[6][4];
		//interval[][0] : class start time
		//interval[][1] : class finish time
		//interval[][2] : class weight W
		int totalMaxWeight;
		int p[] = new int[6];			//indicate non-overlapping interval with highest finish time which is less that f[i];
		p[0] = 0;
		
		interval[1][0] = 3; interval[1][1] = 5; interval[1][2] = 1;
		interval[2][0] = 0; interval[2][1] = 2; interval[2][2] = 15;
		interval[3][0] = 0; interval[3][1] = 1; interval[3][2] = 5;
		interval[4][0] = 3; interval[4][1] = 4; interval[4][2] = 3;
		interval[5][0] = 1; interval[5][1] = 3; interval[5][2] = 20;
		
		//sorted by finish time
		selectionSort(interval);
		findP(interval, p);
		totalMaxWeight = totalWeight(interval, p,  5);
		System.out.println("\nTotal max weight is : "+totalMaxWeight);
	}
}

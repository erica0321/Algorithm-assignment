package assignment4;

public class MergeSort {
	static void merge(int result[], int a[], int b[]) {
		int k = 0; 										//k�� ���ĵ� �迭�� �ε�����ġ�� ����Ű�� ����
		int i = 0;										//i�� �迭 a[i]�� ����ų �� ���
		int j = 0;										//j�� �迭 b[j]�� ����ų �� ���
		
		while(i<a.length && j<b.length) {		//���� ��
			if(a[i] < b[j]) {
				result[k] = a[i];
				k++;
				i++;
			}else {
				result[k] = b[j];
				k++;
				j++;
			}
		}
		if(i >= a.length) {						//�迭 a�� ������ ������
			while(j<b.length) {					//���� ���ĵ��� ���� �迭 b�� ���Ҹ� result ������ �κп� ����
				result[k] = b[j];
				k++;
				j++;
			}
		}else if(j >= b.length){				//�迭 b�� ������ ������
			while(i<a.length) {					//���� ���ĵ��� ���� �迭 ���� ���Ҹ� result ������ �κп� ����
				result[k] = a[i];
				k++;
				i++;
			}
		}
	}
	
	static void mergeSort(int list[]) {
		//Dive list[] into two array(= one[], two[])
		int firstLength = list.length/2;				//list�� ���̸� 2�� ����
		int one[] = new int[firstLength];				//list�� ���� �迭�� one ����
		for(int n = 0; n<firstLength; n++) {			//list�� ���� �迭�� one���ٰ� ����
			one[n] = list[n];
		}
		
		int secondLength = list.length - firstLength;	
		int two[] = new int[secondLength];				//list�� ������ �迭�� two ����
		for(int n = firstLength; n<list.length; n++) {	//list�� ������ �迭�� two���ٰ� ����
			two[n-firstLength] = list[n];
		}
		
		//If one[] and two[] can not divide anymore, merge start
		if(one.length ==1 & two.length ==1) {			//���� ���̻� one�� two�� 2�� �������� �� ���ٸ�
			merge(list, one, two);						//merge ���� -> ���� ����
			return;
		}
		
		//If one[] and two[] can divide, keep mergeSort
		mergeSort(one);									//one�Ǵ� two�� 2�� �������� �� �ִٸ� mergeSort ���
		mergeSort(two);
		merge(list, one, two);
	}
	
	public static void main(String[] args) {
		int arr[] = new int[8];
		arr[0] = 12;	arr[1] = 9;		arr[2] = 7;		arr[3] = 2;		
		arr[4] = 3;		arr[5] = 8;		arr[6] = 15; 	arr[7] = 7;
		
		mergeSort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}

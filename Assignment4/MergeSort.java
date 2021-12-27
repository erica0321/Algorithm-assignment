package assignment4;

public class MergeSort {
	static void merge(int result[], int a[], int b[]) {
		int k = 0; 										//k는 정렬된 배열의 인덱스위치를 가르키는 변수
		int i = 0;										//i는 배열 a[i]를 가르킬 때 사용
		int j = 0;										//j는 배열 b[j]를 가르킬 때 사용
		
		while(i<a.length && j<b.length) {		//원소 비교
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
		if(i >= a.length) {						//배열 a의 정렬이 끝나면
			while(j<b.length) {					//아직 정렬되지 않은 배열 b의 원소를 result 나머지 부분에 정렬
				result[k] = b[j];
				k++;
				j++;
			}
		}else if(j >= b.length){				//배열 b의 정렬이 끝나면
			while(i<a.length) {					//아직 정렬되지 않은 배열 ㅁ의 원소를 result 나머지 부분에 정렬
				result[k] = a[i];
				k++;
				i++;
			}
		}
	}
	
	static void mergeSort(int list[]) {
		//Dive list[] into two array(= one[], two[])
		int firstLength = list.length/2;				//list의 길이를 2로 나눔
		int one[] = new int[firstLength];				//list의 왼쪽 배열인 one 생성
		for(int n = 0; n<firstLength; n++) {			//list의 왼쪽 배열을 one에다가 복사
			one[n] = list[n];
		}
		
		int secondLength = list.length - firstLength;	
		int two[] = new int[secondLength];				//list의 오른쪽 배열인 two 생성
		for(int n = firstLength; n<list.length; n++) {	//list의 오른쪽 배열을 two에다가 복사
			two[n-firstLength] = list[n];
		}
		
		//If one[] and two[] can not divide anymore, merge start
		if(one.length ==1 & two.length ==1) {			//만약 더이상 one과 two가 2로 나누어질 수 없다면
			merge(list, one, two);						//merge 시작 -> 정렬 시작
			return;
		}
		
		//If one[] and two[] can divide, keep mergeSort
		mergeSort(one);									//one또는 two가 2로 나누어질 수 있다면 mergeSort 계속
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

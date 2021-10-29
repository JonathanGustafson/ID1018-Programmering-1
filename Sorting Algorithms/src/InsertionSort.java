//InsertionSort.java

public class InsertionSort {
	
	public static void Sort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int current = list[i];
			var j = i-1;
			while(j >= 0 && list[j] > current) {
				list[j + 1] = list[j];
				j--;
			}
			list[j+1] = current;
		}
	}

}

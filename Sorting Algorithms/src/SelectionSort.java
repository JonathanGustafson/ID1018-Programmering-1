//SelectionSort.java
public class SelectionSort {

	public static void Sort(int[] list) {
		
		for(int i = 0; i < list.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < list.length; j++) {
				if(list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int a = list[i];
				list[i] = list[minIndex];
				list[minIndex] = a;
			}
			
		}
		
	}
	
}

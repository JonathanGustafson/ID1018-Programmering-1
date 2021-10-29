import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		
		int[] list = {9, 3, 2, 3, 5, 7, 1};
		
		//InsertionSort.Sort(list);
		SelectionSort.Sort(list);
		System.out.println(Arrays.toString(list));
		
		int targetIndex = BinarySearch.Search(list, 6);
		
		if(targetIndex != -1)
			System.out.println(targetIndex);
		else
			System.out.println("Number does not exist in array");
		
		targetIndex = SeqSearch.Search(list, 6);
		
		if(targetIndex != -1)
			System.out.println(targetIndex);
		else
			System.out.println("Number does not exist in array");
	}

}

import java.util.ArrayList;
public class klists {

	
	private double[] kLists(double [][]outerArr) {
		double[] arr = new double [getSize(outerArr)]; //declaring array to be returned with the size = total number of values in outerArray 
		double [][]list2sort; // array to pass to mergeArr function
		while (arr[arr.length-1] == 0) {
			 list2sort = new double[2][];  //clearing the list and reinitilaizing 
			 for (int  i = 0; i< outerArr.length; i+=2) { // everytime we compare arrays, move i twice and try again until done
				 if(i == outerArr.length-1) {
					 list2sort[1] = outerArr[i]; // if we;re at the end of the array, then add the last array of outerArr to index 1 of list2sort
					
				 }
				 else {
					 list2sort[0] =this.mergeArr(outerArr[i], outerArr[i+1]); // array already sorted = first array in list2sort
				 }
				 
			 }
			 	arr = this.mergeArr(list2sort[0], list2sort[1]); // once we have our final two arrays to sort, we merge them
				//arr = list2sort[0];
			 }
			 
		
		return arr; // return sorted 1D array
	
}
	private int getSize(double[][] outerArray) { // returns total number of elements present in intial array
		int size= 0;
		int f = outerArray.length;
		for (int i = 0; i< f; i++) {
			size+=outerArray[i].length;
			
		}
		return size;  // used to initialize size of new array 
	}
	
	
	private double [] mergeArr(double []arr1, double []arr2) { // merging two sorted lists
		double [] returnArr = new double [arr1.length + arr2.length];
		int a1 = 0;
		int a2 = 0;
		while(a1 +a2 < arr1.length + arr2.length) {
			if(a1 < arr1.length &&(a2 == arr2.length || arr1[a1]<arr2[a2])) {
				returnArr[a1+a2]= arr1[a1];
				a1++;
			}
			else {
				returnArr[a1+a2]= arr2[a2];
				a2++;
			}
		}
			
				return returnArr; // too be used in klists function
	}
	
	public static void main (String args[]) {
		double [][] outerArr = {{1.2 ,1.6, 2.5} ,{1.3, 1.4, 1.5} ,{1.4, 1.7}};
		klists a = new klists();
		System.out.println(a.getSize(outerArr));
		double[] nlist = a.kLists(outerArr);
		for (int i = 0; i < nlist.length; i++) {
			System.out.print(nlist[i]+ " ");
		}
		
	}
}

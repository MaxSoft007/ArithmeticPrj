package org.maxsoft.sort;

/**
 * √∞≈›≈≈–Ú
 * @author zhaoyl
 * @date May 1, 2016
 */
public class BubbleSort {
	int count = 0;
	
	/**
	 * √∞≈›≈≈–Ú µœ÷1
	 * @param a
	 */
	public void bubbleSort(int[] a){
		int size = a.length;
		int temp;
		for (int i=1; i<size; i++) {
			for(int j=0; j<size-i;j++){
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					count++;
				}
			}
		}
	}
	
	/**
	 * √∞≈›≈≈–Ú µœ÷2
	 * @param a
	 */
	public void bubbleSort2(int[] a){
		int size = a.length;
		int temp;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(a[i] > a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j]= temp;
					count++;
				}
			}
		}
	}

	public static void main(String[] args){
		int[] sort = {3,8,6,4,2,1,0,5,9,7};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort2(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(" " + sort[i] + " ");
		}
		System.out.println();
		System.out.println("≈≈–Ú¥Œ ˝£∫"+bubbleSort.count);
	}
}

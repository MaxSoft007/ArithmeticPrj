package org.maxsoft.sort;

/**
 * ≤Â»Î≈≈–Ú
 * @author zhaoyl
 * @date May 1, 2014
 */
public class InsertSort {

	/**
	 * ≤Â»Î≈≈–Úπ˝≥Ã
	 * @param a
	 */
	public void insertSort(int[] a){
		int size = a.length;
		int temp;
		for (int i = 1; i < size; i++) {
			int j=i-1;
			temp = a[i];
			for (; j>=0 && temp < a[j]; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = temp;
		}
	}
	
	/**
	 * ≤Â»Î≈≈–Ú2
	 * @param a
	 */
	public void insertSort2(int[] a){
		int size = a.length;
	    for (int i=0; i<size; i++){
	        for (int j=i; j>0 && a[j-1] > a[j]; j--){
			    int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
	        }
	    }
	}
	
	public static void main(String[] args){
		int[] sort = {3,8,6,4,2,1,0,5,9,7};
		InsertSort insertSort = new InsertSort();
		insertSort.insertSort2(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(" "+sort[i]+" ");
		}
	}
}

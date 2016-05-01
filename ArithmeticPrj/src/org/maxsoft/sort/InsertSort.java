package org.maxsoft.sort;

/**
 * 插入排序
 * @author zhaoyl
 * @date May 1, 2016
 */
public class InsertSort {

	/**
	 * 插入排序过程
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
	
	public static void main(String[] args){
		int[] sort = {3,8,6,4,2,1,0,5,9,7};
		InsertSort insertSort = new InsertSort();
		insertSort.insertSort(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(" "+sort[i]+" ");
		}
	}
}

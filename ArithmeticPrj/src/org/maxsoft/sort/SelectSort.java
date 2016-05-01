package org.maxsoft.sort;

/**
 * 选择排序
 * @author zhaoyl
 * @date May 1, 2016
 */
public class SelectSort {

	/**
	 * 选择排序实现1
	 * @param a
	 */
	public void selectSort(int[] a){
		int size = a.length;
		int index;
		int temp;
		for (int i=0; i<size; i++) {
			index = i;
			for (int j=i+1; j<size; j++) {
				if(a[j] <= a[index]){
					index = j;
				}
			}
			if(index != i){
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
		}
	}
	
	/**
	 * 选择排序实现2
	 * @param a
	 */
	public void selectSort2(int[] a){
		int size = a.length;
		int position;
		int temp;
		for (int i = 0; i < size; i++) {
			int j = i+1;
			position = i;
			temp = a[i];
			for (; j<size; j++) {
				if(a[j] <= temp){
					temp = a[j];
					position = j;
				}
			}
			a[position] = a[i];
			a[i] = temp;
		}
	}
	
	public static void main(String[] args){
		int[] sort = {3,8,6,4,2,1,0,5,9,7};
		SelectSort selectSort = new SelectSort();
		selectSort.selectSort2(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(" "+sort[i]+" ");
		}
	}
}

package org.maxsoft.sort;

/**
 * 快速排序
 * @author zhaoyl
 * @date May 1, 2014
 */
public class QuickSort {
	
	/**
	 * 对待排序的数组对象分区
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public int partition(int[] a,int min, int max){
		while(min < max){
			while(min < max && a[min] <= a[max])
				max--;
			if(min < max){
				int temp = a[min];
				a[min] = a[max];
				a[max] = temp;
				min++;
			}
			while(min < max && a[min] <= a[max])
				min++;
			if(min < max){
				int temp = a[min];
				a[min] = a[max];
				a[max] = temp;
				max--;
			}
			
		}
		return min;
	}
	
	/**
	 * 对待排序的数据对象分区
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public int partition2(int[] a,int min,int max){
		int temp = a[min];
		while(min < max){
			while(min < max && temp <= a[max])
				max--;
			if(min < max)
				a[min++] = a[max];
			while(min < max && temp >= a[min])
				min++;
			if(min < max)
				a[max--] = a[min];
		}
		a[min] = temp;
		return min;
	}
	
	/**
	 * 利用递归算法进行快速排序
	 * @param a
	 * @param min
	 * @param max
	 */
	public void quickSort(int[] a,int min,int max){
		int dp;
		if(min < max){
			dp = partition(a, min, max);
			quickSort(a, min, dp-1);
			quickSort(a, dp+1, max);
		}
	}

	public static void main(String[] args){
		int[] sort = {3,8,6,4,2,1,0,5,9,7};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(sort, 0, sort.length-1);
		
		for (int i = 0; i < sort.length; i++) {
			System.out.print(" "+sort[i]+" ");
		}
	}
}

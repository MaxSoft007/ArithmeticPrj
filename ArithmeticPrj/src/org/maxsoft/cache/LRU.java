package org.maxsoft.cache;

/**
 * �������ʹ���㷨 OR ҳ���û��㷨֮һ
 * @author zhaoyl
 * @date May 1, 2014
 */
public class LRU {
	
	private static final int DEFAULT_SIZE = 5;
	private int boundary = -1;
	private int size;
	private Object[] os = null;
	
	/**
	 * ��ʼ�������С
	 * @param size
	 */
	public LRU(int size) {
		if(size > 0){
			os = new Object[size];
		}else{
			os = new Object[DEFAULT_SIZE];
		}
		boundary = size;
	}
	
	/**
	 * �жϻ����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		if(size == 0) return true;
		return false;
	}
	
	/**
	 * �жϻ����Ƿ�Խ��
	 * @return
	 */
	public boolean isOutOfBoundary(){
		if(size >= boundary) return true;
		return false;
	}
	
	/**
	 * ��ѯָ��Ԫ�صĻ���λ������
	 * @param o
	 * @return
	 */
	public int indexOfElement(Object o){
		for (int i = 0; i < size; i++) {
			if(os[i]==o)return i;
		}
		return -1;
	}
	
	/**
	 * ���л�������
	 * @param o
	 * @return
	 */
	public Object push(Object o){
		int index = -1;
		if(!isOutOfBoundary()&&indexOfElement(o)==-1){
			os[size] = o;
			size++;
		}else if(isOutOfBoundary() && indexOfElement(o)==-1){
			for (int i = 0; i < size-1; i++) {
				os[i]=os[i+1];
			}
			os[size-1] = o;
		}else{
			index = indexOfElement(o);
			for (int i = index; i < size-1; i++) {
				os[i] = os[i+1];
			}
			os[size-1] = o;
		}
		if(index == -1) return o;
		return os[index];
	}
	
	/**
	 * ��ʾ����������
	 */
	public void display(){
		for (int i = 0; i < size; i++) {
			System.out.print(" " + os[i] + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		LRU lru = new LRU(8);
		int[] a = {6,9,1,3,4,0,2,3,12,23,12,6,2,9,4,11};
		for (int i = 0; i < a.length; i++) {
			lru.push(a[i]);
			lru.display();
			System.out.println();
		}
	}

}

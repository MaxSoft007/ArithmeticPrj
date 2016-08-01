package org.maxsoft.reserve;

/**
 * �ַ�����ת����ѯ
 * @author zhaoyl
 * @date May 1, 2014
 */
public class StringReserve {
	
	/**
	 * �ַ�����ת
	 * @param s
	 * @return
	 */
	public String stringReserve(String s){
		char[] cs = s.toCharArray();
		int len = cs.length - 1;
		char temp;
		for (int i = 0; i <= len >> 1; i++) {
			temp = cs[i];
			cs[i] = cs[len - i];
			cs[len - i] = temp;
		}
		return String.valueOf(cs);
	}
	
	/**
	 * ���ᷭת�ַ���
	 * @param s
	 * @param index
	 * @return
	 */
	public String indexOfReserve(String s,int index){
		char c_temp;
		char[] cs = s.toCharArray();
		if( cs != null && index < cs.length && index > 0){
			//���Ƚ�����෭ת
			int lt = index - 1;
			for (int i = 0; i <= lt >> 1; i++) {
				c_temp = cs[i];
				cs[i]=cs[lt-i];
				cs[lt-i] = c_temp;
			}
			//��ν����Ҳ෭ת
			int rt = cs.length -1;
			for (int i = index+1; i <= rt >> 1; i++) {
				c_temp = cs[i];
				cs[i]=cs[rt-i];
				cs[rt-i] = c_temp;
			}
			//�����д�ת
			int len = cs.length - 1;
			for (int i = 0; i <= len>>1; i++) {
				c_temp = cs[i];
				cs[i] = cs[len-i];
				cs[len-i]=c_temp;
			}
		}
		return String.valueOf(cs);
	}

	/**
	 * �ַ���������ƥ��
	 * @param des
	 * @param sur
	 * @return
	 */
	public int indexOfString(String des,String sur){
		int sur_length = sur.length();
		int index = -1;
		for(int i=0;i<des.length();i++){
			if(i+sur_length > des.length()) return -1;
			if(des.substring(i, i+sur_length).equals(sur)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * �ַ���������ƥ��2
	 * @param des
	 * @param sur
	 * @return
	 */
	public int indexOfString2(String des,String sur){
		char[] charArray = des.toCharArray();
		char[] charArray2 = sur.toCharArray();
		int index=-1;
		for (int i = 0; i < charArray.length; i++) {
			for(int j=0;j<charArray2.length; j++){
				if(charArray2[j]==charArray[i]){
					if(j==charArray2.length-1){
						index = i-charArray2.length+1;
						break;
					}
					i++;
				}else{
					break;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args){
		StringReserve reserve = new StringReserve();
		String str = "ABCD";
		String stringReserve = reserve.stringReserve(str);
		System.out.println(stringReserve);
		String string = "ABC";
		String stringReserve2 = reserve.stringReserve(string);
		System.out.println(stringReserve2);
		
		String string_2 = "�й����ż��Ź�˾����";
		String indexOfReserve = reserve.indexOfReserve(string_2,5);
		System.out.println(indexOfReserve);
		System.out.println(string_2.getBytes().length);//GBK���� һ������ռ2���ֽ�
		
		int indexOfString = reserve.indexOfString2("ABCDEF","G");
		System.out.println(indexOfString);
	}
}

package org.maxsoft.reserve;

/**
 * 字符串翻转、查询
 * @author zhaoyl
 * @date May 1, 2014
 */
public class StringReserve {
	
	/**
	 * 字符串翻转
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
	 * 中轴翻转字符串
	 * @param s
	 * @param index
	 * @return
	 */
	public String indexOfReserve(String s,int index){
		char c_temp;
		char[] cs = s.toCharArray();
		if( cs != null && index < cs.length && index > 0){
			//首先进行左侧翻转
			int lt = index - 1;
			for (int i = 0; i <= lt >> 1; i++) {
				c_temp = cs[i];
				cs[i]=cs[lt-i];
				cs[lt-i] = c_temp;
			}
			//其次进行右侧翻转
			int rt = cs.length -1;
			for (int i = index+1; i <= rt >> 1; i++) {
				c_temp = cs[i];
				cs[i]=cs[rt-i];
				cs[rt-i] = c_temp;
			}
			//最后进行大翻转
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
	 * 字符串查找与匹配
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
	 * 字符串查找与匹配2
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
		
		String string_2 = "中国电信集团公司本部";
		String indexOfReserve = reserve.indexOfReserve(string_2,5);
		System.out.println(indexOfReserve);
		System.out.println(string_2.getBytes().length);//GBK编码 一个汉字占2个字节
		
		int indexOfString = reserve.indexOfString2("ABCDEF","G");
		System.out.println(indexOfString);
	}
}

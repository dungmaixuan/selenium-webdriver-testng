package basic;

import java.util.ArrayList;
import java.util.List;

public class Topic_02_Data_Type {
	public static void main(String[] args) {
		char c = 'A';
		System.out.println(c);
		byte bNumber = 15;
		System.out.println(bNumber);
		short sNumber = -32000;
		System.out.println(sNumber);
		int iNumber = 2000000000;
		System.out.println(iNumber);
		long lNumber = 92125444;
		System.out.println(lNumber);
		float fNumber = 9.5f;
		System.out.println(fNumber);
		double dNumber = 9.5d;
		System.out.println(dNumber);
		boolean marriedStatus = true;
		System.out.println(marriedStatus);
	
		Object o = new Object();
		
		String[] address = {"Ha Noi", "Sai Gon", "Da Nang"};
		Long a[] = { 100000L, 300000L};
		Integer[] phone = { 6955, 569};
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		List<String> addresses = new ArrayList<String>();
 		String name = "Automation";
 		String cityName = new String("Ho Chi Minh");
	}

}

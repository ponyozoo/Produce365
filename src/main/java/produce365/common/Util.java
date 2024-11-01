package produce365.common;

import java.util.Random;

public class Util {
	public int makeTraineeId(String hireDate, String sex) {
		int id = 32000;
		
		id += Integer.parseInt(hireDate.substring(2, 4)) * 10 + (sex.equals("M") ? 1 : 2);
		
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			sb.append(random.nextInt(10));
		}
		
		id = id * 1000 + Integer.parseInt(sb.toString());
		
		return id;
	}
}

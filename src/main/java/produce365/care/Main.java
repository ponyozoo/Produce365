package produce365.care;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		  CareDAO careDao = new JDBCCareDAO();
		  Care care = new Care();
		  
		  //Care 추가 O
	      care.setCategory("자세교정 프로그램");
	      care.setCost(200000);
	      if(careDao.insert(care) == true) {
	    	  System.out.println(care + "성공적으로 추가 완료하였습니다.");
	      }else {
	    	  System.out.println("추가에 실패하였습니다.");
	      }
		  
		  
		  //Care목록 보기 O
		  List<Care> cares = new ArrayList<Care>();
		  cares = careDao.findAll();
		  for (Care c : cares) {
		  System.out.println(c);
		}
		  //Care id로 찾기 O
		  //Care care = careDao.findById(5);
		  //System.out.println(care);
		  
		  //Care 삭제 O
		  //System.out.println(careDao.deleteById(2));
		  
	}
}


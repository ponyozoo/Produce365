package produce365.debutMember;

import java.sql.SQLException;
import java.util.List;

public interface DebutMemberDAO {

	//1. 데뷔멤버 추가 : trainee 정보를  debutMember DB에 넣는다.
	boolean insert(DebutMember debutMember);
	
	//2. 데뷔멤버 삭제
	boolean delete(DebutMember debutMember);
	
	//3. 데뷔멤버 전체 조회
	public List<DebutMember> selectAll();
	
	//4. 데뷔멤버 그룹별 조회
	public List<DebutMember> selectByGroup(int groupId);
	
	
}

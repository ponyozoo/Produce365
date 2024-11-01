package produce365.debutMember;

import java.util.List;

public interface DebutMemberDAO {

	boolean insert(DebutMember debutMember);
	
	boolean delete(DebutMember debutMember);
	
	public List<DebutMember> selectAll();
	
	public List<DebutMember> selectByGroup(int groupId);
	
	
}

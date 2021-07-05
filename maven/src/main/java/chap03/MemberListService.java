package chap03;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListService {
	@Autowired
	private MemberDao memberDao;
	
//	public MemberListService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Map<String, Member> selectList() {
		return memberDao.selectList();
	}
}

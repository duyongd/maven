package chap02;

public class MemberInfoService {
	private MemberDao memberDao;
	
	public MemberInfoService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Member selectOne(String email) {
		return memberDao.selectByEmail(email);
	}
}

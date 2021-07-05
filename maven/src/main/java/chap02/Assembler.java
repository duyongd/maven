package chap02;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	private MemberListService listSvc;
	private MemberInfoService infoSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		listSvc = new MemberListService(memberDao);
		infoSvc = new MemberInfoService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	public MemberListService getListSvc() {
		return listSvc;
	}
	public MemberInfoService getInfoSvc() {
		return infoSvc;
	}
	
}

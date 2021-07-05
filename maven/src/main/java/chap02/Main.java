package chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		//new hong@gmail.com 홍길동 1234 1234
		//change hong@gmail.com 1234 5678
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력해 주세요.");
			String cmd = reader.readLine();
			if (cmd.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			} else if(cmd.startsWith("new")) {
				
				processNewCommand(cmd.split(" "));
			} else if(cmd.startsWith("change")) {
				processChangeCommand(cmd.split(" "));
			} else if(cmd.equals("list")) {
				// hong@gmail.com 홍길동 비밀번호 날짜
				processListCommand();
				// cmd.startWith("info")
				//info 이메일
				//id : 1, email:hong name:홍 date:2021
				//없으면 -> 등록되지않은 이메일입니다.
			} else if(cmd.startsWith("info")) {
				processInfoCommand(cmd.split(" "));
			}
		}
	}
	
	private static Assembler assembler = new Assembler();
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			return;
		}
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록완료");
		} catch (DuplicateMemberException e) {
			System.out.println("이메일 중복");
		}
	}
	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			return;
		}
		ChangePasswordService pwdSvc = assembler.getPwdSvc();
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호 변경");
		} catch(MemberNotFoundException e) {
			System.out.println("회원이 존재하지 않습니다.");
		} catch(WrongIdPasswordException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private static void processListCommand() {
		MemberListService listSvc = assembler.getListSvc();
		Map<String, Member> map = listSvc.selectList();
		Set set = map.keySet();
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String k = iter.next();
			System.out.println(map.get(k).getEmail() + ", " + map.get(k).getId() + ", " + map.get(k).getName() + ", " + map.get(k).getPassword());
		}
		
	}
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			return;
		}
		MemberInfoService infoSvc = assembler.getInfoSvc();
		Member member = infoSvc.selectOne(arg[1]);
		if(member == null) {
			System.out.println("등록되지않은 이메일입니다.");
		} else {
			System.out.println("id : " + member.getId() + " email : " + member.getEmail() + " name : " + member.getName() + " date : " + member.getRegisterDateTime() + " pwd : " + member.getPassword());
		}
	}
	
}


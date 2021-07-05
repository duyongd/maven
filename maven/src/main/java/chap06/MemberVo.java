package chap06;

public class MemberVo {
	private String name;
	private String email;
	private int no;
	private int[] hobby;
	
	public int[] getHobby() {
		return hobby;
	}
	public void setHobby(int[] hobby) {
		this.hobby = hobby;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

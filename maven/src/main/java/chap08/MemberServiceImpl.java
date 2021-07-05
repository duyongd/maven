package chap08;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;
	
	@Override
	public List<MemberVo> selectList() {
		return dao.selectList();
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}

	@Override
	public String mypage(HttpSession sess, Model model) {
		MemberVo vo = (MemberVo)sess.getAttribute("memberInfo");
		MemberVo m = dao.selectOne(vo.getMno());
		model.addAttribute("vo", m);
		return "member/mypage";
	}

	@Override
	public int update(MemberVo vo) {
		return dao.update(vo);
	}
}

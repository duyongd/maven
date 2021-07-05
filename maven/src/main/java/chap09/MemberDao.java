package chap09;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired //  SqlSessionTemplate 타입을 같은걸 bean에서 찾아서 대입을 해줌
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVo> selectList() {
		return sqlSessionTemplate.selectList("member.selectList");
	}
	
	public MemberVo login(MemberVo vo) {
		return sqlSessionTemplate.selectOne("member.login", vo);
	}
	
	public MemberVo selectOne(int mno) {
		return sqlSessionTemplate.selectOne("member.selectOne", mno);
	}
	
	public int update(MemberVo vo) {
		return sqlSessionTemplate.update("member.update", vo);
	}
	
	public int insert(MemberVo vo) {
		return sqlSessionTemplate.insert("member.insert", vo);
	}
	
	public int insertSchool(Map map) {
		return sqlSessionTemplate.insert("member.insertSchool", map);
	}
}

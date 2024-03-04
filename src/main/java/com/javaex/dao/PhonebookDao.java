package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	// 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");

		int count = sqlSession.delete("phonebook.delete", no);
		System.out.println(count);

		return count;
	}

	// 수정
	public int personModify(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate()");

		System.out.println(personVo);

		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);

		return count;
	}

	// 수정폼(1개 가져오기) 1
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}

	// 수정폼(1개 가져오기) 2
	public Map<String, Object> personSelectOne2(int no) {
		System.out.println("PhonebookDao.personSelectOne2()");
		System.out.println(no);
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);
		System.out.println(pMap.get("personId"));
		System.out.println(pMap.get("name"));
		System.out.println(pMap.get("hp"));
		System.out.println(pMap.get("company"));
		
		return pMap;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		int count = sqlSession.insert("phonebook.insert", personVo);
		System.out.println(count);
		return 0;
	}

	// 등록2
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("PhonebookDao.personInsert2()");
		System.out.println(pMap);

		sqlSession.insert("phonebook.insert2", pMap);
		return 0;
	}

	// 전체가져오기
	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		System.out.println(personList);

		return personList;
	}

}

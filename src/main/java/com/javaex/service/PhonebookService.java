package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	// 필드
	@Autowired
	private PhonebookDao phonebookDao;
	// 생성자
	// 메소드 g/s
	// 메소드 일반

	// 수정
	public void exeModify(PersonVo personVo) {
		// PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personModify(personVo);
	}

	// 수정폼 1
	public PersonVo exeModifyForm(int personId) {
		// PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(personId);

		return personVo;
	}

	// 수정폼 2
	public Map<String, Object> exeModifyForm2(int personId) {
		System.out.println("PhonebookService.exeModifyForm2()");
		
		Map<String, Object> pMap = phonebookDao.personSelectOne2(personId);

		return pMap;
	}

	// 리스트
	public List<PersonVo> exeList() {
		// PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();

		return personList;
	}

	// 등록
	public void exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		// 비지니스 로직
		// PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personInsert(personVo);

	}

	// 등록 2
	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		// PersonVo를 제작해서 묶는다 --> 그런데 딱 한 번만 쓸 것 같다
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);

		phonebookDao.personInsert2(personMap);

		return 0;
	}

	// 삭제
	public void exeDelete(int personId) {
		// PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personDelete(personId);
	}

}

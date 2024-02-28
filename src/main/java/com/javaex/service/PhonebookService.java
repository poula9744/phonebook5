package com.javaex.service;

import java.util.List;

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

	// 수정폼
	public PersonVo exeModifyForm(int personId) {
		// PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(personId);

		return personVo;
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

	// 삭제
	public void exeDelete(int personId) {
		// PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personDelete(personId);
	}

}

package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller // @Controller 달고 있는 친구만 대상
public class PhoneController {

	// 필드
	// 자동으로 연결해줘/ new 안해도 됨
	@Autowired
	private PhonebookService phonebookService; // 메모리에 올려줘
	// 생성자
	// 메소드 - g/s
	// 메소드 - 일반

	//수정폼
	@RequestMapping(value = "/phone/mform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int personId, Model model) {
		System.out.println("PhonebookController.modifyForm()");

		// PhonebookService phonebookService = new PhonebookService();
		PersonVo personVo = phonebookService.exeModifyForm(personId);

		model.addAttribute("personVo", personVo);

		return "modifyForm"; // ==포워드
	}

	// 등록
	// http://localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write2()");

		System.out.println(personVo.toString());

		// 서비스를 메모리에 올리고
		// 서비스의 메소드 사용
		// PhonebookService phonebookService = new PhonebookService(); --> 필드에 올려서 필요없음
		phonebookService.exeWrite(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	// 리스트
	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) { // 모델이라는 상자에 담아 놓는다
		System.out.println("PhonebookController.list()");

		// PhonebookService phonebookService = new PhonebookService();
		List<PersonVo> personList = phonebookService.exeList();

		// PhonebookDao phonebookDao = new PhonebookDao();
		// List<PersonVo> personList = phonebookDao.personSelect();
		// System.out.println(personList);

		model.addAttribute("pList", personList);

		return "list";
	}

	// 등록폼
	// http://localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value = "/phone/writeform", method = { RequestMethod.GET, RequestMethod.POST }) // 요청이 오면 이 친구를 // 다
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm"; // ==포워드
	}

	// 등록
	// http://localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	@RequestMapping(value = "/phone/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam(value = "name") String name, @RequestParam(value = "hp") String hp,
			@RequestParam(value = "company") String company) {
		System.out.println("PhonebookController.write()");

		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		// vo 묶는다
		PersonVo personVo = new PersonVo(name, hp, company);

		// dao를 메모리에 올린다
		PhonebookDao phonebookDao = new PhonebookDao();

		// dao.personInsert(vo)
		phonebookDao.personInsert(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int personId) {
		System.out.println("PhonebookController.delete()");

		// PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeDelete(personId);

		// db사용
		// PhonebookDao phonebookDao = new PhonebookDao();
		// 삭제
		// phonebookDao.personDelete(personId);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {

		// 확인
		System.out.println("PhonebookController.modify()");

		// vo로 묶기
		// PersonVo personVo = new PersonVo(personId, name, hp, company);

		// PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeModify(personVo);

		// db사용
		// PhonebookDao phonebookDao = new PhonebookDao();
		// 삭제
		// phonebookDao.personModify(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

}

package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

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

	// 수정폼(1개 가져오기)
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		int count = sqlSession.insert("phonebook.insert", personVo);
		System.out.println(count);
		return 0;
	}

	// 전체가져오기
	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		System.out.println(personList);

		return personList;
	}

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Autowired
	private DataSource dataSource;

	// 생성자
	// 메소드-gs

	// 메소드-일반

	// 연결
	public void getConnection() {
		try {
			// 2. Connection 얻어오기
			conn = dataSource.getConnection();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 종료
	public void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

}

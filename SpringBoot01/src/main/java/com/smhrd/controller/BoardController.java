package com.smhrd.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;
import com.smhrd.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {


	// 이 방법을 사용하는 경우 mapper가 필요가 없음 service로 mapper를 대체하는듯함
	
	private final BoardService service;
//	final을 붙여야만 값이 들어옴 무조건 붙어야함!!
	@Autowired
	private BoardMapper mapper;

	@GetMapping("/boards")
	public String list(Model model) {
		// 1. 데이터 수집
		// 2. 기능 실행
		List<Board> list = service.getlist();

		// Scope : 정보 저장(유지) 4개의 내장객체
		// page : 하나의 JSP 안에서만 유지가능
		// request*** : 한번의 요청 - 응답 동안만 유지
		// >> Model 객체 : 다이어트한 request, 저장기능외에 다른 기능을 제거한 request
		// session : 하나의 브라우저 내에서
		// application : 서버종료시까지, 공용공간
		model.addAttribute("list", list);

		// 3. View 이동
		return "boardMain"; // /WEB-INF/views/boardMain.jsp
	}

	@GetMapping("/boards/new")
	public String writerBoard() {
		// 1. 데이터 수집
		// 2. 기능 실행
		// 3. View 선택
		// return "writerBoard";
		// 리턴 타입이 void인 경우 >> urlMapping을 jsp 이름이라 간주하고 forward
		return "writerBoard";
	}

	@PostMapping("/boards")
	public String write(Board board, MultipartFile file) {

		// 2. 기능 실행
		service.addBoard(board, file);

		// 3. View 이동
		return "redirect:/boards";
	}

	@GetMapping("/boards/{idx}")
	public String view(@PathVariable Long idx, Model model) {
		// 1. 데이터 수집
		// 2. 기능 실행

		Board board = service.getBoardDetail(idx);

		model.addAttribute("board", board);

		// 3. View 이동
		return "viewBoard";
	}

	// ~~~~~~/delete/3
	@RequestMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		// 1. 데이터 수집
		// 2. 기능 실행
		mapper.delete(idx);

		// 3. View 이동
		return "redirect:/list";
	}

	@RequestMapping("/axios")
	public void axios() {
	}

}

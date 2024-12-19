package com.smhrd.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;
import com.smhrd.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

	@Autowired
	private BoardMapper mapper;
	private final BoardService service;

	@GetMapping("/boards/search")
	public List<Board> search(String text) {
		// 1. 데이터 수집
		// 2. 기능 실행
		return service.searchBoards(text);
		// 3. 데이터 응답
	}

	@DeleteMapping("/boards/{idx}")
	public String delete(@PathVariable Long idx) {
		service.deleteBoard(idx);
		
		return "delete";
		
	}
	
	@RequestMapping("/chart")
	public List<Board> chart() {
		// 1. 데이터 수집
		// 2. 기능 실행
		List<Board> list = mapper.chart();

		// 3. 데이터 응답
		return list;
	}

}

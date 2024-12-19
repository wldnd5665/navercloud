package com.smhrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	// 검색어가 포함된 타이틀을 가지고있는 책정보(리스트) 리턴 => like

	List<Board> findByTitleContaining(String title);

}

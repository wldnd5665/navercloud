package com.smhrd.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Board;
import com.smhrd.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository repo;

	public List<Board> getlist() {
		return repo.findAll();

	}

	// @Value를 이용해서 변수 값을 채울 수 있다.
	// 어노테이션 안에서 ${프로퍼티 이름}를 사용해서 application.properties에 정의해둔
	// 데이터를 가져올 수 있다.

	@Value("${save.path}")
	private String savePath;

	public void addBoard(Board board, MultipartFile file) {

		if (file == null) {
			board.setImg("none");
		} else {

			try {
				// 1) 앞에 랜덤한 문자열을 붙여서, 파일 이름 중복 방지
				String uuid = UUID.randomUUID().toString();
				String filename = uuid + file.getOriginalFilename();
				// 2) 전체 경로( 폴더 경로 + 파일 이름 )
				Path path = Paths.get(savePath + filename);
				// 3) 저장
				file.transferTo(path);
				board.setImg(filename);
			} catch (Exception e) {
				e.printStackTrace(); // 오류 메세지 출력
			}
		}
		repo.save(board);

	}

	public Board getBoardDetail(Long idx) {

		// Optional => null 처리 자동으로 되는 객체 형태
		// null 값을 가지거나 Board 값을 가지고있음
		Optional<Board> res = repo.findById(idx);
		// 실제 Board 객체를 꺼내오려면 get으로 호출해야함
		return res.get();

	}

	public List<Board> searchBoards(String title) {

		return repo.findByTitleContaining(title);

	}

	public void deleteBoard(Long idx) {
		repo.deleteById(idx);
	}

}

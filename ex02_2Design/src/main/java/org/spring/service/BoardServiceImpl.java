package org.spring.service;

import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
//	// 의존성 주입 autowired이용방법
//	@Autowired
//	private BoardMapper mapper;
	
	// 의존성 주입(final)(AllArgsConstructor이용)
	private final BoardMapper mapper;
	
	@Override
	public List<BoardVO> listAll() {
		log.info("listAll()실행");
		return mapper.selectAll();
	}

	@Override
	public int register(BoardVO vo) {
		log.info("register()실행 vo: "+vo);
		mapper.insert(vo);
		int num = mapper.num();
		return num;
	}

	@Override
	public int modify(BoardVO vo) {
		log.info("modify실행");
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		log.info("remove실행");
		return mapper.delete(key);
	}

	@Override
	public BoardVO get(Integer key) {
		log.info("get실행");
		return mapper.select(key);
	}
}

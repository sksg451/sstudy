package org.spring.mapper;

import java.util.List;

import org.spring.domain.BoardVO;

public interface BoardMapper {
	// CRUD
	public void insert(BoardVO vo);
	
	public void insertSelectBno(BoardVO vo);
//	@Select("select * from tbl_board") BoardMapper.xml에 작성하는게 아니라 여기에 이렇게 해도 가능
//	하지만 별로 추천하지는 않음
	public List<BoardVO> selectAll();
	
	public int update(BoardVO vo);
	
//	@Delete("delete from tbl_board where bno=#{bno}")
	public int delete(int bno);
	
	//글 상세보기
	public BoardVO select(Integer key);
	
	public int num();
}

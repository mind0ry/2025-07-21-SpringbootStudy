package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BoardMapper;
import com.sist.web.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;
	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}
	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return mapper.boardListData(start);
	}
	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

}

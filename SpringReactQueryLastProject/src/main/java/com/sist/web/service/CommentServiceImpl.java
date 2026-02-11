package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.dto.*;
import com.sist.web.repository.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.entity.*;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository cRepo;

	@Override
	public List<CommentDTO> commentListData(int contentid) {
		// TODO Auto-generated method stub
		return cRepo.commentListData(contentid);
	}

	@Override
	public List<CommentDTO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		int no=cRepo.maxNo();
		vo.setNo(no);
		vo.setRegdate(new Date());
		cRepo.save(vo);
		return cRepo.commentListData(vo.getCno());
	}

	@Override
	public List<CommentDTO> commentDelete(int no, int cno) {
		// TODO Auto-generated method stub
		CommentEntity vo=cRepo.findByNo(no);
		cRepo.delete(vo);
		return cRepo.commentListData(cno);
	}

	@Override
	public List<CommentDTO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo=cRepo.findByNo(no);
		vo.setMsg(msg);
		vo.setNo(no);
		cRepo.save(vo);
		return cRepo.commentListData(vo.getCno());
	}

	
}
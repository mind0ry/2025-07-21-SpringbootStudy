package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;

public interface CommentService {

	public List<CommentDTO> commentListData(int contentid);
	public List<CommentDTO> commentInsert(CommentEntity vo);
	public List<CommentDTO> commentDelete(int no,int cno);
	public List<CommentDTO> commentUpdate(int no,String msg);
}

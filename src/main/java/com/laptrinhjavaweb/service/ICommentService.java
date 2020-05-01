package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CommentDTO;

public interface ICommentService {
	void InsertComment(String username,String cmt,Long bookID);
	List<CommentDTO> findByBookId(Long bookID);
}

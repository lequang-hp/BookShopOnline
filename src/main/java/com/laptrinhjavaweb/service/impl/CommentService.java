package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICommentService;

@Service
public class CommentService implements ICommentService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ICommentDAO commentDAO;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void InsertComment(String username, String cmt, Long bookID) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		if(userEntity != null) {
			CommentEntity commentEntity = new CommentEntity();
			commentEntity.setUser(userEntity);
			commentEntity.setContent(cmt);
			commentEntity.setBookEntity(bookRepository.findOne(bookID));
			commentRepository.save(commentEntity);
		}
	}

	@Override
	public List<CommentDTO> findByBookId(Long bookID) {
		List<CommentDTO> model = commentDAO.findByBookId(bookID);
		for(CommentDTO item: model) {
			item.setUsername(userRepository.findOne(item.getUser_id()).getUserName());
		}
		return model;
	}
}

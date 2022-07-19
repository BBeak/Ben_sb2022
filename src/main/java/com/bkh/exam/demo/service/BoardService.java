package com.bkh.exam.demo.service;

import org.springframework.stereotype.Service;

import com.bkh.exam.demo.repository.BoardRepository;
import com.bkh.exam.demo.vo.Board;

@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}
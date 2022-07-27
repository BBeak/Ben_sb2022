package com.bkh.exam.demo.service;

import org.springframework.stereotype.Service;

import com.bkh.exam.demo.repository.ReactionPointRepository;

@Service
public class ReactionPointService {
	private ReactionPointRepository reactionPointRepository;
	
	public ReactionPointService(ReactionPointRepository reactionPointRepository) {
		this.reactionPointRepository = reactionPointRepository;
	}
	
	public boolean actorCanMakeReactionPoint(int actorId, String relTypeCode, int id) {
		if (actorId == 0) {
			return false;
		}
		
		return reactionPointRepository.actorCanMakeReactionPoint(id, relTypeCode, actorId) == 0;
	}
}

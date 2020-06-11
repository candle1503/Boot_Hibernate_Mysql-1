package com.iu.s1.board.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
@Transactional(rollbackOn = Exception.class)
public class QnaService {
	@Autowired
	private QnaRepository qnaRepository;
	
	public Page<QnaVO> boardList(Pager pager)throws Exception{
		pager.makeRow();
		Pageable pageable = PageRequest.of((int)pager.getStartRow(), pager.getPerPage(), Sort.by("ref").descending().and(Sort.by("step").ascending()));
		
		Page<QnaVO> page=null;
		if(pager.getKind().equals("title")) {
			page = qnaRepository.findByTitleContaining(pager.getSearch(), pageable);
		}else if(pager.getKind().equals("contents")) {
			page = qnaRepository.findByContentsContaining(pager.getSearch(), pageable);
		}else {
			page = qnaRepository.findByWriterContaining(pager.getSearch(), pageable);
		}
		
		return page;
	}
	
	public QnaVO boardWrite(QnaVO qnaVO)throws Exception{
		//원본글 
		//ref = 자기자신의 글번호
		//step, depth 0
		qnaVO.setRef(0L);
		qnaVO.setStep(0L);
		qnaVO.setDepth(0L);
		qnaVO=qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		return qnaRepository.save(qnaVO);
	}

}

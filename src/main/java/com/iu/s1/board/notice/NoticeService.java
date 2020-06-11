package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	public List<NoticeVO> boardList(Pager pager)throws Exception{
		pager.makeRow();
		pager.makePage(noticeRepository.count());
		Pageable pageable = PageRequest.of((int)pager.getStartRow(), pager.getPerPage(), Sort.Direction.DESC, "num");
		if(pager.getKind().equals("writer")) {
			
		}else if(pager.getKind().equals("contents")) {
			
		}else {
			
		}
		
		return noticeRepository.findByTitleContaining(pager.getSearch(), pageable); 
	}
}

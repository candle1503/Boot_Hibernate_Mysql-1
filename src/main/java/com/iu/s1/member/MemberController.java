package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iu.s1.util.FilePathGenerator;

@Controller
public class MemberController {
	@Autowired
	private FilePathGenerator file;
	
	@GetMapping("/test")
	public void test() throws Exception {
		file.getUserResourceLoader("test");
	
	}

}

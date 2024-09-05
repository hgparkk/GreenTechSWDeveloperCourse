package com.spring.study.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.common.util.MyUtils;
import com.spring.study.reply.dto.ReplyDTO;
import com.spring.study.reply.service.ReplyService;

//@RestController 데이터 내부 메소드가 전부 데이터 응답 방식으로 변경
@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;

	@ResponseBody //이 어노테이션이 달린 메소드는 데이터 응답 방식이 된다.
	@RequestMapping(value="/replyWriteDo", method=RequestMethod.POST)
	public ReplyDTO replyWriteDo(ReplyDTO reply) {
		
		String uniqueId = MyUtils.makeUniqueId();
		reply.setReplyNo(uniqueId);
		
		replyService.insertReply(reply);
		
		ReplyDTO result = replyService.getReply(uniqueId);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteReplyDo", method=RequestMethod.POST)
	public String deleteReplyDo(String replyNo) {
		replyService.deleteReply(replyNo);
		return "success";
	}
}
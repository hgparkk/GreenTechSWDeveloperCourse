package com.spring.study.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.common.util.MyUtils;
import com.spring.study.reply.dto.ReplyDTO;
import com.spring.study.reply.service.ReplyService;

//@RestController ������ ���� �޼ҵ尡 ���� ������ ���� ������� ����
@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;

	@ResponseBody //�� ������̼��� �޸� �޼ҵ�� ������ ���� ����� �ȴ�.
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
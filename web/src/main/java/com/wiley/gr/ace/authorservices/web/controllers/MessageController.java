package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/message")
public class MessageController {

	
	@RequestMapping(value = "/rec", method = RequestMethod.GET)
	public void recMessage() throws Exception{
//		MessageReciever m = new MessageReciever();
//		m.receiveMessage();
		
	}
	
}

package com.ai.faq.bot;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/openai")
public class OpenAiController {
	
	private OpenAiChatModel openAiChatModel;
	
	
	public OpenAiController(OpenAiChatModel openAiChatModel) {
		super();
		this.openAiChatModel = openAiChatModel;
	}


	@GetMapping("/{message}")
	public org.springframework.http.ResponseEntity<String> getAnswers(@PathVariable String message){
		String response = openAiChatModel.call(message);
		System.out.println(response);
		return ResponseEntity.ok(response);
	}

}

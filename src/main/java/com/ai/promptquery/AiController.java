package com.ai.promptquery;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController{
	
	private OllamaChatModel chatModel;
	
	
	public AiController(OllamaChatModel chatModel) {
		this.chatModel=chatModel;
	}
	
	@GetMapping("/prompt")
	public Flux<String> promptResponse(
			@RequestParam("prompt") String prompt) {
		 Flux<String> response = chatModel.stream(prompt);
		return response;
		
	}
	
	
	
	
}
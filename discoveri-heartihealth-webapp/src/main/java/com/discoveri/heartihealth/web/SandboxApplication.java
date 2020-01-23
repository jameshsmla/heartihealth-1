package com.discoveri.heartihealth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.SomeService;

@SpringBootApplication(scanBasePackages = "com.discoveri.heartihealth")
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@RestController
	static class SomeRestController {

		private SomeService someService;

		public SomeRestController(SomeService someService) {
			this.someService = someService;
		}

		@GetMapping("/")
		public String home() {
			return someService.doesItWork();
		}
	}
}

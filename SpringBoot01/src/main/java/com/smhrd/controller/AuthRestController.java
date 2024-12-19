package com.smhrd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthRestController {

	private final AuthService service;

	@GetMapping("/auth/check-email")
	public String check(String email) {

		String res = service.checkEmail(email);

		return res;

	}

}

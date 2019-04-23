package com.example.oauth.keycloaktest;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPages {

	@GetMapping(path = "/api/conteudoProtegido")
	public String getItens(Model model){
		model.addAttribute("itens", Arrays.asList("Item 1", "Item 2", "Item 3"));
		return "pages/conteudoProtegido";
	}

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/";
	}

}

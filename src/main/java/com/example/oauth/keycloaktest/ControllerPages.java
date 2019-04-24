package com.example.oauth.keycloaktest;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@GetMapping(path = "/login")
	public String login(HttpServletRequest request) throws ServletException {
		System.out.println("Teste");
		return "/";
	}

	@GetMapping(path = "/sair")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}

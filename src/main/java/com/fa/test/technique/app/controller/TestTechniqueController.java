package com.fa.test.technique.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fa.test.technique.app.domain.Panier;
import com.fa.test.technique.app.service.TestTechniqueService;

@Controller
public class TestTechniqueController {

	public static final Logger logger = LoggerFactory.getLogger(TestTechniqueController.class);

	@Autowired
	private TestTechniqueService testTechniqueService;

	@GetMapping("/index")
	public String home(ModelMap modal) {
		List<Panier> paniers = testTechniqueService.findAllPaniers();
		modal.addAttribute("paniers", paniers);
		return "index";
	}

}

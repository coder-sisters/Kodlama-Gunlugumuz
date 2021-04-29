package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping({"/", "/index"})
	public String hello(@RequestParam(value = "name" , defaultValue = "World",
	required = true) String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	@GetMapping({ "/category"})
	public String category(Model model) {
		return "category";
	}
	@GetMapping({ "/page-about"})
	public String pageAbout(Model model) {
		return "page-about";
	}
	@GetMapping({ "/page-contact"})
	public String pageContact(Model model) {
		return "page-contact";
	}
	@GetMapping({ "/single-audio"})
	public String singleAudio(Model model) {
		return "single-audio";
	}
	@GetMapping({ "/single-gallery"})
	public String singleGallery(Model model) {
		return "single-gallery";
	}
	@GetMapping({ "/single-standard"})
	public String singleStandard(Model model) {
		return "single-standard";
	}

	@GetMapping({ "single-video"})
	public String singleVideo(Model model) {
		return "single-video";
	}

	@GetMapping({ "styles"})
	public String styles(Model model) {
		return "styles";
	}
}

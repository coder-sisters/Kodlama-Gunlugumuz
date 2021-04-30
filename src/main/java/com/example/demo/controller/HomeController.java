package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Articles;
import com.example.demo.entity.Comments;
import com.example.demo.service.ArticleService;
import com.example.demo.service.CommentService;

@Controller
public class HomeController {

	@Autowired
	private CommentService commentService;
	private ArticleService articleService;

	@GetMapping({ "/", "/index" })
	public String index(@RequestParam(value = "name", defaultValue = "World", required = true) String name,
			Model model) {
		model.addAttribute("name", name);

		//model.addAttribute("articles", articleService.getAll());
		return "index";
	}

	@GetMapping({ "/category" })
	public String category(Model model) {
		return "category";
	}

	@GetMapping({ "/page-about" })
	public String pageAbout(Model model) {
		return "page-about";
	}

	@GetMapping({ "/page-contact" })
	public String pageContact(Model model) {
		return "page-contact";
	}

	@GetMapping({ "/single-audio" })
	public String singleAudio(Model model) {
		return "single-audio";
	}

	@GetMapping({ "/single-gallery" })
	public String singleGallery(Model model) {
		return "single-gallery";
	}

	@GetMapping({ "single-video" })
	public String singleVideo(Model model) {
		return "single-video";
	}

	@GetMapping({ "styles" })
	public String styles(Model model) {
		return "styles";
	}

	//-----------------------------      Single Standard      ---------------------------------
	
	@GetMapping({ "single-standard" })
	public String singleStandard(Model model) {
		return "single-standard";
	}

	@RequestMapping(value = "/single-standard", method = RequestMethod.POST)
	public ResponseEntity<String> addComment(@RequestBody Comments comments, HttpServletRequest request) {
		System.out.println(comments.toString());

		commentService.createComment(comments, request);

		return new ResponseEntity<>("Yorumunuz eklendi ! ", HttpStatus.CREATED);
	};

	//-----------------------------      Add Article      ---------------------------------
	
	@GetMapping({ "/addArticle" })
	public String addArticle(Model model) {
		model.addAttribute("articles", articleService.getArticles());
		return "/addArticle";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody Articles articles, HttpServletRequest request) {
		System.out.println(articles.toString());

		articleService.createArticle(articles, request);

		return new ResponseEntity<>("yazınız eklendi ! ", HttpStatus.CREATED);
	};

}

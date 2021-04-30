package com.example.deneme123.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.deneme123.entity.Note;
import com.example.deneme123.serviceBL.NoteService;

@Controller
public class HomeController {

	@Autowired
	private NoteService noteService;

	@GetMapping({ "/", "/index" })
	public String hello(@RequestParam(value = "name", defaultValue = "World", required = true) String name,
			Model model) {
		name = name == null || name.trim().equals("") ? "Thymeleaf" : name;
		model.addAttribute("name", name);
		
	//	model.addAttribute("notlar", noteService.getNoteById(1));
		
		
		
		return "index";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public String single(Model model) {

		return "single";
	}
	
	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String ekle(Model model) {

		return "addNote";
	}
	
	
	/*@PostMapping("/addNote")
	public 	Note addNote(@RequestBody Note note) {
		return noteService.createNote(note);
	}
	
	@PostMapping("/addNotes")
	public 	List<Note> addNotes(@RequestBody List<Note> notes) {
		return noteService.createNotes(notes);
	}
	
	@PutMapping("/update")
	public 	Note updateNote(@RequestBody Note note) {
		return noteService.update(note);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return noteService.delete(id);
	}
	*/
	
	@RequestMapping(value="/addNote", method = RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request){
		System.out.println(note.toString());
		noteService.createNote(note, request);
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
		
	}
	
}

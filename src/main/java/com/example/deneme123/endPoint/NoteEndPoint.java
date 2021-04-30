package com.example.deneme123.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.deneme123.serviceBL.NoteService;

@RestController
@RequestMapping(value = "/rest")
public class NoteEndPoint {
	
	@Autowired
	private NoteService noteService;

}

package com.example.deneme123.serviceBL;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.deneme123.entity.Note;
import com.example.deneme123.repository.INoteRepository;

@Service
@Transactional
public class NoteService {


	@Autowired
	private INoteRepository noteRepository; //interface.teki fonksiyonları çekiyoruz.

	//CRUD
	
	public Note createNote(Note note, HttpServletRequest request) {
		note.setUser_id(1);
		return noteRepository.save(note);
	}
	
	public String delete(int id) {
		noteRepository.deleteById(id);
		return "note id " + id;
	}
	
	public Note update(Note note) {
		Note deletedNote = noteRepository.findById(note.getId()).orElse(null);
		deletedNote.setUser_id(note.getUser_id());
		deletedNote.setTitle(note.getTitle());
		deletedNote.setContent(note.getContent());
		deletedNote.setCreate_date(null);
		return noteRepository.save(deletedNote);
	}
	
	
	//Read
	
	public Note getNoteById(int user_id) {
		return noteRepository.findById(user_id).orElse(null);
	}
	
	public Note getAll() {
		return (Note) noteRepository.findAll();
		
	}
	
	
}

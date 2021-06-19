package com.mucahit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mucahit.dao.NoteDAO;
import com.mucahit.entity.Note;
import com.mucahit.security.LoginFilter;

//Business Layer

@Service
@Transactional
public class NoteService {

	@Autowired
	private NoteDAO noteDAO;

	public Long createNote(Note note, HttpServletRequest request) {
		// TODO:user_.id degisecek
		note.setUser_id(LoginFilter.user.getId());
		return noteDAO.insert(note);
	}

	public Long updateNote(Note note, HttpServletRequest request) {

		noteDAO.update(note);

		return 1l;
	}

	public Long deleteNote(Note note, HttpServletRequest request) {

		noteDAO.delete(note);

		return 1l;
	}

	public Note getNotefindById(Long id) {

		return noteDAO.getfindById(id);
	}

	public ArrayList<Note> getAll() {

		return noteDAO.getAll();
	}

	public ArrayList<Note> getAll(Long user_id) {

		return noteDAO.getAll(user_id);
	}

}

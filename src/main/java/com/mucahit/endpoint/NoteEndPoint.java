package com.mucahit.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mucahit.service.NoteService;

@RestController
@RequestMapping
public class NoteEndPoint {

	@SuppressWarnings("unused")
	@Autowired
	private NoteService noteService;
}

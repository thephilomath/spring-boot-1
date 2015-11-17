package com.philomath.samples.library.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philomath.samples.library.business.LibraryBusiness;
import com.philomath.samples.library.exception.LibraryException;


@RestController
public class LibraryController {

	@Autowired
	private LibraryBusiness librarybusiness;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addBook(@RequestBody Map<String, Object> input) throws LibraryException	{
		
		int bookId = librarybusiness.addBook(input);
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("status", "success");
		retMap.put("id", bookId);
		
		
		ResponseEntity<Map<String, Object>> retValue = new ResponseEntity<Map<String,Object>>(retMap, HttpStatus.OK);
		return retValue;
	}
}

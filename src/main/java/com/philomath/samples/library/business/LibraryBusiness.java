package com.philomath.samples.library.business;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.philomath.samples.library.exception.LibraryException;

@Component
public class LibraryBusiness {

	public int addBook(Map<String, Object> book)	throws LibraryException	{
		return 1;
	}
}

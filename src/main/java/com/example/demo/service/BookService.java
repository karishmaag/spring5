package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {
      
	@Autowired
	BookRepo bb;
	public Book saveinfo(Book b)
	{
		return bb.save(b);
	}
	public List<Book>showinfo()
	{
		return bb.findAll();
	}
	public Optional<Book>showbyid(int id)
	{
		return bb.findById(id);
	}
	public String changeinfobyid(int id,Book b)
	{
		bb.saveAndFlush(b);
		if(bb.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid Id";
		}

	}
	public void deletebyid(int id)
	{
		bb.deleteById(id);
	}
}

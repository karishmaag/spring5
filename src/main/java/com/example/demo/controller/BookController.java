package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;


@RestController
public class BookController {
	@Autowired
	 BookService s;
	@PostMapping("save")
	public Book add(@RequestBody  Book  b)
    {
 	   return s.saveinfo(b);
    }
	@GetMapping("showuser")
    public List< Book >show()
    {
 	   return s.showinfo();
    }
	@GetMapping("getuser/{id}")
    public Optional< Book>getinfo(@PathVariable int id)
    {
 	   return s.showbyid(id);
    }
	@PutMapping("updateuser/{id}")
    public String modifybyid(@PathVariable int id,@RequestBody  Book b)
	{
		return s.changeinfobyid(id,b);
	}
    public  void deletemyid(@PathVariable int id)
    {
   	  s.deletebyid(id);
    }
}

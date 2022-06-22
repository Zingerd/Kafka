package com.example.consumer.controller

import com.example.consumer.entity.Book
import com.example.consumer.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    lateinit var bookService:BookService

    @GetMapping("/{id}")
    fun book(@PathVariable id:Int) : ResponseEntity<Book> {
     return ResponseEntity(bookService.getById(id),HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addBook(@RequestBody book: Book):ResponseEntity<Book> {
        bookService.addBook(book)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/all")
    fun allBooks():ResponseEntity<MutableList<Book?>> {
        return ResponseEntity(bookService.getAllBook(),HttpStatus.OK)
    }

}
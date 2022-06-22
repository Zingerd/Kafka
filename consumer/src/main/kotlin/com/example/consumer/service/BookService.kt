package com.example.consumer.service

import com.example.consumer.entity.Book
import com.example.consumer.repo.BookRepo
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
@AllArgsConstructor
class BookService(var bookRepo: BookRepo) {

    fun getById(id: Int): Book {
        return bookRepo.findById(id).get()
    }

    fun addBook(book: Book) {
        val b = Book(book.id,book.name)
        bookRepo.save(b)
    }

    fun getAllBook(): MutableList<Book?> {
        return bookRepo.findAll();
    }
}
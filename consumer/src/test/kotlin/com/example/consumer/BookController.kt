package com.example.consumer

import com.example.consumer.entity.Book
import com.example.consumer.repo.BookRepo
import com.example.consumer.service.BookService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.runner.Request
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.Objects


@WebMvcTest
class BookController(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var bookService: BookService

    @Autowired lateinit var mapper: ObjectMapper

    private val book = Book(1,"d")


    @Test
    fun bookTest() {
        every { bookService.getById(1) } returns book
        mockMvc.perform(get("/books/{id}",1))
                .andExpect(status().isOk)
    }

    @Test
    fun allBooksTest() {
        every { bookService.getAllBook() } returns mutableListOf(book)

        mockMvc.perform(get("/books/all"))
                .andExpect(status().isOk)
    }


}



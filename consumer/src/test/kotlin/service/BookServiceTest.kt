package service

import com.example.consumer.entity.Book
import com.example.consumer.repo.BookRepo
import com.example.consumer.service.BookService
import org.junit.Test

import org.mockito.Mockito

import java.util.*


class BookServiceTest {

    @Test
    fun getByIdTest() {
        val mockito = Mockito.mock(BookRepo::class.java)
        Mockito.`when`(mockito.findById(1)).thenReturn(Optional.of(Book(1,"d")))

        val book = BookService(mockito)

        book.getById(1)
        Mockito.verify(mockito).findById(1)

    }

    @Test
    fun addBookTest() {
        val mockito = Mockito.mock(BookRepo::class.java)
        val book = BookService(mockito)
        book.addBook(Book(1,"d"))
    }

    @Test
    fun getAllBookTest() {
        val mockito = Mockito.mock(BookRepo::class.java)
        val book = BookService(mockito)

        Mockito.`when`(mockito.findAll()).thenReturn(mutableListOf(Book(1,"NAME")))

        book.getAllBook()

        Mockito.verify(mockito).findAll();

    }
}




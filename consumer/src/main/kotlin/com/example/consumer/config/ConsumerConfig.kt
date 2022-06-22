package com.example.consumer.config

import com.example.consumer.entity.Book
import com.example.consumer.repo.BookRepo
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class ConsumerConfig() {
    @Autowired
    lateinit var book:BookRepo

    @Bean
    fun topic() = NewTopic("test",10,1)

    @KafkaListener(id = "1", topics = ["test"])
    fun listen(value: String?) {
        val books = Book(1 ,value);
        book.save(books)
    }
}
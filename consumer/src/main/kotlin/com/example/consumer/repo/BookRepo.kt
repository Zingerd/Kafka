package com.example.consumer.repo

import com.example.consumer.entity.Book
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface BookRepo :  CassandraRepository<Book,Int> {}

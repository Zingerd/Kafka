package com.example.consumer.entity

import org.jnosql.artemis.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table("books")
class Book(@PrimaryKey var id: Int?, @Column var name: String?) {

    override fun toString(): String {
        return "Book(id=$id, name=$name)"
    }

}
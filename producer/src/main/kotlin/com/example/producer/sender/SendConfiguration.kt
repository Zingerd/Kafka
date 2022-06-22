package com.example.producer.sender

import com.github.javafaker.Faker
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.lang.Thread.sleep


@Configuration
class SendConfiguration {


    @Bean
    fun topic() = NewTopic("test",10,1)

    @Bean
    fun sender(template: KafkaTemplate<String?,String?>) = ApplicationRunner {
        Flux.generate { synchronousSink: SynchronousSink<String> ->
            val author = Faker().book().author();
            synchronousSink.next(author)
            template.send("test","1",author)
        }.subscribe {
            a -> sleep(1000)
            println(a)
        }
    }
}
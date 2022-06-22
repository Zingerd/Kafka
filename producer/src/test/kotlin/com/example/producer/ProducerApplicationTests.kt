package com.example.producer

import com.example.producer.sender.SendConfiguration
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.MockProducer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
class ProducerApplicationTests {
	@Autowired
	lateinit var userSender: SendConfiguration


	@Test
	fun sender() {

	}

}

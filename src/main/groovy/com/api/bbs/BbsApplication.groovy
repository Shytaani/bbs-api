package com.api.bbs

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource

@SpringBootApplication
class BbsApplication {

	static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args)
	}

	@Bean
	MessageSource validationMessageSource() {
		new ResourceBundleMessageSource(
				basename: "ValidationMessages",
				defaultEncoding: "UTF-8")
	}
}

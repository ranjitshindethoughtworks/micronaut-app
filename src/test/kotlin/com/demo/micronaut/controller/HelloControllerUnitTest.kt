package com.demo.micronaut.controller

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.inject.Inject


@MicronautTest
class HelloControllerUnitTest{

    @field:Client("/")
    @Inject
    private lateinit var client: HttpClient

    @Test
    fun `should greet user`() {

        val response = client
            .toBlocking()
            .exchange(
                HttpRequest.GET<String>("/hello/Ranjit"),
                Argument.of(String::class.java)
        )

        assertThat(response.status).isEqualTo(HttpStatus.OK)
        assertThat(response.body()).isEqualTo("Hello Ranjit !")
    }
}

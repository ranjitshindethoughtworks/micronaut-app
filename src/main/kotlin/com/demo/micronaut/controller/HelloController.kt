package com.demo.micronaut.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController {

    @Get("/hello/{name}")
    fun hello(name:String): MutableHttpResponse<String> {
        return HttpResponse.ok("Hello $name !")
    }
}

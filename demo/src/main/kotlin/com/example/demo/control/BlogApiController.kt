package com.example.demo.control

import com.example.demo.domain.Article
import com.example.demo.dto.AddArticleRequest
import com.example.demo.services.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/*
val, var

val: 초기에 값을 할당되면 나중에 값을 변경할 수 없음
   초기화시 값을 할당하지 않을 때는 반드시 타입을 지정해야 함
   var name: String
   name = "Kotlin"
var: 변경가능

lateinit
 */
@RestController
class BlogApiController{

    @Autowired
    lateinit var blogService: BlogService


    @PostMapping("/api/articles")
    fun addArticle(@RequestBody request: AddArticleRequest): ResponseEntity<Article?>? {
        val savedArticle = blogService.save(request)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedArticle)
    }
}
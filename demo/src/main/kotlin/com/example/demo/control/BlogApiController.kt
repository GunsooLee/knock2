package com.example.demo.control

import com.example.demo.domain.Article
import com.example.demo.dto.AddArticleRequest
import com.example.demo.dto.ArticleResponse
import com.example.demo.services.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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
        println("this is postmapping articles");
        val savedArticle = blogService.save(request)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedArticle)
    }

    @GetMapping("/api/articles")
    fun findAllArticles(): ResponseEntity<List<ArticleResponse>>{
        println("this is getmapping articles");
        val articles = blogService.findAll().map { x -> ArticleResponse(x) }.toList()
        //val articles = blogService.findAll().map { x: Article? -> ArticleResponse(x!!) }.toList()
        // 물음표(?): null 이 들어올 수 있는 경우 붙여준다
        // 느낌표 2개(!!): null 이 절대 들어오면 안되는 곳?

        println(articles.size)


        val responseEntity = ResponseEntity.ok().body(articles)

        println(responseEntity.body?.get(0)?.toString())

        return responseEntity
    }


}
package com.example.demo.control

import com.example.demo.domain.Article
import com.example.demo.dto.AddArticleRequest
import com.example.demo.dto.ArticleResponse
import com.example.demo.dto.UpdateArticleRequest
import com.example.demo.services.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

/*
DTO(VO)
 : 데이터 저장 담당 클래스
   Controller, Service, Repository 계층 간의 데이터 교환을 위해 쓰인다.
   순수 데이터 객체이며 getter, setter만 갖는다

Domain(=entity)
실제 DB의 테이블과 매칭시키는 클래스


 domain 과 dto 의 차이?
 domain 은 db layer 를 위한, dto는 view layer 를 위한 것

*/

/*
DAO(repository)
 : 실제로 DB 에 접근하여 데이터를 CRUD 하는 객체
 */


/*
Controller
 - 해당 요청 url 에 따라 적절한 view와 mapping 처리

Controller 와 RestController
Controller: API와 view를 동시에 사용하는 경우. View return 이 주 목적
RestController: view가 필요없는 API만 지원하는 서비스에서 사용


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

    @GetMapping("/api/articles")
    fun findAllArticles(): ResponseEntity<List<ArticleResponse>>{
        val articles = blogService.findAll().map { x -> ArticleResponse(x) }
        // 물음표(?): null 이 들어올 수 있는 경우 붙여준다
        // 느낌표 2개(!!): null 이 절대 들어오면 안되는 곳?

        return ResponseEntity.ok().body(articles)
    }

    @DeleteMapping("/api/articles/{id}")
    fun deleteArticles(@PathVariable id: Long): ResponseEntity<Void>{
        blogService.delete(id)

        return ResponseEntity.ok().build()
    }

    @PutMapping("/api/articles/{id}")
    fun updateArticle(@PathVariable id: Long, @RequestBody request: UpdateArticleRequest): ResponseEntity<Article>{
        val updatedArticle = blogService.update(id, request)

        return ResponseEntity.ok().body(updatedArticle)
    }
}
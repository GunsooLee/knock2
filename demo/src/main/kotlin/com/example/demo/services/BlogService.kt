package com.example.demo.services;


import com.example.demo.domain.Article
import com.example.demo.dto.AddArticleRequest
import com.example.demo.dto.UpdateArticleRequest
import com.example.demo.repository.BlogRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class BlogService {
    @Autowired
    lateinit var blogRepository: BlogRepository

    fun save(request: AddArticleRequest) = blogRepository.save(request.toEntity())

    fun findAll(): MutableList<Article> = blogRepository.findAll()

    fun delete(id: Long){
        blogRepository.deleteById(id)
    }

    // @Transactional : 매칭된 메서드를 하나의 트랜잭션으로 묶는 역할
    // 작업을 묶어서 한 단위로 실행하고 오류 발생시 rollback
    @Transactional
    fun update(id: Long, request: UpdateArticleRequest): Article {
        /*
        null처리
        java 코드
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

                orElseThrow 로 null 일 경우 예외 처리


        Kotlin 에서는 nullable 을 처리할 때
        ?:(엘비스 연산자) null 일 경우 뒷부분 수행 (throw exception)

        findByIdOrNull: 조회된 값 or Null, Null 아닐 경우 에만 Article 리턴
         */
        val article = blogRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("not found: $id")

        article.update(request.title, request.content)

        return article
    }

}

package com.example.demo.control


/*
메서드 임포트
자바에서는 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
이렇게 했었는데 kotlin에서는 그냥 import만으로도 가능
 */

import com.example.demo.DemoApplication
import com.example.demo.domain.Article
import com.example.demo.dto.AddArticleRequest
import com.example.demo.dto.UpdateArticleRequest
import com.example.demo.repository.BlogRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

// intellij 에서 jUnit 테스트 리포트 한글 깨질 때
// shift 두 번 > edit vm 검색(사용자 지졍 vm 옵션?) >   -Dfile.encoding=UTF-8 추가

@SpringBootTest(classes = [DemoApplication::class]) // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    /*
    HTTP에서는 JSON을, kotlin에서는 객체를 사용.
    서로 형식을 맞게 변환하는 작업이 필요
    Object <-> JSON
    직렬화: Object -> JSON
    병렬화: JSON -> Object
     */
    @Autowired
    lateinit var objectMapper: ObjectMapper // 직렬화, 역직렬화를 위한 클래스

    @Autowired
    lateinit var context: WebApplicationContext

    @Autowired
    lateinit var blogRepository: BlogRepository

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    fun mockMvcSetUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .build()
        blogRepository.deleteAll()
        println("setup Test")
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    fun addArticle() {
        println("addArticle")

        // ---given--- (테스트 준비)
        val url = "/api/articles"
        val title = "title22"
        val content = "content22"
        val userRequest = AddArticleRequest(title, content)
        //final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        //객체 JSON으로 직렬화
        val requestBody = objectMapper.writeValueAsString(userRequest)


        // ---when--- (테스트를 실제로 진행)
        // 설정한 내용을 바탕으로 요청 전송
        val result = mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        )

        // ---then--- (테스트 결과 검증)
        result.andExpect(status().isCreated)

        val articles = blogRepository.findAll()
        //List<Article> articles = blogRepository.findAll();

        //AssertJ: Junit과 함께 사용해 검증문의 가독성을 높여주는 라이브러리
        assertThat(articles.size).isEqualTo(1)// 크기가 1인지 검증
        assertThat(articles[0].title).isEqualTo(title)
        assertThat(articles[0].content).isEqualTo(content)

        println(articles[0].title)
    }

    @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다.")
    @Test
    fun findAllArticles(){

        // ---given--- (테스트 준비)
        val url = "/api/articles"
        val title = "title123"
        val content = "content456"

        blogRepository.save(Article(title,content))
        blogRepository.save(Article(title,content))
        blogRepository.save(Article(title,content))

        // ---when--- (테스트를 실제로 진행)
        // 설정한 내용을 바탕으로 요청 전송
        // MockMvc를 활용해 Controller에 대한 슬라이스 테스트를 작성
        val resultActions = mockMvc.perform(
            get(url)
                .contentType(MediaType.APPLICATION_JSON)
        )

        println(resultActions
            .andReturn().response.contentAsString
        )

        resultActions
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].article.content").value(content))
            .andExpect(jsonPath("$[0].article.title").value(title))
    }

    @DisplayName("deleteArticle: 블로그 글 삭제에 성공한다.")
    @Test
    fun deleteArticle(){
        // given
        val url = "/api/articles/{id}"
        val title = "title"
        val content = "content"

        val savedArticle = blogRepository.save(Article(title,content))

        // when
        mockMvc.perform(
            delete(url, savedArticle.id)
        ).andExpect(status().isOk())


        // then
        val articles = blogRepository.findAll()

        assertThat(articles).isEmpty()
    }

    @DisplayName("updateArticle: 블로그 글 수정에 성공한다.")
    @Test
    fun updateArticle(){
        // given
        val url = "/api/articles/{id}"
        val title = "title"
        val content = "content"

        val savedArticle = blogRepository.save(Article(title, content))

        val newTitle = "new title"
        val newContent = "new content"

        val request = UpdateArticleRequest(newTitle, newContent)

        //when
        val result = mockMvc.perform(
            put(url, savedArticle.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)) // update(put) 전달 값
        )

        //then
        result.andExpect(status().isOk)

        val article = blogRepository.findById(savedArticle.id).get()

        assertThat(article.title).isEqualTo(newTitle)
        assertThat(article.content).isEqualTo(newContent)
    }
}
    /*
    Execution failed for task ':test'.
> There were failing tests. See the report at: file:///C:/knockknock/demo/build/reports/tests/test/index.html

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.


에러 발생


     */
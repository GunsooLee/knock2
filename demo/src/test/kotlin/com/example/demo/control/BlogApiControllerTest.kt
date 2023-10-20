package com.example.demo.control

import com.example.demo.dto.AddArticleRequest
import com.example.demo.repository.BlogRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext




/*
메서드 임포트
자바에서는 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
이렇게 했었는데 kotlin에서는 그냥 import만으로도 가능
 */
import org.assertj.core.api.Assertions.assertThat
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    /*
    HTTP에서는 JSON을, kotlin에서는 객체를 사용.
    서로 형식을 맞게 변환하는 작업이 필요
    Object <-> JSON
    직렬화: Object -> JSON
    병렬화: JSON -> Objectr
     */
    @Autowired
    lateinit var objectMapper: ObjectMapper // 직렬화, 역질렬화를 위한 클래스

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
    fun addArticle(aa: String) {
        println("addArticle")

        // ---given--- (테스트 준비)
        val url = "/api/articles"
        val title = "title"
        val content = "content"
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
        assertThat(articles.size).isEqualTo(1);// 크기가 1인지 검증
        assertThat(articles.get(0).title).isEqualTo(title)
        assertThat(articles.get(0).content).isEqualTo(content)
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    @Throws(Exception::class)
    fun addArticle() {
        // given
        val url = "/api/articles"
        val title = "title"
        val content = "content"
        val userRequest = AddArticleRequest(title, content)
        val requestBody = objectMapper.writeValueAsString(userRequest)

        // when
        val result = mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        )

        // then
        result.andExpect(status().isCreated())
        val articles = blogRepository.findAll()
        assertThat(articles.size).isEqualTo(1)
        assertThat(articles[0].title).isEqualTo(title)
        assertThat(articles[0].content).isEqualTo(content)
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
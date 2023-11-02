package com.example.demo.dto

import com.example.demo.domain.Article

data class AddArticleRequest(
    val title: String,
    val content: String
) {
    fun toEntity(): Article {
        return Article(title, content)
    }
}
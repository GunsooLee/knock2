package com.example.demo.dto

import com.example.demo.domain.Article


data class ArticleResponse(val article: Article) {
    private val title: String = article.title
    private val content: String = article.content
}
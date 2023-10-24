package com.example.demo.dto

import com.example.demo.domain.Article


class ArticleResponse(article: Article) {
    private val title: String
    private val content: String
    init {
        title = article.title
        content = article.content
    }

    override fun toString(): String {
        return "article: ${title}, ${content}"
    }
}
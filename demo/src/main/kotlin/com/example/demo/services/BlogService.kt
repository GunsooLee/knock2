package com.example.demo.services;


import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BlogService {
    @Autowired
    lateinit var blogRepository: BlogRepository

    //fun save
}

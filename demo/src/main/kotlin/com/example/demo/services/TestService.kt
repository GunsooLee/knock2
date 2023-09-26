package com.example.demo.services

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun getAllMembers(): List<Member> {
        return memberRepository.findAll();
    }
}
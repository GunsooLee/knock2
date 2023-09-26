package com.example.demo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
data class Member(
    @Id @GeneratedValue
    @Column(name = "id", updatable = false)
    val id: Int,

    @Column(name = "name", nullable = false)
    var name: String
)

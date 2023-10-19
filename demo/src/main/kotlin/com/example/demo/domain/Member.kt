package com.example.demo.domain

import jakarta.persistence.*


/*
자주 쓰는 lombok 어노테이션
 @NoArgsConstructor: 파라미터가 없는 기본 생성자를 생성
 @AllArgsConstructor: 모든 필드 값을 파라미터로 받는 생성자를 생성
 @Getter: 자동으로  get 메소드 생성
 
 lombok 사용하지 않기로 (kotlin 에선 잘 사용하지 않는듯하다)
 */
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//@Getter
@Entity
class Member(
    @Column(name = "name", nullable = false)
    var name: String
)
{
    /*
    *
    * 어노테이션 정의
    * @Id: PK(기본키)를 나타냄
    * @GeneratedValue: 생성 전략을 나타냄. 기본키 생성을 DB가 자동으로 auto_increment 한다
    * 아래처럼 생성 전략을 지정해줄 수도 있다.
    * @GeneratedValue(strategy = GenerationType.IDENTITY)
    *   - AUTO_INCREMENT 하여 기본키를 생성
    * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_PK_GENERATOR")
    *   - Sequence Object 를 사용하여 데이터베이스가 자동으로 기본키를 생성
    *   - @SequenceGenerator 어노테이션이 필요
    * */
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    val id: Int = 0
}

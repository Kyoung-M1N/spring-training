package com.spring_training.domain.member.repository;

import java.util.List;
import java.util.Optional;

import com.spring_training.domain.member.Member;

import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository {
    // jpa는 EntityManager를 통해 entity를 관리한다.
    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Member> findAll() {
        /*
         * SQL은 데이터베이스 테이블을 대상으로 쿼리를 날리지만 JPQL은 엔티티 객체를 대상으로 쿼리를 날린다.
         * JPQL로 작성하면 결국은 SQL로 변환되어 데이터베이스에 쿼리를 날리게 된다.
         * 따라서 일반적인 sql과 다르게 테이블 이름이 아닌 엔티티를 대상으로 쿼리문을 작성해야한다.
         * Member, m.age와 같이 엔티티와 속성은 대소문자를 구분하여 작성하며, Member (as) m과 같이 
         * 별칭 설정을 필수로 해 주어야 한다.(별칭을 정의하는 예약어인 as는 생략 가능)
         * createQuery()를 통해 실행할 쿼리문을 입력
         * (primary key가 아닌 값으로 조회를 할 경우 중복된 값이 존재할 수 있으므로 getResultList()를 통해 List로 반환)
         */
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Optional<Member> findById(long id) {
        // jpa에 mapping된 entity와 primary key를 이용하여 select기능을 실행
        // (primary key에 해당하는 특정 row를 entity에 반환)
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = entityManager
                .createQuery("select m from Member m where m.name = :name", Member.class)
                // setParameter()가 :name으로 적혀있는 값에 parameter를 전달
                .setParameter("name", name)
                .getResultList();
         return result.stream().findAny();
    }

    @Override
    public Member save(Member member) {
        // insert기능을 실행
        entityManager.persist(member);
        return member;
    }

}

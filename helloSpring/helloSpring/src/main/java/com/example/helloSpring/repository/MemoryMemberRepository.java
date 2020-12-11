package com.example.helloSpring.repository;

import com.example.helloSpring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<Long, Member>();
    // 현재는 테스트라 그렇지만 실무에서는 frontEnd 개발자는 concurrentHashMap을 주로 사용.
    //동시에 많은 유저가 사용할 경우, concurrentHashMap이 내부적으로 데이터가 꼬이는 것을 막아줌.
    private static long squence = 0L; //이것도 long이 아니라 AtomicLong을 사용.


    @Override
    public Member save(Member member) {
        member.setId(++squence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().
                filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();//디버그용으로 여러 단위 테스트를 위해 사용. 메모리 클리어위해 사용.

    }

}

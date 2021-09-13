package mango.mangospring.repo;

import mango.mangospring.domain.Member;
import mango.mangospring.domain.MemberRepo;
import mango.mangospring.domain.MemoryMemberRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepoTest {
    MemoryMemberRepo repo = new MemoryMemberRepo();


    // 각 테스트를 진행할 때 마다 데이터가 저장되기 때문에 데이터를 비워야함.
    // 각 테스트마다 이 메소드가 실행됨.
    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repo.save(member);

        Member result = repo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        Member result = repo.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> members = repo.findAll();

        assertThat(members.size()).isEqualTo(2);
    }
}

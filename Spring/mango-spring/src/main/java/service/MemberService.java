package service;

import mango.mangospring.domain.Member;
import mango.mangospring.domain.MemberRepo;
import mango.mangospring.domain.MemoryMemberRepo;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // 인터페이스는 객체 생성이 안될텐데 이건 어떻게 되는거임?
    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member);

        memberRepo.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepo.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMember() {
        return memberRepo.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepo.findById(memberId);
    }
}

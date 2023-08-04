package jsp.servlet.service;

import jsp.servlet.dto.MemberDto;
import jsp.servlet.entity.Member;
import jsp.servlet.repository.MemberRepository;

public class MemberService {
    private final static MemberRepository memberRepository = new MemberRepository();
    public void join(MemberDto newMember){
        //DTO에서 Entity(DAO)로 옮겨 담기
        Member member = new Member(newMember.getEmail(),
                newMember.getPw(),
                newMember.getName());

        memberRepository.save(member);
    }

    public MemberDto login(String email, String pw){
        Member member= memberRepository.findByEmail(email);

        if (member.getPw().equals(pw)) {
            return new MemberDto(member.getId(),
                    member.getEmail(),
                    member.getPw(),
                    member.getName());
        } else {

        }
    }
}

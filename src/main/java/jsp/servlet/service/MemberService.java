package jsp.servlet.service;

import jsp.JoinException.EmailDuplicatedException;
import jsp.LoginException.EmailNotFoundException;
import jsp.LoginException.IllegalPasswordException;
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

        if(duplication(member.getEmail())){
            throw new EmailDuplicatedException();
        }
        memberRepository.save(member);
    }

    public MemberDto login(String email, String pw){

        if(!duplication(email)){
            throw new EmailNotFoundException();
        }
        Member member = memberRepository.findByEmail(email);
        if (member.getPw().equals(pw)) {
            return new MemberDto(member.getId(),
                    member.getEmail(),
                    member.getPw(),
                    member.getName());
        } else {
            throw new IllegalPasswordException();
        }
    }
    public boolean duplication(String email){
        return memberRepository.duplicatedEmail(email) == 1;
    }


    public void withdraw(int id){
        memberRepository.delete(id);
    }
}

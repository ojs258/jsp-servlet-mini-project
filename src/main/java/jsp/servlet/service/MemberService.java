package jsp.servlet.service;


import jsp.servlet.entity.Member;
import jsp.servlet.repository.MemberRepository;

public class MemberService {
        private final static MemberRepository memberRepository = new MemberRepository();
        public void saveForJoin(Member member){
                memberRepository.save(member);
        }
}

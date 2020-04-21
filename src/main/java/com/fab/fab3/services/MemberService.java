package com.fab.fab3.services;

import java.util.List;

import com.fab.fab3.models.Member;
import com.fab.fab3.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    
    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
    
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member, Long id) {
        Member updateMember = memberRepository.findById(id).orElse(null);
        if(updateMember != null) {
            updateMember.setFirstName(member.getFirstName());
            updateMember.setLastName(member.getLastName());
        }
        final Member mymember = memberRepository.save(updateMember);
        return mymember;
      }

      public Boolean deleteMember (Long id) {
        Member delMember  = memberRepository.findById(id).orElse(null);
        if(delMember != null) {
            memberRepository.delete(delMember);
            return true;
        }
        return false;
     }
}
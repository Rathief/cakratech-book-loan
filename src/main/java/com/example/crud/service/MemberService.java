package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Member;
import com.example.crud.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Create
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // Read all
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    
    // Read by ID
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    // Update
    public Member updateMember(Long id, Member updatedMember) {
        return memberRepository.findById(id)
                .map(member -> {
                    member.setName(updatedMember.getName());
                    member.setEmail(updatedMember.getEmail());
                    return memberRepository.save(member);
                })
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    // Delete
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

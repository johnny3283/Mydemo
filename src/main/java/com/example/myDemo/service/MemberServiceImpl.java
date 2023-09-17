package com.example.myDemo.service;

import com.example.myDemo.dao.MemberRepository;
import com.example.myDemo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {


    private MemberRepository memberRepository;

    @Autowired
    private MemberServiceImpl(MemberRepository theMemberRepository){memberRepository = theMemberRepository;}

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(int theId) {

        Optional<Member> result =memberRepository.findById(theId);

        Member theMember = null;

        if(result.isPresent()){
            theMember = result.get();
        }
        else {
            throw  new RuntimeException("did not find member id - " + theId);
        }
        return theMember;
    }

    @Override
    public void save(Member theMember) {
        memberRepository.save(theMember);
    }

    @Override
    public void deleteById(int theId) {
        memberRepository.deleteById(theId);
    }

    public Page<Member> getAllMembers(Pageable pageable){
        return memberRepository.findAll(pageable);
    }
}

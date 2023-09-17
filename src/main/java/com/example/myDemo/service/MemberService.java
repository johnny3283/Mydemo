package com.example.myDemo.service;

import com.example.myDemo.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(int theId);

    void save(Member theMember);

    void deleteById(int theId);


    Page<Member> getAllMembers(Pageable pageable);
}

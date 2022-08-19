package com.kahfy.springboot.thymeleaf.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.kahfy.springboot.thymeleaf.KahfyThymeleafApplication;
import com.kahfy.springboot.thymeleaf.dao.MemberRepository;
import com.kahfy.springboot.thymeleaf.entity.Member;

@Transactional
@Rollback
@SpringBootTest(classes = KahfyThymeleafApplication.class)
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	// checks to see if the repository is autowired
	@Test
	void testMemberRepositoryIsNotNull() {
		Assertions.assertNotNull(memberRepository);
	}

	// checks to see if you can find a member by Name
	@Test
	void findMemberByIdTest() {
		Member member = new Member();
		member.setMemberId(1);
		member.setName("Alex Brown");
		member.setEmail("alexbrown@gmail.com");
		member.setRewards(135);
		Member alex = memberRepository.findById(1).get();
		Assertions.assertEquals(alex.getMemberId(), member.getMemberId());
		Assertions.assertEquals(alex.getName(), member.getName());
		Assertions.assertEquals(alex.getEmail(), member.getEmail());
		Assertions.assertEquals(alex.getRewards(), member.getRewards());
	}

	// checks to see if you can list all members in ascending order of their id
	@Test
	void findAllByOrderByMemberIdAscTest() {
		List<Member> members = memberRepository.findAllByOrderByMemberIdAsc();
		boolean listedAsc = true;
		for (int i = 1; i < members.size(); i++) {
			Member currentMember = members.get(i);
			Member lastMember = members.get(i - 1);
			listedAsc = listedAsc && (currentMember.getMemberId() > lastMember.getMemberId());
		}
		Assertions.assertTrue(listedAsc);
	}

	// checks to see if you can save a member
	@Test
	void saveMemberTest() {
		Member member = new Member();
		member.setMemberId(1);
		member.setName("test");
		member.setEmail("testEmail");
		member.setRewards(123);
		memberRepository.save(member);
		Member newMember = memberRepository.findById(1).get();
		Assertions.assertEquals(newMember.getMemberId(), 1);
		Assertions.assertEquals(newMember.getName(), "test");
		Assertions.assertEquals(newMember.getEmail(), "testEmail");
		Assertions.assertEquals(newMember.getRewards(), 123);
	}

	// checks to see if you can delete a member
	@Test
	void deleteMemberByIdTest() {
		memberRepository.deleteById(1);
		Assertions.assertFalse(memberRepository.findById(1).isPresent());
	}

}

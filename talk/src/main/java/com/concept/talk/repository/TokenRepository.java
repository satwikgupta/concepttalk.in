package com.concept.talk.repository;

import com.concept.talk.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
	@Query("SELECT t FROM Token t WHERE t.user.Id = :Id AND (t.expired = false OR t.revoked = false)")
	List<Token> findAllValidTokensByUser(Long Id);
	Optional<Token> findByToken(String token);
}

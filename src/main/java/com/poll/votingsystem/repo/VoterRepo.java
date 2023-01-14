package com.poll.votingsystem.repo;

import com.poll.votingsystem.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepo extends JpaRepository<Voter,Integer> {
    public Voter findByRollno(String rollno);
}

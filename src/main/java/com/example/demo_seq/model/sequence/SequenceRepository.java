package com.example.demo_seq.model.sequence;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, String> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Sequence findByName(Sequence.Name name);
}

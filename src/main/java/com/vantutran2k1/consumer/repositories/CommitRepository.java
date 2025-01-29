package com.vantutran2k1.consumer.repositories;

import com.vantutran2k1.consumer.models.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommitRepository extends JpaRepository<Commit, UUID> {
}

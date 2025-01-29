package com.vantutran2k1.consumer.services;

import com.vantutran2k1.consumer.models.Commit;
import com.vantutran2k1.consumer.payloads.CommitEvent;
import com.vantutran2k1.consumer.repositories.CommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommitConsumer {
    private final CommitRepository commitRepository;

    @KafkaListener(
            topics = "github_commits",
            containerFactory = "userRegistrationListenerContainerFactory"
    )
    public void listen(CommitEvent event) {
        var commit = Commit.builder()
                .id(UUID.randomUUID())
                .sha(event.getSha())
                .committer(event.getCommitData().getCommitter().getEmail())
                .message(event.getCommitData().getMessage())
                .committedAt(event.getCommitData().getCommitter().getDate())
                .collectedAt(event.getCollectedAt())
                .build();
        commitRepository.save(commit);
    }
}

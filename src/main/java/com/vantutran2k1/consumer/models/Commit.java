package com.vantutran2k1.consumer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commit_events")
public class Commit {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "sha")
    private String sha;

    @Column(name = "committer")
    private String committer;

    @Column(name = "message")
    private String message;

    @Column(name = "committed_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime committedAt;

    @Column(name = "collected_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime collectedAt;
}

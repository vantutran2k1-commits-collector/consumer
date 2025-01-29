package com.vantutran2k1.consumer.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommitEvent {
    @JsonProperty(value = "sha")
    private String sha;

    @JsonProperty(value = "node_id")
    private String nodeId;

    @JsonProperty(value = "commit")
    private CommitData commitData;

    @JsonProperty(value = "collected_at")
    private LocalDateTime collectedAt;
}

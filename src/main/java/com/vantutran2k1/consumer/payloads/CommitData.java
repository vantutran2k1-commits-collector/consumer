package com.vantutran2k1.consumer.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommitData {
    @JsonProperty(value = "author")
    private User author;

    @JsonProperty(value = "committer")
    private User committer;

    @JsonProperty(value = "message")
    private String message;
}

package com.example.ChatGPTDemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prompt_tokens",
        "completion_tokens",
        "total_tokens"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usage {

    @JsonProperty("prompt_tokens")
    public Integer promptTokens;
    @JsonProperty("completion_tokens")
    public Integer completionTokens;
    @JsonProperty("total_tokens")
    public Integer totalTokens;

}
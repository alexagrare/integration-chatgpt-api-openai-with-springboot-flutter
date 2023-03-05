package com.openai.chatgpt.domain.model;

import lombok.Data;

@Data
public class TextGenerate {

    private String text;
    private Double temperature = 0.0;

}

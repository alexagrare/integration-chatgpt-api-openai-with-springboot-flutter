package com.openai.chatgpt.domain.model;

import lombok.Data;

@Data
public class ImageGenerate {

    private String text;
    private Integer number = 1;

    // 256x256, 512x512, 1024x1024
    private String size = "1024x1024";

}

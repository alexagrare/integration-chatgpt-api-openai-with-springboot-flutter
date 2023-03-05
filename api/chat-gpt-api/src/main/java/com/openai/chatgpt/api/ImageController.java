package com.openai.chatgpt.api;

import com.openai.chatgpt.domain.model.ImageGenerate;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Value("${openai.token}")
    private String TOKEN_OPEN_AI;

    @PostMapping
    public ResponseEntity<?> generate(@RequestBody ImageGenerate imageGenerate){
        try {
            OpenAiService service = new OpenAiService(TOKEN_OPEN_AI);

            ImageResult imageResult = service.createImage(
                    new CreateImageRequest().builder()
                            .prompt(imageGenerate.getText())
                            .n(imageGenerate.getNumber())
                            .size(imageGenerate.getSize())
                            .build()
            );

            return ResponseEntity.ok(imageResult.getData());
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

}

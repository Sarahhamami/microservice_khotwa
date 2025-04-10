package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.repositories.CoursRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tn.esprit.khotwaback.services.CoursService;
import tn.esprit.khotwaback.services.ICoursService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatRestController {
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final ICoursService courseService;
    private final RestTemplate restTemplate;

    public ChatRestController(CoursService courseService, RestTemplate restTemplate) {
        this.courseService = courseService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public Map<String, Object> chat(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");
        String responseMessage;

        // Check if the message matches a course
        Cours course = courseService.getCourseByTitle(userMessage);
        if (course != null) {
            responseMessage = "Course: " + course.getTitre() + "\nDescription: " + course.getDescription();
        } else {
            responseMessage = askGeminiAI(userMessage);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", responseMessage);
        return response;
    }

    private String askGeminiAI(String userMessage) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + geminiApiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> content = new HashMap<>();
        content.put("text", userMessage);
        requestBody.put("contents", new Object[]{Map.of("parts", new Object[]{content})});

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        if (response.getBody() != null) {
            try {
                // Extract the "text" field from the nested response
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");
                if (candidates != null && !candidates.isEmpty()) {
                    Map<String, Object> contentMap = (Map<String, Object>) candidates.get(0).get("content");
                    if (contentMap != null) {
                        List<Map<String, Object>> parts = (List<Map<String, Object>>) contentMap.get("parts");
                        if (parts != null && !parts.isEmpty()) {
                            return (String) parts.get(0).get("text"); // Return only the text content
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Sorry, I couldn't process your request.";
    }

}
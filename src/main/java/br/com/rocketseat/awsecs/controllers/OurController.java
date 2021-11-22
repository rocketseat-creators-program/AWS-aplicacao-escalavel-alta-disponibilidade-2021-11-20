package br.com.rocketseat.awsecs.controllers;

import br.com.rocketseat.awsecs.model.ECSMetadataResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class OurController {

  Logger logger = LoggerFactory.getLogger(OurController.class);

  private final HttpClient httpClient = HttpClient
    .newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .build();

  @GetMapping("/oi")
  public ResponseEntity getHelloWorld()
    throws IOException, InterruptedException {

    logger.info("Recebemos uma requsição");

    String ECS_METADATA = System.getenv("ECS_CONTAINER_METADATA_URI_V4");

    System.out.println(ECS_METADATA);
    HttpRequest request = HttpRequest
      .newBuilder()
      .GET()
      .uri(URI.create(ECS_METADATA + "/task"))
      .setHeader("User-Agent", "Java 11 HttpClient Bot")
      .build();

    HttpResponse<String> response = httpClient.send(
      request,
      HttpResponse.BodyHandlers.ofString()
    );

    ObjectMapper objectMapper = new ObjectMapper();


    ECSMetadataResponseDTO ecs_metadata_response = objectMapper.readValue(
      response.body(),
      ECSMetadataResponseDTO.class
    );

    return ResponseEntity.ok(ecs_metadata_response);
  }
}

package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class ReadingApplication {

  @Autowired
  private BookService bookService;

  AtomicInteger atomicInteger = new AtomicInteger(0);
  AtomicInteger atomicInteger2 = new AtomicInteger(0);

  @Bean
  public RestTemplate rest(RestTemplateBuilder builder) {
    return builder
//            .setReadTimeout(Duration.ofSeconds(1))
//            .setConnectTimeout(Duration.ofSeconds(1))
            .build();
  }

  @RequestMapping("/to-read")
  public String toRead() {
    System.out.println("Reading called "+ Thread.currentThread().getName());
    System.out.println(atomicInteger.incrementAndGet() + " To read called " + Instant.now());
    String someBook =  bookService.readingList();
    System.out.println("Reading response"+ Thread.currentThread().getName());

    return someBook;
  }

  @RequestMapping("/other")
  public String other() {
    System.out.println(atomicInteger2.incrementAndGet() + " other " + Instant.now());
    return "other";
  }

  public static void main(String[] args) {
    SpringApplication.run(ReadingApplication.class, args);
  }
}

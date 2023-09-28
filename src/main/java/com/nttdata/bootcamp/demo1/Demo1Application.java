package com.nttdata.bootcamp.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Demo1Application {

  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

}

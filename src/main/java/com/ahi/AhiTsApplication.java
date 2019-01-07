package com.ahi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableAutoConfiguration()
@EnableEncryptableProperties
public class AhiTsApplication  {

  public static void main(String[] args) {
    SpringApplication.run(AhiTsApplication.class, args);
  }
}

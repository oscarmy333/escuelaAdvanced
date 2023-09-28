package com.nttdata.bootcamp.demo1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link WebClientConfig}<br/>
 * <b>Copyright</b>: &Copy; 2022 Everis Per&uacute;. <br/>
 * <b>Company</b>: Everis del Per&uacute;. <br/>
 *
 * @author Everis Per&uacute;. (EVE) <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (EVE)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 05, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@Configuration
public class WebClientConfig {

  @Value("${application.endpoints.url.valid_address}")
  private String urlEndpoint;

  @Bean
  public WebClient webClientUser() {

    return WebClient.builder()
        .baseUrl(urlEndpoint)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }

}

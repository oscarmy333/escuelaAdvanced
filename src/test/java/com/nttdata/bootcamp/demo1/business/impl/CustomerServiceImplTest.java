package com.nttdata.bootcamp.demo1.business.impl;

import com.google.gson.Gson;
import com.nttdata.bootcamp.demo1.business.CustomerService;
import com.nttdata.bootcamp.demo1.model.Customer;
import com.nttdata.bootcamp.demo1.model.dto.User;
import com.nttdata.bootcamp.demo1.repostitory.CustomerRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import okhttp3.mockwebserver.MockWebServer;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerServiceImplTest}<br/>
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
 * <li>ene. 11, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@SpringBootTest
public class CustomerServiceImplTest {

  @Autowired
  private CustomerService customerService;
  @MockBean
  private CustomerRepository customerRepository;

  public static MockWebServer mockBackEnd;

  private static Customer customerMock = new Customer();
  private static List<User> lsUserMock = new ArrayList<>();
  private static User userMock = new User();
  private final static String CUSTOMER_ID = "1";
  private final static String USER_ID = "100";
  private final static String USER_PHONE = "123456789";
  private final static String FIRST_NAME = "pepe";
  private final static String LAST_NAME = "Mendoza";

  @BeforeAll
  static void setUp(@Value("${server.port}") int port) throws IOException {
    customerMock.setId(CUSTOMER_ID);
    customerMock.setFirstname(FIRST_NAME);
    customerMock.setLastname(LAST_NAME);

    userMock.setId(new Integer(USER_ID));
    userMock.setPhone(USER_PHONE);
    lsUserMock.add(userMock);

    mockBackEnd = new MockWebServer();
    mockBackEnd.start(port);
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockBackEnd.shutdown();
  }


  @BeforeEach
  void initialize(@Value("${application.endpoints.url.valid_address}") String urlClient) {

    Gson gson = new Gson();
    mockBackEnd.url(urlClient);
    mockBackEnd.enqueue(new MockResponse()
        .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .setBody(gson.toJson(lsUserMock))
        .setResponseCode(HttpStatus.OK.value()));

  }

  @Test
  void findById(){

    when(customerRepository.findById(CUSTOMER_ID)).thenReturn(Mono.just(customerMock));
    Mono<Customer> customerMono = customerService.findById(CUSTOMER_ID);

    StepVerifier
        .create(customerMono)
        .consumeNextWith(newCustomer -> {
          assertEquals(newCustomer.getFirstname(), FIRST_NAME);
        })
        .verifyComplete();
  }

  @Test
  void findByUser(){
    StepVerifier.create(customerService.findByUser(USER_ID))
        .expectSubscription()
        .expectNext(userMock)
        .verifyComplete();
  }
}

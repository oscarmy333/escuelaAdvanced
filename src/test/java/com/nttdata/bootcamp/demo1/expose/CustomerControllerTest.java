package com.nttdata.bootcamp.demo1.expose;

import static org.mockito.Mockito.when;

import com.nttdata.bootcamp.demo1.business.CustomerService;
import com.nttdata.bootcamp.demo1.model.Customer;
import com.nttdata.bootcamp.demo1.repostitory.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerControllerTest}<br/>
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "20000")
public class CustomerControllerTest {

  @MockBean
  private CustomerService customerService;
  @Autowired
  private WebTestClient webClient;

  private static Customer customeMock = new Customer();
  private final static String ID = "1";
  private final static String FIRST_NAME = "pepe";
  private final static String LAST_NAME = "Mendoza";

  @BeforeAll
  static void setUp() {
    customeMock.setId(ID);
    customeMock.setFirstname(FIRST_NAME);
    customeMock.setLastname(LAST_NAME);

  }
  @Test
  @DisplayName("GET -> /api/customers/{id}")
  void byId(){

    when(customerService.findById(ID)).thenReturn(Mono.just(customeMock));

    WebTestClient.ResponseSpec responseSpec = webClient.get().uri("/api/customers/"+ID)
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    responseSpec.expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON);

    responseSpec.expectBody()
        .jsonPath("$.firstname").isEqualTo(customeMock.getFirstname());
  }
}

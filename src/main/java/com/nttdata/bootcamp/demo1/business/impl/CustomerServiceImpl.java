package com.nttdata.bootcamp.demo1.business.impl;

import com.nttdata.bootcamp.demo1.business.CustomerService;
import com.nttdata.bootcamp.demo1.model.Address;
import com.nttdata.bootcamp.demo1.model.Customer;
import com.nttdata.bootcamp.demo1.model.dto.User;
import com.nttdata.bootcamp.demo1.repostitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerServiceImpl}<br/>
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
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private WebClient webClientUser;


  @Override
  public Mono<Customer> create(Customer customer) {

    if(!customer.getUsername().isBlank()){
      return webClientUser.get()
      .uri(uriBuilder -> uriBuilder
          .queryParam("username", customer.getUsername())
          .build())
          .retrieve()
          .bodyToFlux(User.class)
          .next()
          .flatMap(user -> {
            Address address = new Address();
            address.setStreet(user.getAddress().getStreet());
            address.setCity(user.getAddress().getCity());
            customer.setAddress(address);
            customer.setEmail(user.getEmail());
            return customerRepository.save(customer);
          });
    }

    return customerRepository.save(customer);
  }

  @Override
  public Mono<Customer> findById(String customerId) {
    return customerRepository.findById(customerId);
  }

  @Override
  public Flux<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Mono<Customer> update(Customer customer) {
    return null;
  }

  @Override
  public Mono<Customer> change(Customer customer) {
    return customerRepository.findById(customer.getId())
        .flatMap(customerDB -> {
          return create(customer);
        })
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Customer> remove(String customerId) {
    return customerRepository
        .findById(customerId)
        .flatMap(p -> customerRepository.deleteById(p.getId()).thenReturn(p));

  }

  @Override
  public Flux<Customer> findByCountry(String country) {
    return customerRepository.findCustomerByAddress_Country(country);
  }

  @Override
  public Flux<User> findByUser(String id) {

    return webClientUser.get()
        .uri(uriBuilder -> uriBuilder
            .queryParam("id", id)
            .build())
        .retrieve()
        .bodyToFlux(User.class);
  }
}

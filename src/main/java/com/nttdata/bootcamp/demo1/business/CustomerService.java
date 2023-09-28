package com.nttdata.bootcamp.demo1.business;

import com.nttdata.bootcamp.demo1.model.Customer;
import com.nttdata.bootcamp.demo1.model.dto.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerService}<br/>
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
 * <li>ene. 04, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
public interface CustomerService {

  Mono<Customer> create(Customer customer);

  Mono<Customer> findById(String customerId);

  Flux<Customer> findAll();

  Mono<Customer> update(Customer customer);

  Mono<Customer> change(Customer customer);

  Mono<Customer> remove(String customerId);

  Flux<Customer> findByCountry(String country);

  Flux<User> findByUser(String id);
}

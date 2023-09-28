package com.nttdata.bootcamp.demo1.repostitory;

import com.nttdata.bootcamp.demo1.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerRepository}<br/>
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
@Repository
public interface CustomerRepository
    extends ReactiveMongoRepository<Customer,String> {

  Flux<Customer> findCustomerByAddress_Country(String country);

}

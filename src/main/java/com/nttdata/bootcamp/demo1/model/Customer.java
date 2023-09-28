package com.nttdata.bootcamp.demo1.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Customer}<br/>
 * <b>Copyright</b>: &Copy; 2021 Everis Per&uacute;. <br/>
 * <b>Company</b>: Everis del Per&uacute;. <br/>
 *
 * @author Everis Per&uacute;. (EVE) <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (EVE)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>sep. 15, 2021 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection = "customer")
public class Customer {

  @Id
  private String id = UUID.randomUUID().toString();
  private String firstname;
  private String lastname;
  private String email;
  private String username;
  private Address address;

}

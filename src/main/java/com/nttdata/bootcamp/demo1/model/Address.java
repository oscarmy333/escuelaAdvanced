package com.nttdata.bootcamp.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Address}<br/>
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
public class Address {
  private int number;
  private String street;
  private String city;
  private String country;
}

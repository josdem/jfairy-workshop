package com.jos.dem.jfairy.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

class PersonTest {

  private Person person = Fairy.create().person();

  private static final Logger log = Logger.getLogger(PersonTest.class.getName());

  @Test
  @DisplayName("Should validate person")
  void shouldValidatePerson() {
    log.info("Running: Should validate person information");

    assertAll("person",
        () -> assertNotNull(person.getFirstName(), "Should get person's name"),
        () -> assertNotNull(person.getEmail(), "Should get person's email"),
        () -> assertNotNull(person.getTelephoneNumber(), "Should get person's telephone number")
        );
  }

}

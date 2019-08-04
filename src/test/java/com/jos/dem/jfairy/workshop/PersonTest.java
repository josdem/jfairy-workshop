package com.jos.dem.jfairy.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

class PersonTest {

  private static final String PHONE_REGEX = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
  private Person person = Fairy.create().person();

  private static final Logger log = Logger.getLogger(PersonTest.class.getName());

  @Test
  @DisplayName("Should validate person")
  void shouldValidatePerson() {
    log.info("Running: Should validate information from person: " + ToStringBuilder.reflectionToString(person));

    assertAll("person",
        () -> assertNotNull(person.getFirstName(), "Should get person's name"),
        () -> assertNotNull(person.getEmail(), "Should get person's email"),
        () -> assertTrue(person.getTelephoneNumber().matches(PHONE_REGEX), "Should have a valid telephone number")
        );
  }

}

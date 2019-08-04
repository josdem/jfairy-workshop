package com.jos.dem.jfairy.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonProperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

class PersonComposerTest {

  private static final Integer MIN_AGE=21;

  private Fairy fairy = Fairy.create();
  private Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(MIN_AGE));

  private static final Logger log = Logger.getLogger(PersonComposerTest.class.getName());

  @Test
  @DisplayName("Should validate person")
  void shouldValidatePerson() {
    log.info("Running: Should validate information from person: " + ToStringBuilder.reflectionToString(adultMale));

    assertAll("adult",
        () -> assertTrue(adultMale.isMale(), "should be male"),
        () -> assertTrue(adultMale.getAge() >= MIN_AGE, "should be at least 21 years old")
        );
  }


}

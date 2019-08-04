package com.jos.dem.jfairy.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.company.Company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

class CompanyTest {

  private static final String VAT_REGEX = "[0-9]{2}-[0-9]{7}";
  private static final String DOMAIN_REGEX = "[a-zA-Z]+.[a-zA-Z]{2,10}";

  private Company company = Fairy.create().company();

  private static final Logger log = Logger.getLogger(CompanyTest.class.getName());

  @Test
  @DisplayName("Should validate company")
  void shouldValidateCompany() {
    log.info("Running: Should validate information from company: " + ToStringBuilder.reflectionToString(company));

    assertAll("company",
        () -> assertNotNull(company.getName(), "should get a name"),
        () -> assertTrue(company.getDomain().matches(DOMAIN_REGEX), "should have a valid domain"),
        () -> assertTrue(company.getVatIdentificationNumber().matches(VAT_REGEX), "should have a valid vat number")
        );
  }

}

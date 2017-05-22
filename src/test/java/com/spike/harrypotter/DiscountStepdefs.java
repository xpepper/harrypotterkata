package com.spike.harrypotter;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DiscountStepdefs {
    @When("^I buy (\\d+) cop(?:y|ies) of \"([^\"]*)\"$")
    public void I_buy_copy_of(int numberOfCopies, String title) throws Throwable {
        throw new PendingException();
    }

    @Then("^I must pay (\\d+.?\\d*) EUR$")
    public void I_must_pay_$(float amount) throws Throwable {
        Long expected = Float.valueOf(amount * 100).longValue();
        throw new PendingException();
    }

}
package com.spike.harrypotter.at;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DiscountStepdefs {
    @When("^I buy (\\d+) cop(?:y|ies) of \"([^\"]*)\"$")
    public void I_buy_copy_of(int numberOfCopies, String title) throws Throwable {
//        new Basket().add(numberOfCopies, title);
        throw new PendingException();
    }

    @Then("^I must pay (\\d+.?\\d*) EUR$")
    public void I_must_pay(double amount) throws Throwable {
        Long expected = Double.valueOf(amount * 100).longValue();
        //basket.totalPrice();
        throw new PendingException();
    }

}
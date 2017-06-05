package com.spike.harrypotter.at;

import com.spike.harrypotter.Basket;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class DiscountStepdefs {
    private Basket basket = new Basket();

    @When("^I buy (\\d+) cop(?:y|ies) of \"([^\"]*)\"$")
    public void I_buy_copy_of(int numberOfCopies, String title) throws Throwable {
        basket.add(numberOfCopies, title);
    }

    @Then("^I must pay (\\d+.?\\d*) EUR$")
    public void I_must_pay(double amount) throws Throwable {
        long expectedCost = Double.valueOf(amount * 100).longValue();
        assertEquals(expectedCost, basket.cost());
    }

}
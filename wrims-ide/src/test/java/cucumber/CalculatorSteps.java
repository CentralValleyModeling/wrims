package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private int a;
    private int b;
    private int result;

    @Given("I have the numbers {int} and {int}")
    public void i_have_the_numbers_and(Integer x, Integer y) {
        this.a = x;
        this.b = y;
    }

    @When("I add them")
    public void i_add_them() {
        this.result = this.a + this.b;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer expected) {
        assertEquals(expected.intValue(), this.result, "Sum should match");
    }
}

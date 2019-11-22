package step_definitions;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageobjects.ChartList;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChartListSteps {
    ChartList c = new ChartList();
    @When("^user gets top 250 movies list$")
    public void listOfMovies() {
        c.navigateToListOfMovies();
    }
    @Then("^user verifies and prints the same into a text file$")
    public void printListOfMovies() throws IOException, FileNotFoundException {
        c.printAndVerifyListOfMovies();
    }
}

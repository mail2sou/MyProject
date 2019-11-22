package step_definitions;

import cucumber.api.java.en.Given;
import pageobjects.Home;

public class HomeSteps {
    Home h=new Home();
    @Given("^user navigates to imdb home page$")
    public void navigation(){
        h.navigateTo();
    }
}

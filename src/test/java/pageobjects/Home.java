package pageobjects;

import step_definitions.Hooks;

public class Home extends Hooks {
    //navigate to IMDB home page
    public void navigateTo() {
        driver.get("https://www.imdb.com/");
    }
}

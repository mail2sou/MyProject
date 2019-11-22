package runners;
import org.junit.runner.RunWith;
        import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"step_definitions"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)
public class TestRunner {
}
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import selenium.testBase.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "StepsDefinitions", plugin = { "pretty", "html:target/cucumber-reports/report.html"},
        monochrome = true)

public class TestRunner extends TestBase {

}

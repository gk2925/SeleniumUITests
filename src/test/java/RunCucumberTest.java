import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        monochrome = true,
        features = "classpath:features",
        glue={"com.tourradar.webtests.steps"},
        plugin = {("json:target/cucumber-reports/cucumberTestReport.json"),
                ("timeline:target/cucumber-reports/timeLine.json"),
                ("html:target/cucumber-reports/cucumberTestReport.html")},
        dryRun = false
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

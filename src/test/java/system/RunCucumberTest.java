package system;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/java/system"
)
public class RunCucumberTest {
}


package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features= "features/OpenGoogle.feature" ,glue="stepDefinitions")
public class RunnerClass {



}
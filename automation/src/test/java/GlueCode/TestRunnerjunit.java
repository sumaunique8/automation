package GlueCode;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)  
@CucumberOptions(features="src/test/resources/Features",
glue= {"GlueCode"},
plugin={"pretty", "Hooks.customReportListener" ,
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"junit:target/JunitReports/reports.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReport/HtmlReport"
},dryRun=false,monochrome=true
//        tags="@Scenario1_Creating_Automatic_Number_&_Deleting"
//      tags="@Scenario_2:ClientFilter_&_getting_History_of_orders"
)
public class TestRunnerjunit   {

}

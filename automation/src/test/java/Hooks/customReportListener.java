package Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import utility.ScreenshotUtil;

import java.util.HashMap;
import java.util.Map;

public class customReportListener implements ConcurrentEventListener {

    private static ExtentReports extentReports;
    private static Map<String, ExtentTest> featureTestMap = new HashMap<>();
    private static ExtentTest scenarioTest;
    private static ExtentTest stepTest;

    public customReportListener() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-spark-report.html");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Extent Report - Cucumber");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Cucumber Extent Spark Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Your Name");
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepStarted.class, this::onTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onTestRunStarted(TestRunStarted event) {
        System.out.println("Test run started.");
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        String featureName = extractFeatureName(event.getTestCase().getUri().toString());

        // Ensure the feature test node is created only once
        if (!featureTestMap.containsKey(featureName)) {
            ExtentTest featureTest = extentReports.createTest(featureName);
            featureTestMap.put(featureName, featureTest);
        }

        ExtentTest featureTest = featureTestMap.get(featureName);
        String scenarioName = event.getTestCase().getName();
        scenarioTest = featureTest.createNode(scenarioName);
        System.out.println("Test case started: " + scenarioName);
    }

    private void onTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            String stepText = testStep.getStep().getKeyword() + " " + testStep.getStep().getText();
            stepTest = scenarioTest.createNode(stepText);
            stepTest.log(Status.INFO, "Step started: " + stepText);
        }
    }

    private void onTestStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            Status extentStatus = mapStatus(event.getResult().getStatus());
            String stepText = testStep.getStep().getKeyword() + " " + testStep.getStep().getText();

            if (extentStatus.equals(Status.FAIL)) {
            	
                stepTest.log(extentStatus, "Step failed: " + event.getResult().getError().getMessage());
////                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "screenshot_" + System.currentTimeMillis());
//                stepTest.log(extentStatus, "Step failed: " + event.getResult().getError().getMessage(),
////                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                stepTest.log(extentStatus, "Step finished: " + stepText);
            }
            System.out.println("Test step finished: " + stepText + " with status: " + extentStatus);
        }
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        System.out.println("Test case finished: " + event.getTestCase().getName());
    }

    private void onTestRunFinished(TestRunFinished event) {
        extentReports.flush();  // Finalize and write the report
        System.out.println("Test run finished.");
    }

    private Status mapStatus(io.cucumber.plugin.event.Status cucumberStatus) {
        switch (cucumberStatus) {
            case PASSED:
                return Status.PASS;
            case FAILED:
                return Status.FAIL;
            case SKIPPED:
                return Status.SKIP;
            case PENDING:
            case UNDEFINED:
                return Status.WARNING;
            default:
                return Status.INFO;
        }
    }

    private String extractFeatureName(String uri) {
        // Extracting the feature name from the URI
        // Assuming the feature file name is at the end of the URI
        if (uri != null && uri.contains("/")) {
            return uri.substring(uri.lastIndexOf("/") + 1).replace(".feature", "");
        }
        return uri;
    }
}
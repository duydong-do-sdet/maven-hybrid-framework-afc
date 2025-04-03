package commons;

import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestFailuresCollector extends HashMap<ITestResult, List<Throwable>> {
    private static final long serialVersionUID = 1L;
    private static TestFailuresCollector testFailure;

    private TestFailuresCollector() {
        super();
    }

    public static TestFailuresCollector getTestFailure() {
        if (testFailure == null) {
            testFailure = new TestFailuresCollector();
        }
        return testFailure;
    }

    public List<Throwable> getFailures(ITestResult testResult) {
        List<Throwable> failures = get(testResult);
        return failures == null ? new ArrayList<>() : failures;
    }

    public void addFailure(ITestResult testResult, Throwable failure) {
        List<Throwable> failures = getFailures(testResult);
        failures.add(failure);
        put(testResult, failures);
    }

}

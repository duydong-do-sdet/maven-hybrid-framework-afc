package commons;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.util.List;

public class TestFailuresListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Reporter.setCurrentTestResult(testResult);

        if (method.isTestMethod()) {
            TestFailuresCollector failureCollector = TestFailuresCollector.getTestFailure();

            if (testResult.getThrowable() != null) {
                failureCollector.addFailure(testResult, testResult.getThrowable());
            }

            List<Throwable> failures = failureCollector.getFailures(testResult);
            int failureCount = failures.size() - 1;

            if (failureCount > 0) {
                testResult.setStatus(ITestResult.FAILURE);

                if (failureCount == 1) {
                    testResult.setThrowable(failures.getFirst());
                } else {
                    StringBuilder failureMessage = new StringBuilder("Multiple test failures (").append(failureCount).append("):\n");

                    for (int i = 0; i < failureCount - 1; i++) {
                        failureMessage.append("Failure ").append(i + 1).append(" of ").append(failureCount).append("\n");
                        failureMessage.append(Utils.longStackTrace(failures.get(i), false)).append("\n");
                    }

                    Throwable lastFailure = failures.get(failureCount - 1);
                    failureMessage.append("Failure ").append(failureCount).append(" of ").append(failureCount).append("\n");
                    failureMessage.append(lastFailure.toString());

                    Throwable mergedFailure = new Throwable(failureMessage.toString());
                    mergedFailure.setStackTrace(lastFailure.getStackTrace());
                    testResult.setThrowable(mergedFailure);
                }
            }
        }
    }

}

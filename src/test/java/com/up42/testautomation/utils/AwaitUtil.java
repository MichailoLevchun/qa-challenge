package com.up42.testautomation.utils;

import com.up42.testautomation.models.response.workflowJob.WorkflowJobResponse;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.awaitility.core.ConditionTimeoutException;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;
import static org.awaitility.Awaitility.with;
import static org.testng.Reporter.log;

public class AwaitUtil {

    private static Predicate<Response> isJobCompleted() {
        return p -> p.as(WorkflowJobResponse.class).getData()
                .getStatus().equals("SUCCEEDED");
    }

    private static Response waitForJobCompleted(Callable<Response> fun) {
        return with().pollInterval(Duration.ofSeconds(20))
                .await()
                .atMost(Duration.ofMinutes(5))
                .until(fun, isJobCompleted());
    }

    @SneakyThrows
    public static Response retryReceiveJobStatus(Callable<Response> fun) {
        return waitForJobCompleted(fun);
    }
}

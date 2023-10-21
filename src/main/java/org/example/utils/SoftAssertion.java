package org.example.utils;

import com.google.common.base.Joiner;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SoftAssertion {

    public static List<AssertionError> errorList = new ArrayList<>();

    public static <T> void assertThat(String reason, Supplier<T> supplierForGettingActualValue, Matcher<? super T> matcher) {
        for (int i = 0; i < 5; i++) {
            try {
                MatcherAssert.assertThat(reason, supplierForGettingActualValue.get(), matcher);
                return;
            } catch (AssertionError e) {
                if (i == 4) {
                    errorList.add(e);
                }
            }
        }
    }


    public static void assertAll() {
        if (!errorList.isEmpty()) {
            String resultMessage = Joiner.on("\n")
                    .join(errorList
                            .stream()
                            .map(a -> a.getMessage())
                            .collect(Collectors.toList()));
            errorList.clear();
            throw new AssertionError(resultMessage);
        }
    }

}
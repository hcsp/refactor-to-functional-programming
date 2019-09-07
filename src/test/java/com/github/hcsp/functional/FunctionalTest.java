package com.github.hcsp.functional;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionalTest {
    @Test
    @CaptureSystemOutput
    public void consumerTest(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.matchesRegex("(?s).*AA\\s+BB\\s+CC\\s+DD.*"));
        Map<String, String> map1 = Stream.of("A", "B").collect(Collectors.toMap(k -> k, v -> v));
        Map<String, String> map2 = Stream.of("C", "D").collect(Collectors.toMap(k -> k, v -> v));
        RefactorToConsumer.printWithConsumer(map1, map2, (k, v) -> System.out.println(k + v));
    }

    @Test
    public void supplierTest() {
        List<Object> results = RefactorToSupplier.create(() -> 0);
        Assertions.assertEquals(results, Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    public void functionTest() {
        int[] results =
                RefactorToFunction.calculate(
                        new int[] {1, 2}, new int[] {3, 4}, (a, b) -> (a * 2 + b));
        Assertions.assertArrayEquals(results, new int[] {5, 8});
    }
}

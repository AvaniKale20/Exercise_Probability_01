package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {

    @Test
    void givenZeroProbabilityOfTwoEvents_WhenCheckEquality_ThenReturnZero() {
        float zeroProbability = 0.0f;
        Probability zeroProbabilityEvents1 = new Probability(zeroProbability);
        Probability zeroProbabilityEvents2 = new Probability(zeroProbability);
        assertEquals(true, zeroProbabilityEvents1.equals(zeroProbabilityEvents2));

    }
}

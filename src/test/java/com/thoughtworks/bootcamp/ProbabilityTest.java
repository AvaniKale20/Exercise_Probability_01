package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {

    @Test
    void givenZeroProbabilityOfTwoEvents_WhenCheckEquality_ThenReturnZero()
    {
        float zeroProbability=0.0f;
Probability zeroProbabilityEvents1=new Probability(zeroProbability);
        assertEquals(0.0f,zeroProbabilityEvents1.EqualityOfEvents());

    }
}

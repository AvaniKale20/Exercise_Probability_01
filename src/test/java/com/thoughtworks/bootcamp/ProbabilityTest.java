package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProbabilityTest {
    private static Probability impossibleEvent;
    private static Probability certainEvent;

    @BeforeAll
    static void setUp() {
        impossibleEvent = new Probability(0.0f);
        certainEvent = new Probability(1.0f);
    }

    @Test
    void givenZeroProbabilitiesOfTwoEvents_WhenChecksEquality_ThenReturnsTrue() {
        Probability zeroProbabilityEventTwo = new Probability(0.0f);
        assertEquals(impossibleEvent, zeroProbabilityEventTwo);
    }

    @Test
    void givenZeroOcuurenceProbability_WhenChecksUnoccuredProbability_ThenReturnsOne() {
        assertEquals(certainEvent, impossibleEvent.not());
    }

    @Test
    void givenOneProbability_WhenChecksUnoccuredProbability_ThenReturnsZero() {
        assertEquals(impossibleEvent, certainEvent.not());
    }

    @Test
    void givenTwoZeroProbabilites_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.and(impossibleEvent));
    }

    //
    @Test
    void givenOneEventOfProbabilityOneAndAnotherProbabilityZeroDotOne_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZeroDotOne() {

        Probability ZeroDotOneProbability = new Probability(0.1f);
        assertEquals(new Probability(0.1f), ZeroDotOneProbability.and(certainEvent));
    }

    @Test
    void givenTwoOneProbabilityEvents_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsOne() {
        Probability headInACoinToss = new Probability(0.5f);
        assertEquals(new Probability(0.25f), headInACoinToss.and(headInACoinToss));
    }

    @Test
    void givenOneImposibleEventsAndCertainEvents_WhenCalculatingProbabilityEitherOfTwoEventsOccure_ThenOne() {
        assertEquals(certainEvent, impossibleEvent.or(certainEvent));
    }


}


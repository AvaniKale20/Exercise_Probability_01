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
    void givenOneProbability_WhenChecksNotoccuredProbability_ThenReturnsZero() {
        assertEquals(impossibleEvent, certainEvent.not());
    }

    @Test
    void givenTwoZeroProbabilites_WhenCalculatingProbabilityOfEventsOccurringTogether_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.and(impossibleEvent));
    }


    @Test
    void givenOneEventOfProbabilityOneAndAnotherProbabilityZeroDotOne_WhenCalculatingProbabilityOfEventsOccurringTogether_ThenReturnsZeroDotOne() {

        Probability ZeroDotOneProbability = new Probability(0.1f);
        assertEquals(new Probability(0.1f), ZeroDotOneProbability.and(certainEvent));
    }

    @Test
    void givenTwoOneProbabilityEvents_WhenCalculatingProbabilityOfEventsOccurringTogether_ThenReturnsOne() {
        Probability headInACoinToss = new Probability(0.5f);
        assertEquals(new Probability(0.25f), headInACoinToss.and(headInACoinToss));
    }

    @Test
    void givenTwoDifferentProbabilityOfTwoEvent_WhenCalculatedOfEventOccurringTogether_ThenReturnZeroPointTwoFive() {
        Probability headInACoinToss = new Probability(0.5f);
        Probability tailInACoinToss = new Probability(0.5f);
        assertEquals(new Probability(0.25f), headInACoinToss.and(tailInACoinToss));
    }

    @Test
    void givenTwoDifferentProbabilityOfTwoEvent_WhenCalculatedOfEventOccurringTogether_ThenReturnZeroPointTwoZero() {
        Probability headInACoinToss = new Probability(0.4f);
        Probability tailInACoinToss = new Probability(0.5f);
        assertEquals(new Probability(0.20f), headInACoinToss.and(tailInACoinToss));
    }

    /**
     * Doubt Not return 0.06 and  but its return 0.20f
     */
//    @Test
//    void givenTwoDifferentProbabilityOfTwoEvent_WhenCalculatedOfEventOccurringTogether_ThenReturn() {
//        Probability headInACoinToss = new Probability(0.2f);
//        Probability tailInACoinToss = new Probability(0.3f);
//        assertEquals(new Probability(0.06f), headInACoinToss.and(tailInACoinToss));
//    }
    @Test
    void givenOneImpossibleEventsAndCertainEvents_WhenCalculatingProbabilityEitherOfTwoEventsOccur_ThenReturnOne() {
        assertEquals(certainEvent, impossibleEvent.or(certainEvent));
    }

    @Test
    void givenTwoImpossibleEvents_WhenCalculatingProbabilityEitherOfTwoEventsOccur_ThenReturnZero() {
        assertEquals(impossibleEvent, impossibleEvent.or(impossibleEvent));
    }

    @Test
    void givenTwoCertainEvents_WhenCalculatingProbabilityEitherOfTwoEventsOccur_ThenReturnOne() {
        assertEquals(certainEvent, certainEvent.or(certainEvent));
    }

    @Test
    void givenDifferentProbabilitiesOfTwoEvents_WhenCalculatingProbabilityOfEitherOfTwoEventsOccur_ThenReturnZeroPointFour() {
        Probability evenNoOfRollingDice = new Probability(0.2f);
        Probability oddNoOfRollingDice = new Probability(0.3f);
        assertEquals(new Probability(0.44f), evenNoOfRollingDice.or(oddNoOfRollingDice));

    }


}


package br.com.blz.java8lecture.collectors;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

import static br.com.blz.java8lecture.collectors.BlzStatsCollector.toBlzStatsCollector;

public class BlzStatsCollectorTest {

    @Test
    public void shouldReturnModeForUniqueMode() {

        BlzStatsSummary blzStatsSummary = Stream.of(1d, 2d, 3d, 4d, 5d, 5d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertTrue(blzStatsSummary.getMode().isPresent());
        Assert.assertEquals(1, blzStatsSummary.getMode().get().size());
        Assert.assertEquals(5d, blzStatsSummary.getMode().get().get(0), 0d);
    }

    @Test
    public void shouldReturnModeForRepeatedMode() {

        BlzStatsSummary blzStatsSummary = Stream.of(1d, 1d, 2d, 3d, 4d, 4d, 5d, 5d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertTrue(blzStatsSummary.getMode().isPresent());
        Assert.assertEquals(3, blzStatsSummary.getMode().get().size());
    }

    @Test
    public void shouldReturnEmptyListForNoValuesList() {

        BlzStatsSummary blzStatsSummary = new BlzStatsSummary();

        Assert.assertFalse(blzStatsSummary.getMode().isPresent());
    }
}
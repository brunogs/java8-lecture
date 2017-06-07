package br.com.blz.java8lecture.collectors;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static br.com.blz.java8lecture.collectors.BlzStatsCollector.toBlzStatsCollector;
import static org.junit.Assert.assertEquals;

public class BlzStatsCollectorTest {

    @Test
    public void shouldGetAllMetricsAvailable() {
        BlzStatsSummary blzStatsSummary = Stream.of(1d, 2d, 3d, 4d, 5d, 6d).collect(toBlzStatsCollector(Double::doubleValue));

        List<Double> mode = blzStatsSummary.getMode();
        OptionalDouble median = blzStatsSummary.getMedian();
        double average = blzStatsSummary.getAverage();

        Assert.assertFalse(mode.isEmpty());
        Assert.assertTrue(median.isPresent());
        Assert.assertNotEquals(0d, average, 0d);

        assertEquals(6, mode.size());

        assertEquals(3.5d, median.getAsDouble(), 0d);

        assertEquals(3.5d, average, 0d);
    }

    @Test
    public void shouldReturnModeForUniqueMode() {

        BlzStatsSummary blzStatsSummary = Stream.of(1d, 2d, 3d, 4d, 5d, 5d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertFalse(blzStatsSummary.getMode().isEmpty());
        assertEquals(1, blzStatsSummary.getMode().size());
        assertEquals(5d, blzStatsSummary.getMode().get(0), 0d);
    }

    @Test
    public void shouldReturnModeForRepeatedMode() {

        BlzStatsSummary blzStatsSummary = Stream.of(1d, 1d, 2d, 3d, 4d, 4d, 5d, 5d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertFalse(blzStatsSummary.getMode().isEmpty());
        assertEquals(3, blzStatsSummary.getMode().size());
    }

    @Test
    public void shouldReturnEmptyListForNoValuesList() {

        BlzStatsSummary blzStatsSummary = new BlzStatsSummary();

        Assert.assertTrue(blzStatsSummary.getMode().isEmpty());
    }

    @Test
    public void shouldReturnMediaForOddList() {
        BlzStatsSummary blzStatsSummary = Stream.of(1d, 1d, 2d, 3d, 4d, 4d, 5d, 5d, 6d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertTrue(blzStatsSummary.getMedian().isPresent());
        assertEquals(4d, blzStatsSummary.getMedian().getAsDouble(), 0d);

    }

    @Test
    public void shouldReturnMediaForEvenList() {
        BlzStatsSummary blzStatsSummary = Stream.of(1d, 1d, 2d, 3d, 5d, 4d, 5d, 5d, 6d, 6d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertTrue(blzStatsSummary.getMedian().isPresent());
        assertEquals(4.5d, blzStatsSummary.getMedian().getAsDouble(), 0d);

    }

    @Test
    public void shouldReturnIdentityForOneItemList() {
        BlzStatsSummary blzStatsSummary = Stream.of(6d).collect(toBlzStatsCollector(Double::doubleValue));

        Assert.assertTrue(blzStatsSummary.getMedian().isPresent());
        assertEquals(6d, blzStatsSummary.getMedian().getAsDouble(), 0d);

    }
}
package testnumberrangesummarizer;

import numberrangesummarizer.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;
import org.junit.Assert;

public class TestNumberRangeSummary{

    @Test
    public void testCollect(){

        NumberRangeSummarizer summarizer = new NumberRangeSummary();
        
        Collection<Integer> sequence = summarizer.collect("3,5,1,4,3,5,2");
        Collection<Integer> expectedSequence = new HashSet<>();
        expectedSequence.addAll(Arrays.asList(1,2,3,4,5)); 

        Assert.assertEquals(expectedSequence, sequence);
    }

    @Test
    public void testSummerizeCollection(){
        NumberRangeSummarizer summarizer = new NumberRangeSummary();

        Collection<Integer> sequence = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String result = summarizer.summarizeCollection(sequence);
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        
        Assert.assertEquals(expectedResult, result);
    }

}
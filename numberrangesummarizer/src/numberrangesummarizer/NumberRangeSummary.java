package numberrangesummarizer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class NumberRangeSummary implements NumberRangeSummarizer{
    
    @Override
    public Collection<Integer> collect(String input){
        
        //Converting the input to an array using the commas as a delimeter
        String[] arrayOfStrings = input.split(",");

        //Using a TreeSet to ensure that there are no duplicates and that the numbers are in ascending order
        Set<Integer> orderedSequence = new TreeSet<>();

        for(int i=0; i< arrayOfStrings.length; i++){
            orderedSequence.add(Integer.valueOf(arrayOfStrings[i]));
        }

        return orderedSequence;

    }

    @Override
    public String summarizeCollection(Collection<Integer> input){
        //expecting the inputed collection to be sorted in ascedening order, without any duplicates
        //I am assuming that the collection will be of size 2 or more elements

        Iterator<Integer> iterator = input.iterator();
        Integer startNumber = iterator.next();
        StringBuilder result = new StringBuilder(String.valueOf(startNumber));
        boolean thereIsASequence = false;

        while(iterator.hasNext()){
            Integer currentNumber = iterator.next();

            if (currentNumber-startNumber != 1){
                if(thereIsASequence){
                    result.append("-" + startNumber + ", " + currentNumber);
                }
                else{
                    result.append(", " + currentNumber);
                }
                thereIsASequence = false;
            }
            else{
                thereIsASequence = true; 

                if(!iterator.hasNext()){
                    result.append("-" + currentNumber);
                }
            }
            startNumber = currentNumber;
        }

        return result.toString();

    }


}
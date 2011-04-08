//Kathy Walker
//EECS 233
//Programming Assignment #3
//April 7, 2011
//Purpose: To use hashtables to count the frequency of occurance of words in a text file
//Class: Main
//*************************************************************************************************

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] unused) {
     
        
        try {
            //Get file to analyze
            String directory = "source/";
            String fileName = "BraveNewWorld.txt";
            File inputFile = new File(directory + fileName);
            System.out.println("File analyzed: " + fileName);
           
            //Supply file to WordCounter.
            WordCount counter = new WordCount();
            counter.countWords(inputFile);
            
            //Get the results.
            String[] words   = counter.getWords(WordCount.SortOrder.BY_FREQUENCY);
            int[] frequency = counter.getFrequencies(WordCount.SortOrder.BY_FREQUENCY);
            
            //Write the results to text file
            int n = counter.getEntryCount();{
            FileWriter outputFileWriter = new FileWriter("result/result.txt");
            for (int i=0; i<n; i++) {
            outputFileWriter.write(frequency[i] + " " + words[i]+"\r\n");
            }
            outputFileWriter.write("\r\nTotal number of words: " + counter.getWordCount());
            outputFileWriter.write("\r\nTotal number of unique words: " + n);
            outputFileWriter.close();     
           }
            System.out.println("Total number of words: " + counter.getWordCount());
            System.out.println("Total number of unique words: " + n);
            } catch (IOException error) {
              System.out.println(error);
        }
    }
}
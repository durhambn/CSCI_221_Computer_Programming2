import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/*
 * CSCI 221, Spring 2017, Programming HW 1
 * Brandi Durham
 *
 * This program analyzes movie review data to determine if words have a 
 * negative or positive meaning. If a word is used more often in positive 
 * reviews, it is assumed that the word is positive, and vice versa.
 * Currently, it reads review data line by line - each line is a single review in the form:
 * <integer rating of movie> <Verbal review - text supporting the rating> <newline>
 * 
 * This program offers a menu of options to do, such as seperate the words into a positive.txt file or a negative.txt,
 * get the score of a word, get the average score of words in a file.
 */

public class ProgHW1 
{
    public static void main(String[] args) throws IOException //FileNotFoundException 
    {
        /*Scanner keyboard = new Scanner(System.in);
        File reviewFile = new File("movieReviews.txt");
        Scanner reviewScanner = new Scanner(reviewFile);*/
        
        int reviewScore;
        String reviewText;
        String word; 
        double average = 0;
        int numEntered;
        String endofLine;
        
        do
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1: Get the score of a word");
            System.out.println("2: Get the average score of words in a file (one word per line)");
            System.out.println("3: Find the highest/lowest scoring words in a file");
            System.out.println("4: Sort words from a file into positive.txt and negative.txt");
            System.out.println("5: Exit the program");
            System.out.println("Enter a number 1-5");
            numEntered = keyboard.nextInt();
            endofLine = keyboard.nextLine();
        }
        while((numEntered <= 0) || (numEntered >5));
        while(numEntered != 5)
        {
            while(numEntered == 1) //get the score of a word
            {
                    Scanner keyboard = new Scanner(System.in);
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);
                    System.out.println("Enter a word.");
                    word = keyboard.nextLine();
                    int counter=0;
                    double total=0;
                    average = 0;
                    // This loop iterates as long as there is text in the file      
                    while(reviewScanner.hasNext())
                        {
                            // Read the numeric movie rating
                            reviewScore = reviewScanner.nextInt();
                            // Read the text of the verbal review
                            reviewText = reviewScanner.nextLine();
                
                            // If the review contains the word the user entered, print the 
                            // rating and the review and continue; if it does not, process the
                            // next review
                            if(reviewText.contains(" " + word + " "))
                            {
                                //System.out.println("Score: "+reviewScore);
                                //System.out.println("Text: "+reviewText);
                                total+= reviewScore;
                                counter++;
                            }
                        }
                    if ( counter !=0)
                        average = total/counter;
                    System.out.println();
                    System.out.println(word + " appears " + counter + " times");
                    System.out.println("The average score for reviews containing the word " + word + " is " + average);
                     do
                    {
                        System.out.println();
                        System.out.println("What would you like to do?");
                        System.out.println("1: Get the score of a word");
                        System.out.println("2: Get the average score of words in a file (one word per line)");
                        System.out.println("3: Find the highest/lowest scoring words in a file");
                        System.out.println("4: Sort words from a file into positive.txt and negative.txt");
                        System.out.println("5: Exit the program");
                        System.out.println("Enter a number 1-5");
                        numEntered = keyboard.nextInt();
                        endofLine = keyboard.nextLine();
                    }
                    while((numEntered <= 0) || (numEntered >5));
            }
            while (numEntered == 2) //Get the average score of words in a file(one word per line)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter name of file you want to find the average for:");
                String fileName = keyboard.next();
                File reviewLine = new File(fileName);
                Scanner reviewFileLines = new Scanner(reviewLine);
                int totalWords = 0;
                double fileTotal = 0;
                double total= 0;
                int counter = 0;
                
                while(reviewFileLines.hasNext())
                {
                    word = reviewFileLines.next();
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);
                    total = 0;
                    counter = 0;
                    average = 0;
                    while(reviewScanner.hasNext())
                        {
                            // Read the numeric movie rating
                            reviewScore = reviewScanner.nextInt();
                            // Read the text of the verbal review
                            reviewText = reviewScanner.nextLine();
                            if(reviewText.contains(" " + word + " "))
                            {
                                //System.out.println("Score: "+reviewScore);
                                //System.out.println("Text: "+reviewText);
                                total+= reviewScore;
                                counter++;
                            }   
                            if (counter != 0)
                                average = total/counter;
                        }
                        totalWords++;
                        fileTotal += average;
                }
                System.out.println();
                double fileAverage = fileTotal/totalWords;
                System.out.println("The average score of the words in " + fileName + " is " + fileAverage);
                if (fileAverage >= 2.01)
                    System.out.println("The overall sentiment of " + fileName + " is positive");
                else if (fileAverage <= 1.99)
                    System.out.println("The overall sentiment of " + fileName + " is negative");
                else if ((fileAverage >1.99) && (fileAverage <2.01))
                    System.out.println("The overall sentiment of " + fileName + " is neutral");
                System.out.println();
                do
                {
                    System.out.println();
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file (one word per line)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.txt and negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.println("Enter a number 1-5");
                    numEntered = keyboard.nextInt();
                    endofLine = keyboard.nextLine();
                }
                while((numEntered <= 0) || (numEntered >5));
            }
            
            while (numEntered == 3)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter name of file with words you want to find the highest and lowest average:");
                String fileName = keyboard.next();
                File reviewLine = new File(fileName);
                Scanner reviewFileLines = new Scanner(reviewLine);
                int totalWords = 0;
                double fileTotal = 0;
                String mostPosWord = "";
                double mostPos = 0;
                String mostNegWord = "";
                double mostNeg = 4;
                int wordNum = 0;
                double total;
                int counter;
                while(reviewFileLines.hasNext())
                {
                    word = reviewFileLines.nextLine();
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);
                    
                    total = 0;
                    counter = 0;
                    while(reviewScanner.hasNext())
                        {
                            // Read the numeric movie rating
                            reviewScore = reviewScanner.nextInt();
                            // Read the text of the verbal review
                            reviewText = reviewScanner.nextLine();
                
                            // If the review contains the word the user entered, print the 
                            // rating and the review and continue; if it does not, process the
                            // next review
                            if(reviewText.contains(" " + word + " "))
                            {
                                //System.out.println("Score: "+reviewScore);
                                //System.out.println("Text: "+reviewText);
                                total+= reviewScore;
                                counter++;
                            }
                            average = total/counter;
                        
                        }
                        if(average != 0)
                            {
                                wordNum++;
                            if (wordNum == 1)
                            {
                                mostPos = average;
                                mostPosWord = word;
                                mostNeg = average;
                                mostNegWord = word;
                            }
                            if (average > mostPos)
                            {
                                mostPos = average;
                                mostPosWord = word;
                            }
                            if (average < mostNeg)
                            {
                                mostNeg = average;
                                mostNegWord= word;
                            }   
                    }
                    }
                    System.out.println();
                System.out.println("The most positive word, with an average score of " + mostPos + " is " + mostPosWord);
                System.out.println("The most negative word, with an average score of " + mostNeg + " is " + mostNegWord);    
                double fileAverage = fileTotal/totalWords;
            
                do
                {
                    System.out.println();
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file (one word per line)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.txt and negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.println("Enter a number 1-5");
                    numEntered = keyboard.nextInt();
                    endofLine = keyboard.nextLine();
                }
                while((numEntered <= 0) || (numEntered >5));
            }
            while (numEntered == 4) //sorts words from a file into positive.txt or negative.txt
            {
                //File reviewFile = new File("movieReviews.txt");
                Scanner keyboard = new Scanner(System.in); 
                
                File posFile = new File ("positive.txt"); 
                FileWriter fWriterPos = new FileWriter (posFile); 
                PrintWriter pWriterPos = new PrintWriter (fWriterPos); 
                
                File negFile = new File ("negative.txt");
                FileWriter fWriterNeg = new FileWriter (negFile);
                PrintWriter pWriterNeg = new PrintWriter (fWriterNeg);
                
                /*pWriterPos.println ("This is a line.");
                pWriterPos.println ("This is another line."); 
                pWriterPos.close();
                
                pWriterNeg.println("This is a test");
                pWriterNeg.close();*/
                System.out.println("Enter name of file you want to sort:");
                String fileName = keyboard.next();
                File reviewLine = new File(fileName);
                Scanner reviewFileLines = new Scanner(reviewLine);
                int totalWords = 0;
                double fileTotal = 0;
                double total= 0;
                int counter = 0;
                
                while(reviewFileLines.hasNext())
                {
                    word = reviewFileLines.next();
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);
                    total = 0;
                    counter = 0;
                    average = 0;
                    while(reviewScanner.hasNext())
                        {
                            
                            // Read the numeric movie rating
                            reviewScore = reviewScanner.nextInt();
                            // Read the text of the verbal review
                            reviewText = reviewScanner.nextLine();
                            
                            if(reviewText.contains(" " + word + " "))
                            {
                                //System.out.println("Score: "+reviewScore);
                                //System.out.println("Text: "+reviewText);
                                total+= reviewScore;
                                counter++;
                            }   
                            
                            }
                            if (counter != 0)
                                average = total/counter;
                            if (average != 0)
                            {
                                if (average >=2.1)
                                pWriterPos.println(word + " " + average);
                                else if (average <= 1.9)
                                pWriterNeg.println(word + " " + average);
                            }
                    
                }
                pWriterPos.close();
                pWriterNeg.close();
                 do
                {
                    System.out.println();
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file (one word per line)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.txt and negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.println("Enter a number 1-5");
                    numEntered = keyboard.nextInt();
                    endofLine = keyboard.nextLine();
                }
                while((numEntered <= 0) || (numEntered >5));
            }
        }
        }
        }

  

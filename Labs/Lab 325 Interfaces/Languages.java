/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public interface Languages {
    // General getters and setters (NOT defined differently)
    int getSpeakers(); // returns the total number of people speaking the language
    
    String getName(); // returns the language's name
    
    // Abstract methods defined differently in each class
    double nativeSpeak(); // returns the percent of native speakers speaking the language
    
    String sayHello(); // returns "hello" in the given language
}
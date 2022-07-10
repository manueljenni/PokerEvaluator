# PokerEvaluator

This is a very simple solution to determine the winning of two poker hands. 
### Approach
- I used enums for the ranks, suits and types of hands 
- Cards and hands are classes - hands consist of a list of cards and a type
- The HandEvaluator determines the type of hand 
- The HandComparer compares two hands and determines the winning hand

### Dependencies / setup
- Maven 
- JUnit 5 for automated testing
- Lombok for the constructor methods

## How to use
The JAR includes a very simple example of my approach. It can be executed by using `java -jar PokerEvaluator-1.0-SNAPSHOT.jar`.
I recommend cloning the repo and then running the tests to check all the 'features' (`mvn test`).

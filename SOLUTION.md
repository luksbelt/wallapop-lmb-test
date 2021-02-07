# SOLUTION

## Run
```
mvn package
java -jar target/backend-test-0.0.1.jar 

```

## Test
```
mvn verify

```


## Design decisions

### Rover
The representation of the robot requested.

### Map
An abstraction to represent the size and bounds of Mars. There is an abstract method validatePosition() that must be implement to define all the restriction of the implemented map. I choose to create this hierarchy to bring the possibility of an easy extension if new restrictions are needed, or is needed to represent different scenarios with, for instance, more dimensions.
There are two implementation: 
    1. "SingleMap" to represent the behavior of the primary solution.
    2. "ObstaclesMap" to represent the bonus point requirement.

### CardinalDirection
A representation of the cardinal directions with the feature to calculate the next direction (back, right, left).

### Coordinates
A representation of a 2D position (axis x and y).

### Exception
A simple Exception hierarchy to manage the business errors and the messages to print.

### MoveController
This controller transform the user input into commands recognized by Rover.

### Command
The package ".command" has the needed classes to implement the Command Pattern. There I created the 4 basic moves required for this challenge (Forward, Backward, Rotate left and Rotate right). I decided to implement this pattern because it brings extensibility, and decouples the invoker from the Rover.








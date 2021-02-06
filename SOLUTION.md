# SOLUTION

## Rover
The representation of the robot requested.

## Map
An abstraction to represent the size and bounds of Mars. There is an abstract method validatePosition() that must be implement to define all the restriction of the implemented map. I choose to create this hierarchy to bring the possibility of an easy extension if new restrictions are needed, or is needed to represent different scenarios with, for instance, more dimensions.
There are two implementation: 
    1. "SingleMap" to represent the behavior of the primary solution.
    2. "ObstaclesMap" to represent the bonus point requirement.

## Direction
A representation of the cardinal directions with the feature to calculate the next direction (back, right, left).

## Coordinates
A representation of a 2D position (axis x and y).

## Exception
A simple Exception hierarchy to manage the business errors and the messages to print.

# Set Cover Problem Solver

This project provides an efficient solution to the Set Cover Problem, a classic example of a mathematical optimization problem. The goal is to find the smallest subset of sets whose union covers an entire set of elements.

Learn more about the problem: [Set Cover Problem on Wikipedia](https://en.wikipedia.org/wiki/Set_cover_problem).

## Project Structure

The project is organized into several classes, each implementing different parts of the solution. The key classes and their locations are:

- **`Main`** (`src/cover/Main.java`): The entry point of the program. It handles input processing, calls the appropriate algorithm based on user input, and outputs the results.
- **`Algorithm`** (`src/cover/Algorithm.java`): An abstract base class that defines the method `selectCoveringSets` which all algorithms implement.
- **`ExactAlgorithm`** (`src/cover/ExactAlgorithm.java`): Implements the exact algorithm to find the optimal solution using an exhaustive search approach.
- **`NaiveAlgorithm`** (`src/cover/NaiveAlgorithm.java`): Implements a simple heuristic that selects sets in a straightforward, predefined order.
- **`GreedyAlgorithm`** (`src/cover/GreedyAlgorithm.java`): Implements a heuristic that chooses sets based on the maximum immediate coverage, making it an efficient, though not always optimal, solution.
- **`MySet`** (`src/cover/MySet.java`): Represents a custom set containing multiple components.
- **`Component`** (`src/cover/Component.java`): An abstract base class for different types of set components.
- **`Element`, `Finite`, `Infinite`** (`src/cover/Element.java`, `src/cover/Finite.java`, `src/cover/Infinite.java`): These classes represent different types of components that can be part of a set.
- **`SetToCover`** (`src/cover/SetToCover.java`): Represents the set that needs to be covered.
- **`Lexer`** (`src/cover/Lexer.java`): A helper class for parsing the input data.
- **`Query`** (`src/cover/Query.java`): Represents a query to solve a particular instance of the Set Cover Problem.

## Algorithms

### Exact Algorithm (`src/cover/ExactAlgorithm.java`)

The Exact Algorithm is implemented in the `ExactAlgorithm` class. This method guarantees finding the optimal solution by exploring all possible combinations of sets. It uses a brute-force approach to ensure the shortest representation in lexicographical order among all possible solutions.

#### Unique Approach with BigInteger

An innovative feature of this algorithm is its use of `BigInteger` to iterate over all possible subsets. This approach allows the algorithm to handle large numbers and explore every subset without repeating or overflowing, which is a limitation of standard integer types. This method is efficient and leverages Java's capabilities to handle extensive computations, making the `ExactAlgorithm` both robust and scalable.

### Naive Heuristic (`src/cover/NaiveAlgorithm.java`)

The Naive Algorithm, implemented in the `NaiveAlgorithm` class, uses a simple heuristic approach to solve the Set Cover Problem. It considers the sets in ascending order and selects a set if it contains any elements not yet covered. This method is fast and easy to implement, but it does not always provide the optimal solution since it doesn't consider the overall coverage efficiency of each set.

### Greedy Heuristic (`src/cover/GreedyAlgorithm.java`)

The Greedy Algorithm is implemented in the `GreedyAlgorithm` class. It employs a more sophisticated heuristic that iteratively selects the set that maximizes immediate coverage of uncovered elements. Although this method is not guaranteed to find the optimal solution, it is often efficient and provides a good approximation quickly.

## Supporting Classes

### MySet (`src/cover/MySet.java`)

The `MySet` class represents a collection of components (`Element`, `Finite`, `Infinite`) that together form a set. It provides methods to calculate common values with another set, which is crucial for determining coverage in the algorithms.

### Components: Element, Finite, Infinite

- **`Element`** (`src/cover/Element.java`): Represents a single element component within a set.
- **`Finite`** (`src/cover/Finite.java`): Represents a finite sequence of elements, forming part of a set.
- **`Infinite`** (`src/cover/Infinite.java`): Represents an infinite sequence of elements in a set.

Each of these classes extends the abstract `Component` class (`src/cover/Component.java`) and implements the method to find common values with a given set to cover.

### SetToCover (`src/cover/SetToCover.java`)

The `SetToCover` class defines the set that needs to be covered in the problem. It is used by the algorithms to determine whether a given collection of sets provides the necessary coverage.

### Lexer (`src/cover/Lexer.java`)

The `Lexer` class is a utility that assists in parsing the input data. It identifies the components of sets and queries, allowing the main program to correctly interpret and process user input.

### Query (`src/cover/Query.java`)

The `Query` class represents a specific instance of the Set Cover Problem. It holds the set to cover and the algorithm number, and it uses this information to find and output the appropriate solution.

## How to Run

To run the program, compile all the Java files and execute the `Main` class. The program reads input from the standard input and outputs the results to the standard output.

## Output Format

The program outputs a sequence of lines, each corresponding to a query. 

- If a solution exists, the line contains the indices of the sets that form the cover, in ascending order.
- If no solution exists, the line contains the number `0`.

Each line should end with a newline character, with no leading or trailing spaces.

## Example

For the input file `example.in`:

2 0  
1 0 1  

0 -3  
1  
0  
2 3 2 0  
-3 3  
-3 2  
-3 1  
4 -1 -5 1000000000 0  
2 -2 0  
-6 3  
-6 2  
-6 1  
1 6 0  
-6 3  
-6 2  
-6 1  

The output would be in the file `example.out`:

0  
1 2 5  
2 5  
2 5  
1 2 5 6 7  
2 5 6 7  
2 5 6 7  
1 2 5 6 7  
2 5 6 7  
5 6 8  

## Notes

- All input data is assumed to be valid.
- All numbers fit within the range of a 32-bit integer.

# Infix to Postfix Converter and Expression Evaluator

- This project provides a tool for converting mathematical expressions from infix to postfix notation and evaluating postfix expressions. 
- It features a simple GUI built with Java Swing to make the interaction more user-friendly compared to traditional terminal-based programs. The tool supports evaluation of any kind of expression, not limited to single-digit operands.
- This project was created as part of the Data Structures and Algorithms course at the Faculty of Science, Alexandria University.

## Features

- **Infix to Postfix Conversion**: Converts mathematical expressions from infix notation (e.g., `A + B`) to postfix notation (e.g., `A B +`).
- **Expression Evaluation**: Evaluates postfix expressions to compute their results.
- **User-Friendly Interface**: A GUI built with Java Swing for easier interaction.
- **Flexible Expression Handling**: Supports complex expressions, including multi-digit numbers and various operators.

## How to Use

1. **Clone the Repository**: 

   ```bash
   git clone https://github.com/MohamedWElteir/Infix-to-Postfix--Expression-Evaluator.git
2. **Compile and run the project**: Use a java compiler like `javac` to compile all `.java` files under the `src` directory.

   ```bash
   javac src/**/*.java
   ```
3. **Run the Application**: Execute the main class to start the GUI application.

   ```bash
   java -cp src Main.Main
   ```
4. **Enter an Expression**: Type the infix or postfix expression in the provided text field.

5. **Choose an Operation**: Select "Infix to Postfix" or "Expression Evaluation".

6. **Click Perform**: The result will be displayed in the text area below the input field.

## Project Structure

- **`src/Main`**
  - `Main.java`: The main entry point of the application, implementing the GUI and handling user interactions.
  - `MainTest.java`: Contains unit tests for the main functionality.
  
- **`src/Operations`**
  - `Evaluate.java`: Contains the methods for evaluating postfix expressions.
  - `InfixToPostfix.java`: Contains the logic for converting infix expressions to postfix notation.

- **`src/Queue`**
  - `Queue.java`: Interface for queue operations.
  - `Queue_Array.java`: Array-based implementation of the queue.
  - `Queue_Linked.java`: Linked list-based implementation of the queue.
  
- **`src/Stack`**
  - `Stack.java`: Interface for stack operations.
  - `Stack_Array.java`: Array-based implementation of the stack.
  - `Stack_Linked.java`: Linked list-based implementation of the stack.

## Example Usage

- **Input**: Infix Expression: `3 + 4 * 2 / ( 1 - 5 )`
- **Output**: Postfix Expression: `3 4 2 * 1 5 - / +`

- **Input**: Postfix Expression: `3 4 2 * 1 5 - / +`
- **Output**: Evaluation Result: `1`

## Requirements

- Java Development Kit (JDK) 8 or higher

## Technical Details

### GUI Implementation

The GUI is built using Java Swing. It features:
- Radio buttons for selecting the operation (Infix to Postfix or Expression Evaluation).
- A text field for user input.
- A button to perform the operation.
- Labels to display instructions, results, and notes to the user.

### Core Operations

1. **Infix to Postfix Conversion**: Implemented in `InfixToPostfix.java` using the Shunting Yard algorithm.
2. **Expression Evaluation**: Implemented in `Evaluate.java` using a stack-based approach.

## Future Enhancements

- Add support for additional operators (e.g., exponentiation).
- Extend the GUI to include error handling and real-time feedback.
- Improve performance by optimizing the underlying data structures.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your improvements.

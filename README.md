# MiniBASIC Interpreter

First assignment for the course of "Metodologie di Programmazione" held by Roberto Navigli.

## Overview

The `MiniBASIC` class is a simple interpreter designed to execute basic programs written in a language similar to BASIC. It supports a limited set of data types, expressions, and instructions, allowing you to create and run basic scripts.

## Features

### Data Types

The `MiniBASIC` language supports three basic data types:

- **Boolean**: Represents a true/false value.
- **Positive Integer**: Represents non-negative whole numbers.
- **String**: Represents sequences of characters.

### Expressions

Expressions in `MiniBASIC` can be:

- **Constants**: Direct values like `5`, `true`, or `"hello"`.
- **Variables**: The language provides 10 variables (`$0` to `$9`). Variables can hold any type, and their type is determined by the expression assigned to them. For example:
  - `$1 = "hello"` assigns the STRING type to `$1`.
  - `$5 = 10` assigns the INTEGER type to `$5`.
- **Operations**:
  - **Addition**: Adding two expressions of the same type results in an expression of that type.
    - `"hello" + "!"` results in a STRING `"hello!"`.
    - `0 + 42` results in an INTEGER `42`.
    - `true + false` results in a BOOLEAN value representing the logical OR of the two values.
  - **Comparison**: Comparing two expressions results in a BOOLEAN expression.
    - `expression1 == expression2` checks for equality.
    - `expression1 <> expression2` checks for inequality.
    - For integers, the operators `>`, `<`, `<=`, and `>=` are also supported.

### Instructions

Each instruction in `MiniBASIC` must be written on a single line. The supported instructions are:

- **Print**: Outputs a variable or a string constant.
  - Example: `PRINT $3` or `PRINT "hello"`.
- **Assignment**: Assigns an expression to a variable.
  - Example: `$3 = 5 + 2`.
- **Conditional Execution**: Executes instructions based on a boolean expression.
  - Example: `IF <boolean expression> THEN instruction1 : instruction2 : ... [ELSE instruction1 : ...]`.
- **Iteration**: Repeats instructions while a boolean expression is true.
  - Example: `WHILE <boolean expression> DO instruction1 : ... : instructionN`.
- **Labeling**: Marks a position in the program with a label, which can be used for jumps.
  - Example: `start:`.
- **Jump (GOTO)**: Jumps to a labeled position in the program.
  - Example: `GOTO start`.
- **Comments**: A line beginning with `REM` is treated as a comment and is ignored by the interpreter.
  - Example: `REM This is a comment`.
- **End**: Ends the execution of the program.
  - Execution also ends when all instructions have been processed.

## Usage

### Running Programs with `MiniBASIC`

To use the `MiniBASIC` interpreter, create an instance of the `MiniBASIC` class and pass a script written in the `MiniBASIC` language to it for execution.

Example:

```basic
$0 = 5
$1 = 10
IF $0 < $1 THEN PRINT "Five is less than ten" ELSE PRINT "This won't be printed"
PRINT "Done"
END
```

2 main classes are used: `Programma` and `MiniBASIC` which can be found in `it/uniroma1/metodologie`

- **Loading Programs**: The `Programma.fromFile(file)` method is used to load BASIC scripts from the specified file paths.
- **Executing Programs**: The `MiniBASIC().esegui(program)` method is called to execute each instruction in `program`.
- **Handling Exceptions**: Any exceptions that occur during execution (such as `OperatoreNonTrovatoException` or `TipiIncopamtibiliException`) are caught and printed.

### Testing with the `Test` Class

The `Test` class is provided to demonstrate how the `MiniBASIC` interpreter can be used to execute various scripts. The class loads several example programs from the `prg` directory and executes them using the `MiniBASIC` interpreter.

example can be found in `it/uniroma1/metodologie/Test.java` and `it/uniroma1/metodologie/MiniBASICTest.java`

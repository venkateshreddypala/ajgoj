AlgoJ
A modern scaffolding project for practicing Data Structures & Algorithms (DSA) with both Java and Scala 3 in a functional programming style.
🌴 Overview
AlgoJ provides a fully configured environment for DSA practice with:

Hybrid Gradle/SBT build system
Java 21 support
Scala 3 with functional programming patterns
Comprehensive test infrastructure
IntelliJ IDEA integration

Perfect for interview preparation, competitive programming practice, or learning functional approaches to classic algorithms.
🚀 Getting Started
Prerequisites

JDK 21 or newer
Gradle 8.x (or use the included wrapper)
SBT 1.9.x
IntelliJ IDEA with Scala plugin (recommended)

Setup

Clone the repository:
bashCopygit clone https://github.com/yourusername/AlgoJ.git
cd AlgoJ

Initialize the project:
bashCopy./gradlew generateSbt
./gradlew build

Open in IntelliJ IDEA:

Select "Open or Import"
Choose the build.gradle.kts file
Open as a project



📁 Project Structure
CopyAlgoJ/
├── build.gradle.kts             # Gradle build configuration (Kotlin DSL)
├── settings.gradle.kts          # Gradle settings
├── build.sbt                    # Auto-generated SBT build file
├── project/
│   └── build.properties        # SBT version configuration
├── src/
│   ├── main/
│   │   ├── java/               # Java implementations
│   │   │   └── dsa/algorithms/
│   │   └── scala/              # Scala 3 implementations
│   │       └── dsa/algorithms/
│   └── test/
│       ├── java/               # Java JUnit tests
│       │   └── dsa/algorithms/
│       └── scala/              # Scala 3 ScalaTest tests
│           └── dsa/algorithms/
🔧 Working with the Project
Using Gradle
bashCopy# Compile everything
./gradlew compileScala

# Run tests
./gradlew test

# Generate SBT files
./gradlew generateSbt
Using SBT
bashCopy# Start the Scala REPL with your project classes
sbt console

# Continuous compilation (recompiles when files change)
sbt ~compile

# Run tests
sbt test

# Run a specific test
sbt "testOnly dsa.algorithms.SolutionSpec"
Using IntelliJ IDEA

Run/Debug configurations are automatically created
Use the Scala worksheet feature for quick experimentation
Use the "sbt shell" tool window for SBT commands

📚 Sample Problems
The project includes implementations of common DSA problems:

Two Sum: Find indices of two numbers that add to a target
Reverse String: Reverse a string (with imperative and functional approaches)
Maximum Subarray: Find contiguous subarray with largest sum (Kadane's algorithm)

🧠 Practice Workflow

Find a problem on LeetCode, HackerRank, or other platforms
Create a new method in the Solution class/object
Write test cases (including edge cases)
Implement your solution
Run tests to verify correctness
Optimize and refactor

🔬 Scala 3 Functional Patterns
Learn functional programming techniques by example:

Immutable data structures
Pattern matching
Higher-order functions
Tail recursion
Extension methods
Type-safe enumerations

💡 Contributing
Contributions are welcome! Feel free to:

Add more problem implementations
Improve build configuration
Add more documentation examples

📜 License
This project is licensed under the MIT License - see the LICENSE file for details.

Happy coding in the AlgoJ! 🦁🐯🐘
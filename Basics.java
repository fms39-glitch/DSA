/**
 * ============================================================================
 * COMPREHENSIVE JAVA BASICS & OOP GUIDE (Notes Format)
 * ============================================================================
 * 
 * 1. INTRODUCTION & SETUP
 * -----------------------
 * - Java Architecture:
 * Source Code (.java) -> Compiler (javac) -> Bytecode (.class) -> JVM ->
 * Machine Code
 * - JDK (Java Development Kit) = JRE + Development Tools (javac, debugging
 * tools, etc.)
 * - JRE (Java Runtime Environment) = JVM + Core Libraries
 * - JVM (Java Virtual Machine) = Executes the bytecode. Platform-dependent!
 * - "Write Once, Run Anywhere": Bytecode is platform-independent, but JVM is
 * platform-dependent.
 * 
 * 2. FLOW OF PROGRAMS
 * -------------------
 * - Flowcharts: Start/End (Oval), Input/Output (Parallelogram), Process
 * (Rectangle), Decision (Diamond)
 * - Pseudocode: Step-by-step plain text logic written before writing actual
 * code.
 * 
 * ============================================================================
 * 3. THEORETICAL DEEP DIVE: PRIMITIVE vs NON-PRIMITIVE DATATYPES
 * ============================================================================
 * Java is a strongly typed, statically typed language. Every variable must have
 * a declared type.
 * 
 * A) PRIMITIVE DATATYPES (8 Types)
 * - Definition: Basic building blocks of data manipulation. They are raw
 * values, NOT objects.
 * - Memory: Stored directly in the **Stack** memory (very fast access).
 * - Defaults: Have default values if declared as class-level variables (local
 * variables inside methods do not get defaults).
 * 
 * 1. byte : 1 byte (-128 to 127). Default: 0
 * 2. short : 2 bytes (-32,768 to 32,767). Default: 0
 * 3. int : 4 bytes (~ -2B to 2B). Default: 0 (Standard choice for integers)
 * 4. long : 8 bytes. Default: 0L
 * 5. float : 4 bytes. Default: 0.0f
 * 6. double : 8 bytes. Default: 0.0d (Standard choice for decimals)
 * 7. char : 2 bytes. Stores UNICODE characters (e.g., 'A'). Default: '\u0000'
 * 8. boolean : 1 bit of info (size not precisely defined). true/false. Default:
 * false
 * 
 * B) NON-PRIMITIVE DATATYPES (Reference Types)
 * - Definition: Objects or references to memory locations where data is stored.
 * - Memory: Actual data is stored in the **Heap** memory. The reference (memory
 * address) is stored in the **Stack**.
 * - Defaults: The default value for ANY reference type is `null`.
 * - Examples: String, Arrays, User-defined Classes, Interfaces.
 * 
 * C) TYPE CASTING
 * - Widening (Implicit): byte -> short -> int -> long -> float -> double
 * (Automatic, no data loss)
 * - Narrowing (Explicit): double -> float -> long -> int -> short -> byte
 * (Requires manual cast, e.g., `int x = (int) 9.99;` -> x becomes 9, decimal is
 * truncated).
 * 
 * ============================================================================
 * 4. THE STATIC KEYWORD
 * ============================================================================
 * The `static` keyword means a member belongs to the **CLASS itself**, rather
 * than to instances (objects) of the class.
 * - Static Variables: Shared among all objects of the class. Memory is
 * allocated only once when the class is loaded.
 * - Static Methods: Can be called without creating an object (using the class
 * name, e.g., `Math.max()`). They can ONLY directly access other static
 * members.
 * - Static Blocks: Executed exactly once when the class is loaded into the JVM.
 * Used to initialize static variables.
 */

public class Basics {

    // --- STATIC EXAMPLE ---
    static int globalCount = 0; // Shared across all potential instances of Basics

    // Static block runs before main() when the class is loaded
    static {
        System.out.println("1. Class is loaded. Static block runs first!");
        // OUTPUT: 1. Class is loaded. Static block runs first!
    }

    public static void main(String[] args) {

        // ====================================================================
        // 5. CONTROL FLOW (if-else, switch, loops)
        // ====================================================================
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor"; // Ternary Operator
        System.out.println("Status: " + status);
        // OUTPUT: Status: Adult

        // ====================================================================
        // 6. FUNCTIONS & SCOPE (Pass by Value)
        // ====================================================================
        // Java is STRICTLY Pass by Value.
        // - For primitives: A copy of the value is passed. Original is untouched.
        // - For objects/arrays: A copy of the REFERENCE is passed. Since both the
        // original and copy point to the same Heap memory, modifying the object
        // modifies it everywhere.

        int[] arr = { 1, 2, 3 };
        modifyArray(arr); // See helper method below
        System.out.println("Modified Array: " + java.util.Arrays.toString(arr));
        // OUTPUT: Modified Array: [99, 2, 3]

        // ====================================================================
        // 7. DSA PROBLEM (Applying Concepts BEFORE OOP)
        // ====================================================================
        // Problem: Binary Search. Find the index of a target in a sorted array.
        // This utilizes: Arrays, while loop, if-else if, variables, math, and a static
        // method.

        int[] sortedArray = { 2, 4, 6, 9, 11, 12, 14, 20, 36, 48 };
        int target = 36;
        int ansIndex = binarySearch(sortedArray, target);

        System.out.println("Binary Search Result index: " + ansIndex);
        // OUTPUT: Binary Search Result index: 8

        // ====================================================================
        // 8. DATA HANDLING (Strings & ArrayLists)
        // ====================================================================
        // Strings are Immutable (Stored in the String Pool inside the Heap)
        String s1 = "Kunal";
        String s2 = "Kunal";
        // s1 and s2 point to the SAME object in the String Pool to optimize memory.
        System.out.println("s1 == s2: " + (s1 == s2));
        // OUTPUT: s1 == s2: true

        s1 = s1 + " Kushwaha"; // Creates a NEW object, doesn't modify the original "Kunal"

        // StringBuilder is Mutable (Not thread-safe, but very fast for concatenations)
        StringBuilder sb = new StringBuilder("Data");
        sb.append(" Structures");
        System.out.println(sb.toString());
        // OUTPUT: Data Structures
    }

    // --- HELPER METHODS FOR SECTIONS 6 & 7 ---

    // Array is a reference type, so modifying it here modifies the original object
    // in the Heap.
    static void modifyArray(int[] nums) {
        nums[0] = 99;
    }

    // Classic Binary Search implementation
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // (start + end) / 2 might exceed the range of int in java if numbers are
            // massive
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1; // Target is in the left half
            } else if (target > arr[mid]) {
                start = mid + 1; // Target is in the right half
            } else {
                return mid; // Target found
            }
        }
        return -1; // Target not found
    }
}

/**
 * ============================================================================
 * 9. OBJECT-ORIENTED PROGRAMMING (OOP) - DEEP DIVE
 * ============================================================================
 * OOP maps real-world entities to code using Objects and Classes.
 * 
 * A) CLASSES & OBJECTS
 * - Class: A blueprint or template. It defines properties (fields/variables)
 * and behaviors (methods).
 * - Object: An instance of a class. Takes up physical memory in the Heap.
 * 
 * B) CONSTRUCTORS
 * - Special methods used to initialize objects when they are created using
 * `new`.
 * - Same name as the class, no return type.
 * - 'this' keyword: Represents the current object. Used to resolve ambiguity
 * between instance variables and method parameters of the same name.
 * 
 * C) THE FOUR PILLARS OF OOP
 * 
 * 1. ENCAPSULATION
 * - Wrapping data (variables) and code (methods) together into a single unit
 * (class).
 * - Data Hiding: Making variables `private` and providing `public`
 * getters/setters.
 * - Why? Security, control over data modification (e.g., stopping an age
 * variable from being set to -5).
 * 
 * 2. INHERITANCE
 * - A child class inherits properties and methods from a parent class.
 * - Keyword: `extends`.
 * - Why? Code reusability.
 * - 'super' keyword: Refers to the immediate parent class object. Used to call
 * parent constructors or methods.
 * - Note: Java does NOT support multiple inheritance of classes (to avoid the
 * Diamond Problem).
 * 
 * 3. POLYMORPHISM (Many forms)
 * - Compile-Time (Static) Polymorphism: Method Overloading
 * (Same method name, different parameter types/counts in the same class).
 * - Run-Time (Dynamic) Polymorphism: Method Overriding
 * (Child class provides a specific implementation of a method declared in the
 * parent class).
 * * Dynamic Method Dispatch: The call to an overridden method is resolved at
 * runtime based on the ACTUAL object type in the Heap, not the reference type
 * in the Stack.
 * 
 * 4. ABSTRACTION
 * - Hiding unnecessary implementation details and showing only the essential
 * features to the user.
 * - Abstract Classes (0 to 100% abstraction): Can have both abstract (no body)
 * and concrete methods. Cannot be instantiated.
 * - Interfaces (100% abstraction traditionally): Blueprint of a class. Used to
 * achieve multiple inheritance of behavior. Keyword: `implements`.
 * 
 * D) ACCESS MODIFIERS
 * - private : Accessible only within the SAME CLASS.
 * - default : Accessible only within the SAME PACKAGE. (If you don't write any
 * modifier).
 * - protected : Accessible within SAME PACKAGE + Subclasses in DIFFERENT
 * PACKAGES.
 * - public : Accessible from ANYWHERE.
 */

// ============================================================================
// OOP CODE EXAMPLES (Outputs documented in comments)
// ============================================================================

// 1. Inheritance & Polymorphism
class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    int doors;

    Car(String brand, int doors) {
        super(brand); // Calls the parent (Vehicle) constructor
        this.doors = doors;
    }

    // Method Overriding (Run-time Polymorphism)
    @Override
    void start() {
        System.out.println(brand + " car with " + doors + " doors is starting silently");
    }

    // Method Overloading (Compile-time Polymorphism)
    void start(String keyType) {
        System.out.println(brand + " car starting with " + keyType + " key");
    }
}

// 2. Encapsulation
class BankAccount {
    private double balance; // Data hidden

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// 3. Abstraction (Interfaces)
interface Drawable {
    void draw(); // Implicitly public abstract
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Demo class to show how the above OOP code runs
class OopDemo {
    public static void runDemo() {

        // --- Dynamic Method Dispatch Example ---
        // Reference type is Vehicle (Parent), but actual Object is Car (Child)
        Vehicle myVehicle = new Car("Tesla", 4);

        myVehicle.start();
        // OUTPUT: Tesla car with 4 doors is starting silently
        // Reason: Even though the reference is Vehicle, Java looks at the ACTUAL object
        // (Car)
        // in the Heap at runtime and calls its overridden method.

        // --- Encapsulation Example ---
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        System.out.println("Balance: " + acc.getBalance());
        // OUTPUT: Balance: 500.0
    }
}

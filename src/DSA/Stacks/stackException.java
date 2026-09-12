package DSA.Stacks;

// ============================================================
// CUSTOM EXCEPTION CLASS
// Extends Java's built-in Exception class
// Used to throw meaningful errors from Stack operations
//
// WHY CUSTOM EXCEPTION?
//   Instead of returning -1 or null on error (bad practice),
//   we throw a descriptive exception — cleaner, more professional
// ============================================================

public class stackException extends Exception {

    public stackException(String message){           // Constructor: takes a message and passes it to parent Exception
        super(message);                              // Calls Exception(String message)
    }
}










// ============================================================
// HOW IT WORKS:
//
// When you do: throw new stackException("Cannot pop from an empty stack!!")
//
//   1. stackException(message) is called
//   2. super(message) calls Exception("Cannot pop from an empty stack!!")
//   3. Java stores that message internally
//   4. Caller catches it: catch(stackException e) { e.getMessage() }
//
// RESULT: "Cannot pop from an empty stack!!" is printed/handled
// ============================================================
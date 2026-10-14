# Object-Oriented Programming in Java — Lab 7: Exception Handling

**Author:** Divine Mark Makhomeya  
**Registration Number:** H250333E  
**Course:** Object Oriented Programming  

This repository contains my solutions for **Lab 7** of the OOP in Java lab manual.
The lab covers the exception hierarchy, checked vs unchecked exceptions,
try/catch/finally, custom exceptions, try-with-resources, and exception chaining.

## Lab Objectives
- Explain the exception hierarchy and the difference between checked and unchecked exceptions.
- Use try, catch, finally, throw, and throws correctly.
- Create custom exceptions that carry useful information.
- Manage resources safely with try-with-resources.
- Write methods that fail predictably instead of leaving objects in a bad state.

## Exercises

### Exercise 1: Safe Division with `Scanner`
- Reads two integers from the user.
- Handles `InputMismatchException` for non-numeric input.
- Handles `ArithmeticException` for division by zero.
- Uses `finally` to close the `Scanner`.

**Sample Output (division by zero):**
Enter numerator: 10
Enter denominator: 0
Math error: cannot divide by zero
Done


### Exercise 2: Safe Array Access
- `safeGet(int[], int)` wraps array access in a `try` block.
- Catches `ArrayIndexOutOfBoundsException` and returns `-1` as a sentinel.
- Also demonstrates `NullPointerException` for a null array.

**Expected Output:**
data[0] = 10
data[4] = 50
Bad index 7: Index 7 out of bounds for length 5
data[7] = -1
Bad index -1: Index -1 out of bounds for length 5
data[-1] = -1
Array is null


### Exercise 3: `InvalidAgeException` (Checked)
- Custom checked exception carrying the invalid age.
- `validateAge(int)` throws it for values outside 0..120.

**Expected Output:**
Age 25 is valid
Rejected: Age -5 is outside the valid range 0..120 (invalid value: -5)
Rejected: Age 130 is outside the valid range 0..120 (invalid value: 130)
Age 0 is valid
Age 120 is valid
Rejected: Age 121 is outside the valid range 0..120 (invalid value: 121)


### Exercise 4: `BankAccount.withdraw` Throws `InsufficientFundsException`
- Refactors Lab 3's `withdraw` so it throws a checked exception instead of returning `false`.
- The exception carries the shortfall amount.
- Discusses the trade-offs between returning `false` and throwing.

**Expected Output:**
After deposit: ACC-001 balance=750.0
After withdraw 100: ACC-001 balance=650.0
Failed: Cannot withdraw 5000.0; balance is 650.0
Short by: 4350.0
Final state: ACC-001 balance=650.0


**Trade-off summary:**

| Aspect | Return `false` | Throw exception |
|---|---|---|
| Caller must handle? | No | Yes (checked) |
| Carries data? | No | Yes (shortfall) |
| Best for | Routine, expected outcomes | Outcomes that must not be ignored |

### Exercise 5: `return` inside `try`, `print` inside `finally`
- Demonstrates that `finally` runs **before** the method actually returns.
- Warns against `return` inside `finally`, which discards the original return value.

**Expected Output:**
try: about to return 1
finally: still runs before the return
Returned value: 1

## Files
- `SafeDivide.java` — Exercise 1
- `ArrayAccess.java` — Exercise 2
- `InvalidAgeException.java` + `AgeValidator.java` — Exercise 3
- `InsufficientFundsException.java` + `BankAccount.java` — Exercise 4
- `FinallyVsReturn.java` — Exercise 5



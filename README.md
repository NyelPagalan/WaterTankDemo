# Water Tank System

A simple Java program that models a water tank as a **stack** (Last-In, First-Out). Each "bucket" of water is poured onto the top of the tank and can only be drained from the top, using an array and a `top` index.

## Features

- Two constructors: a default tank (5 buckets) and a custom tank with a name and capacity
- Pour water into the tank, with **overflow** detection when it is full
- Drain water from the tank, with **underflow** detection when it is empty
- Peek at the top bucket without removing it
- Count the buckets and calculate the total liters stored

## Project Structure

```
waterTank/
└── WaterTankDemo.java   # Contains WaterTank and the nested WaterTankDemo (main)
```

The file declares `package waterTank;` and holds the `WaterTank` class, with the `WaterTankDemo` class nested inside it as a `public static` class.

## Class Overview

### Fields

| Field    | Type     | Description                                       |
|----------|----------|---------------------------------------------------|
| `name`   | `String` | Name of the tank                                  |
| `bucket` | `int[]`  | Array that stores the liters in each bucket       |
| `top`    | `int`    | Index of the top bucket (`-1` when empty)         |

### Constructors

| Constructor                         | Description                                          |
|-------------------------------------|------------------------------------------------------|
| `WaterTank()`                       | Creates a "Standard Tank" that holds 5 buckets       |
| `WaterTank(String name, int capacity)` | Creates a named tank with the given bucket capacity |

### Methods

| Method            | Returns   | Description                                                        |
|-------------------|-----------|--------------------------------------------------------------------|
| `pour(int liters)`| `void`    | Adds a bucket on top. Prints an overflow message if the tank is full |
| `drain()`         | `int`     | Removes and returns the top bucket. Returns `0` with an underflow message if empty |
| `checkTop()`      | `int`     | Returns the top bucket's liters without removing it (`0` if empty) |
| `isEmpty()`       | `boolean` | `true` if the tank has no buckets                                  |
| `bucketCount()`   | `int`     | Number of buckets currently in the tank                            |
| `totalLiters()`   | `int`     | Sum of the liters in all buckets                                   |

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Compile and Run

From the folder that contains `WaterTankDemo.java`:

```bash
# Compile
javac -d out WaterTankDemo.java

# Run (the demo class is nested, so the $ is required)
java -cp out 'waterTank.WaterTank$WaterTankDemo'
```

On Windows Command Prompt, use double quotes instead:

```cmd
java -cp out "waterTank.WaterTank$WaterTankDemo"
```

If you are using an IDE (IntelliJ IDEA, Eclipse, NetBeans), open the file and run the `main` method inside `WaterTankDemo`.

## What the Demo Does

1. **Standard Tank**: pours 10L, 20L and 15L, checks the top bucket, drains once, then prints the bucket count and total liters.
2. **Mini Tank** (capacity 3): pours 5L, 10L, 15L, then tries to pour 20L, which triggers an **overflow**. It then drains four times, and the last drain triggers an **underflow**.

## Sample Output

```
========================================
           WATER TANK SYSTEM
========================================

========== STANDARD TANK ================
Standard Tank created no-argument constructor
Poured 10L into Standard Tank
Poured 20L into Standard Tank
Poured 15L into Standard Tank
----------------------------------------
Top bucket: 15L
Drained 15L from Standard Tank
Buckets left: 2
Total water: 30L

============== MINI TANK ===============
Mini Tank: Holds 3 buckets.
Poured 5L into Mini Tank
Poured 10L into Mini Tank
Poured 15L into Mini Tank
OVERFLOW! Mini Tank is full. 20L spilled on the floor!
----------------------------------------
Top bucket: 15L
Buckets: 3
Total water: 30L

----------- DRAINING MINI TANK ----------
Drained 15L from Mini Tank
Drained 10L from Mini Tank
Drained 5L from Mini Tank
UNDERFLOW! Mini Tank is empty.
----------------------------------------
Is the tank empty? true
Buckets left: 0
Total water: 0L
========================================
             PROGRAM END
========================================
```

## Concepts Demonstrated

- Encapsulation (private fields, public methods)
- Constructor overloading
- Stack operations (push, pop, peek) implemented with a plain array
- Overflow and underflow handling
- Nested static classes

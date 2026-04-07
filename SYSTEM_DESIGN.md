# 🏗️ System Design – In-Memory Cache with TTL Lite

## 📌 Overview

This document describes the **system design and architecture** of the In-Memory Cache with TTL Lite project.

The system is designed to simulate a simplified version of real-world caching systems like Redis, focusing on **fast data access, expiration handling, and performance monitoring**.

---

## 🎯 Design Goals

* ⚡ Fast data access (O(1) operations)
* ⏳ Efficient TTL-based expiration
* 📊 Performance tracking (Hits & Misses)
* 🔍 Visibility through reporting
* 🧠 Simple and scalable design

---

## 🧱 High-Level Architecture

```text
User Input (Commands)
        ↓
Command Parser
        ↓
Cache Engine (Core Logic)
        ↓
----------------------------------
|  Storage Layer (HashMap)        |
|  Time Manager (currentTime)     |
|  Stats Tracker (hits/misses)    |
----------------------------------
        ↓
Output Formatter
        ↓
Structured Output (JSON-like)
```

---

## 🔧 Components

### 1. Command Parser

* Reads input line-by-line
* Splits command into parts
* Identifies operation (SET, GET, DELETE, etc.)

---

### 2. Cache Engine (Core)

Handles all operations:

| Command | Function                   |
| ------- | -------------------------- |
| SET     | Store data with TTL        |
| GET     | Retrieve data              |
| DELETE  | Remove key                 |
| STATS   | Return performance metrics |
| PASS    | Simulate time              |
| REPORT  | Show valid keys            |

---

### 3. Storage Layer

* Implemented using **HashMap**
* Structure:

```
key → Node(value, expiry)
```

---

### 4. Node Structure

Each cache entry contains:

```
value → stored data  
expiry → expiration timestamp  
```

---

### 5. Time Manager

* Maintains simulated time:

```
currentTime
```

* Updated using:

```
PASS command
```

---

### 6. Stats Tracker

Tracks:

* Hits → successful GET
* Misses → failed GET

Used for:

```
STATS command
```

---

### 7. Output Formatter

* Converts responses into:

```
[{"key":["value"]}]
```

---

## 🔄 System Workflow

### Step-by-Step Flow

1. User enters command
2. Command is parsed
3. Cache Engine executes logic
4. Storage/Time/Stats updated
5. Result is formatted
6. Output printed

---

## ⏳ TTL Design (Key Concept)

### Expiry Calculation:

```
expiry = currentTime + ttl
```

### Validation:

```
if currentTime <= expiry → valid
else → expired
```

---

## 🧠 Expiration Strategy

### Lazy Expiration (Used)

* Keys are checked only when accessed
* Expired keys are removed during GET/REPORT

### Why Lazy?

* Simple implementation
* No extra background threads
* Efficient for small systems

---

## 📊 Performance Analysis

| Operation | Time Complexity      |
| --------- | -------------------- |
| SET       | O(1)                 |
| GET       | O(1)                 |
| DELETE    | O(1)                 |
| STATS     | O(1)                 |
| PASS      | O(1)                 |
| REPORT    | O(n log n) (sorting) |

---

## 📦 Data Flow Example

### Input:

```
SET a 1 100
PASS 50
GET a
```

### Flow:

```
SET → store (expiry = 100)
PASS → currentTime = 50
GET → valid → return 1
```

---

## 🧩 Design Decisions

### Why HashMap?

* Fast access (O(1))
* Simple implementation

---

### Why Node Class?

* Stores both value + expiry
* Keeps logic clean

---

### Why Simulated Time?

* No dependency on system clock
* Fully controlled testing

---

## ⚠️ Limitations

* No multi-threading support
* No persistence (data lost on restart)
* No eviction policy (like LRU)

---

## 🚀 Future Improvements

* 🔥 LRU Cache (LinkedHashMap / DLL)
* ⚡ Multi-threaded support
* 💾 Persistent storage (Database / File)
* 🌐 REST API (Spring Boot)
* 📊 Monitoring dashboard

---

## 💡 Real-World Mapping

| This Project | Real Systems    |
| ------------ | --------------- |
| HashMap      | Redis Key Store |
| TTL          | Redis EXPIRE    |
| STATS        | Cache Metrics   |
| REPORT       | KEYS / SCAN     |

---

## 📌 Conclusion

This system demonstrates how a cache can be designed using simple yet powerful concepts like HashMap, TTL, and lazy expiration.

It provides a strong foundation for understanding **backend systems, caching strategies, and scalable architecture design**.

# 🏗️ Architecture Diagram – In-Memory Cache with TTL Lite

## 📌 Overview

This diagram represents the internal working of the cache system, showing how commands flow through different components.

---

## 🔷 High-Level Architecture (ASCII Diagram)

```text
+----------------------+
|      User Input      |
| (SET, GET, DELETE)   |
+----------+-----------+
           |
           v
+----------------------+
|   Command Parser     |
|  (Split & Identify)  |
+----------+-----------+
           |
           v
+------------------------------+
|       Cache Engine           |
|------------------------------|
|  • SET / GET / DELETE        |
|  • TTL Logic                 |
|  • STATS Tracking            |
|  • REPORT Generation         |
+----------+-------------------+
           |
           v
+--------------------------------------+
|           Core Components            |
|--------------------------------------|
|  HashMap (Storage Layer)             |
|  key → Node(value, expiry)           |
|                                      |
|  Time Manager (currentTime)          |
|                                      |
|  Stats Tracker (hits / misses)       |
+----------+---------------------------+
           |
           v
+----------------------+
|   Output Formatter   |
| (JSON-like format)   |
+----------+-----------+
           |
           v
+----------------------+
|     Final Output     |
+----------------------+
```

---

## 🔶 Component Explanation

### 🔹 Command Parser

* Reads input line-by-line
* Splits command into parts
* Identifies operation type

---

### 🔹 Cache Engine

Handles all operations:

* SET → store key-value with TTL
* GET → retrieve value (with expiry check)
* DELETE → remove key
* STATS → return performance metrics
* PASS → simulate time
* REPORT → return valid keys

---

### 🔹 Storage Layer (HashMap)

```text
key → Node(value, expiry)
```

* O(1) average access time
* Stores all cache entries

---

### 🔹 Node Structure

```text
value  → actual data  
expiry → expiration timestamp  
```

---

### 🔹 Time Manager

* Maintains:

```text
currentTime
```

* Updated using:

```text
PASS command
```

---

### 🔹 Stats Tracker

Tracks:

```text
hits   → successful GET  
misses → failed GET  
```

---

### 🔹 Output Formatter

Formats output into:

```text
[{"key":["value"]}]
```

---

## 🔄 Data Flow Example

### Input:

```text
SET a 1 100
PASS 50
GET a
```

### Flow:

```text
SET → store (expiry = 100)
PASS → currentTime = 50
GET → valid → return 1
```

---

## ⏳ TTL Logic (Core Concept)

```text
expiry = currentTime + ttl
```

Validation:

```text
if currentTime <= expiry → valid
else → expired
```

---

## 📊 Complexity Overview

| Operation | Complexity |
| --------- | ---------- |
| SET       | O(1)       |
| GET       | O(1)       |
| DELETE    | O(1)       |
| STATS     | O(1)       |
| PASS      | O(1)       |
| REPORT    | O(n log n) |

---

## 🔷 Mermaid Diagram (GitHub Visual)

```mermaid
flowchart TD
    A[User Input] --> B[Command Parser]
    B --> C[Cache Engine]

    C --> D[HashMap Storage]
    C --> E[Time Manager]
    C --> F[Stats Tracker]

    D --> G[Node (value + expiry)]

    C --> H[Output Formatter]
    H --> I[Final Output]
```

---

## 🚀 Summary

This architecture demonstrates how a simple system can be designed using:

* Efficient data structures
* Time-based logic
* Modular components

It provides a strong foundation for building real-world caching systems like Redis.

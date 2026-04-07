# 📌 In-Memory Cache with TTL Lite – Problem Statement

## 🧠 Overview

The objective of this project is to design and implement a **lightweight in-memory key-value cache system** that mimics core functionalities of real-world caching systems such as Redis.

The system should efficiently store, retrieve, and manage data using fundamental data structures, while also supporting advanced features like expiration and performance tracking.

---

## 🎯 Core Functional Requirements

### 1. Basic Storage (SET & GET)

* Implement a mechanism to store key-value pairs
* Ensure fast retrieval of stored data

**Commands:**

* `SET [key] [value]` → Stores value for the key
* `GET [key]` → Retrieves value if exists, else returns `NULL`

---

### 2. Data Management (DELETE)

* Support removal of keys from the cache
* Maintain data consistency after deletion

**Command:**

* `DELETE [key]`

  * If key exists → return `DELETED`
  * If key does not exist → return `NOT_FOUND`

---

### 3. Performance Monitoring (STATS)

* Track cache efficiency using:

  * Hits (successful GET operations)
  * Misses (failed GET operations)

**Command:**

* `STATS` → Returns output in format:

```
H:[count] M:[count]
```

---

### 4. Expiration (TTL – Time-To-Live)

* Each key can have an expiration time
* Automatically invalidate expired keys

**Command:**

* `SET [key] [value] [ttl_ms]`

**Behavior:**

* Key expires after TTL duration
* Expired keys return `NULL` when accessed
* Expired entries are removed using lazy deletion

---

### 5. Time Simulation (PASS)

* Simulate time progression within the system

**Command:**

* `PASS [ms]`

**Behavior:**

* Advances internal system time
* Affects expiration logic of stored keys

---

### 6. Reporting (REPORT)

* Provide a snapshot of active keys

**Command:**

* `REPORT`

**Behavior:**

* Return all non-expired keys
* Keys must be sorted alphabetically
* Format:

```
[key1,key2,...]
```

---

## ⚙️ Functional Flow

The system processes commands line-by-line:

1. Read input command
2. Parse command and arguments
3. Execute corresponding operation
4. Update internal state (cache, time, stats)
5. Store output
6. Print results in JSON-like format

---

## 📊 Expected Output Format

All outputs must follow:

```
[{"key":["output1"]},{"key":["output2"]},...]
```

---

## 🧩 Concepts Used

* HashMap (for efficient key-value storage)
* Object-Oriented Programming (Node structure for TTL)
* Time simulation logic
* Lazy expiration strategy
* Sorting algorithms
* String parsing and formatting

---

## ⚡ Key Features

* O(1) average time complexity for operations
* Efficient in-memory storage
* Time-based data expiration
* Performance tracking (hits/misses)
* Dynamic reporting of active keys

---

## 🚀 Goal

To build a scalable and efficient in-memory cache system demonstrating:

* Fast data access
* Controlled data lifecycle
* Performance monitoring
* Real-world system design fundamentals

---

## 💡 Real-World Relevance

This system simulates core concepts used in:

* Redis
* Memcached
* Backend APIs
* Distributed systems
* High-performance web applications

---

## 📌 Conclusion

The "In-Memory Cache with TTL Lite" project provides a strong foundation in designing efficient data systems. It integrates storage, monitoring, and expiration mechanisms into a cohesive system, preparing developers for real-world backend and system design challenges.

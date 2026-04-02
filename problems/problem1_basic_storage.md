# 🧩 Problem 1: Basic Storage (SET & GET)

## 📌 Description

This problem focuses on implementing the **foundation of an in-memory cache system**.

The goal is to design a system that can efficiently:

* Store data using a unique key
* Retrieve data using that key

This forms the **core building block** of advanced caching systems like Redis.

---

## 🎯 Objective

* Implement basic key-value storage
* Support storing and retrieving data
* Handle missing keys properly

---

## ⚙️ Supported Commands

### 🔹 1. SET Command

Stores a value associated with a key.

**Syntax:**

```text
SET key value
```

**Behavior:**

* Adds the key-value pair into the cache
* If key already exists → overwrite value
* Output → `OK`

---

### 🔹 2. GET Command

Retrieves the value associated with a key.

**Syntax:**

```text
GET key
```

**Behavior:**

* If key exists → return value
* If key does not exist → return `NULL`

---

## 📊 Example

### Input:

```text
SET user_1 admin
GET user_1
GET user_2
```

### Output:

```text
OK
admin
NULL
```

---

## 📤 Output Format (System Requirement)

The system stores results in a structured JSON-like format:

```json
[{"key":["OK"]},{"key":["admin"]},{"key":["NULL"]}]
```

---

## 🧠 Concepts Used

* **HashMap** → for efficient key-value storage (O(1) average time complexity)
* **String Parsing** → to extract commands and arguments
* **Conditional Logic** → to handle different operations

---

## ⚡ Approach

1. Read input line-by-line
2. Split input into command and arguments
3. If command is:

   * `SET` → store key-value pair
   * `GET` → retrieve value or return NULL
4. Store output in a list
5. Print results in required format

---

## 🚀 Goal

To build a **fast, reliable, and scalable base layer** for the cache system, which will later be extended with:

* DELETE functionality
* Performance tracking (STATS)
* Expiration (TTL)
* Reporting (REPORT)

---

## 💡 Key Insight

This problem introduces the **core idea of caching systems**:

👉 Fast access using key-value mapping

Which is widely used in:

* Web applications
* Databases
* Distributed systems
* Backend services

---

## ✅ Summary

This step establishes the **foundation of the cache**, enabling efficient storage and retrieval — a critical requirement for all modern backend systems.


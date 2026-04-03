# 🧩 Problem 2: Data Management (DELETE)

## 📌 Description

This problem extends the basic in-memory cache system by introducing **data deletion functionality**.

In real-world cache systems, it is important to:

* Remove outdated or unnecessary data
* Manage memory efficiently
* Maintain accurate cache state

This problem ensures that the system can safely delete keys and handle invalid operations properly.

---

## 🎯 Objective

* Implement key deletion functionality
* Handle both existing and non-existing keys
* Maintain correct system state after deletion

---

## ⚙️ Supported Commands

### 🔹 1. SET Command

Stores a key-value pair.

```text
SET key value
```

---

### 🔹 2. GET Command

Retrieves the value associated with a key.

```text
GET key
```

---

### 🔹 3. DELETE Command

Removes a key from the cache.

**Syntax:**

```text
DELETE key
```

**Behavior:**

* If key exists → remove it and return `DELETED`
* If key does not exist → return `NOT_FOUND`

---

## 📊 Example

### Input:

```text
SET x 10
DELETE x
GET x
DELETE y
```

### Output:

```text
OK
DELETED
NULL
NOT_FOUND
```

---

## 📤 Output Format (System Requirement)

```json
[{"key":["OK"]},{"key":["DELETED"]},{"key":["NULL"]},{"key":["NOT_FOUND"]}]
```

---

## 🧠 Concepts Used

* **HashMap.remove()** → remove key-value pair
* **HashMap.containsKey()** → check existence
* **Conditional logic** → handle valid/invalid operations

---

## ⚡ Approach

1. Parse input line-by-line
2. Identify command type
3. If command is:

   * `SET` → store key-value pair
   * `GET` → return value or NULL
   * `DELETE` → remove key if exists
4. Return appropriate response
5. Store results in structured format

---

## 🚀 Goal

To enable **data lifecycle management**, allowing the system to:

* Clean up unused data
* Maintain consistency
* Prepare for advanced features like TTL

---

## 💡 Key Insight

Deletion is crucial in real systems for:

* Memory optimization
* Data correctness
* System reliability

---

## ✅ Summary

This problem enhances the cache system by adding **controlled data removal**, making it more practical and closer to real-world implementations.

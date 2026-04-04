# 🧩 Problem 3: Monitoring (Hits & Misses)

## 📌 Description

This problem enhances the cache system by introducing **performance monitoring**.

In real-world caching systems, it is important to measure efficiency.
This is done by tracking:

* **Hits** → Successful data retrievals
* **Misses** → Failed data retrievals

This feature helps evaluate how effectively the cache is being used.

---

## 🎯 Objective

* Track successful GET operations (hits)
* Track failed GET operations (misses)
* Provide statistics using a dedicated command

---

## ⚙️ Supported Commands

### 🔹 SET

Stores key-value pair

```text id="n8k2c4"
SET key value
```

---

### 🔹 GET

Retrieves value

```text id="x2v5hk"
GET key
```

* If key exists → HIT
* If key does not exist → MISS

---

### 🔹 DELETE

Removes key

```text id="3j9m8q"
DELETE key
```

---

### 🔹 STATS

Returns performance statistics

**Syntax:**

```text id="p8m1yk"
STATS
```

**Output Format:**

```text id="r3k9xv"
H:[hits] M:[misses]
```

---

## 📊 Example

### Input:

```text id="o7w4pl"
SET a 1
GET a
GET b
STATS
```

### Output:

```text id="q1s8vl"
OK
1
NULL
H:1 M:1
```

---

## 📤 Output Format (System Requirement)

```json id="k3p9zx"
[{"key":["OK"]},{"key":["1"]},{"key":["NULL"]},{"key":["H:1 M:1"]}]
```

---

## 🧠 Concepts Used

* Counters (variables for hits & misses)
* Conditional logic
* HashMap operations
* Performance tracking

---

## ⚡ Approach

1. Initialize:

   * `hits = 0`
   * `misses = 0`

2. On each GET:

   * If key exists → `hits++`
   * Else → `misses++`

3. On STATS:

   * Return formatted string with counts

---

## 🚀 Goal

To integrate **performance analytics** into the cache system, making it more practical and closer to real-world systems.

---

## 💡 Key Insight

Cache systems are judged by:

👉 **Hit Rate = Hits / (Hits + Misses)**

Higher hit rate → better performance

---

## ✅ Summary

This problem introduces **monitoring capabilities**, allowing the system to track efficiency and performance — a key feature in real backend systems.

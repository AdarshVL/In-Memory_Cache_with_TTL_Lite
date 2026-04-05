# 🧩 Problem 4: Expiration (Time-To-Live - TTL)

## 📌 Description

This problem introduces **Time-To-Live (TTL)** functionality into the cache system.

TTL allows each key to automatically expire after a specified duration.
This is a fundamental feature in real-world caching systems like Redis and Memcached.

---

## 🎯 Objective

* Assign an expiration time to each key
* Automatically invalidate expired keys
* Simulate time progression using commands

---

## ⚙️ Supported Commands

### 🔹 SET (with TTL)

Stores a key-value pair with expiration time.

**Syntax:**

```text id="ttl1"
SET key value ttl_ms
```

**Behavior:**

* Key is stored with expiry = currentTime + ttl
* After expiry → key becomes invalid

---

### 🔹 GET

Retrieves value only if key is not expired.

```text id="ttl2"
GET key
```

**Behavior:**

* If key exists AND not expired → return value
* If expired or not present → return `NULL`

---

### 🔹 PASS

Simulates time progression.

**Syntax:**

```text id="ttl3"
PASS time_ms
```

**Behavior:**

* Increases internal system time
* Does not immediately delete keys (lazy expiration)

---

## 📊 Example

### Input:

```text id="ttl4"
SET a 1 100
PASS 50
GET a
PASS 60
GET a
```

### Output:

```text id="ttl5"
OK
TIME_PASSED
1
TIME_PASSED
NULL
```

---

## 📤 Output Format

```json id="ttl6"
[{"key":["OK"]},{"key":["TIME_PASSED"]},{"key":["1"]},{"key":["TIME_PASSED"]},{"key":["NULL"]}]
```

---

## 🧠 Concepts Used

* Time simulation using variable (`currentTime`)
* Expiry calculation
* Lazy deletion strategy
* HashMap with custom object storage

---

## ⚡ Approach

1. Maintain a global time variable:

   ```
   currentTime = 0
   ```

2. On SET:

   ```
   expiry = currentTime + ttl
   ```

3. On GET:

   * If currentTime <= expiry → valid
   * Else → expired → remove key

4. On PASS:

   * Increase currentTime

---

## 🚀 Goal

To simulate **real-world cache expiration behavior**, ensuring that outdated data is not returned.

---

## 💡 Key Insight

TTL enables:

* Automatic data cleanup
* Memory optimization
* Fresh data handling

This is a **core feature in distributed systems**.

---

## ✅ Summary

This problem upgrades the cache into a **time-aware system**, capable of managing data lifecycle efficiently using expiration logic.

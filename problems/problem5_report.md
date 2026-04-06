# 🧩 Problem 5: Reporting (Cache Statistics Report)

## 📌 Description

This problem introduces a **reporting mechanism** to provide a snapshot of the current cache state.

The system should return all **valid (non-expired) keys** in a sorted format.

This feature helps in:

* Monitoring cache contents
* Debugging system behavior
* Understanding active data

---

## 🎯 Objective

* Identify non-expired keys
* Sort keys alphabetically
* Format output in a clean structure

---

## ⚙️ Supported Command

### 🔹 REPORT

Returns all valid keys in sorted order.

**Syntax:**

```text id="rpt1"
REPORT
```

**Behavior:**

* Include only keys that are NOT expired
* Sort keys alphabetically
* Return in format:

```text id="rpt2"
[key1,key2,...]
```

---

## 📊 Example

### Input:

```text id="rpt3"
SET b 1 100
SET a 2 100
REPORT
```

### Output:

```text id="rpt4"
OK
OK
[a,b]
```

---

## 📤 Output Format

```json id="rpt5"
[{"key":["OK"]},{"key":["OK"]},{"key":["[a,b]"]}]
```

---

## 🧠 Concepts Used

* HashMap traversal
* Filtering based on expiry
* Sorting using Collections.sort()
* String formatting

---

## ⚡ Approach

1. Iterate through all keys in cache
2. Check expiry:

   * If currentTime ≤ expiry → valid
3. Add valid keys to list
4. Sort list alphabetically
5. Join keys into formatted string

---

## 🚀 Goal

To provide a **clear and structured view of active cache data**, making the system more transparent and user-friendly.

---

## 💡 Key Insight

Reporting is essential in real systems for:

* Debugging
* Monitoring
* System analytics

---

## ✅ Summary

This problem completes the system by adding **visibility into cache state**, making it a fully functional and practical in-memory cache system.

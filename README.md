# 🚀 In-Memory Cache with TTL (Lite)

![Java](https://img.shields.io/badge/Language-Java-blue)
![Project](https://img.shields.io/badge/Project-System%20Design-green)
![Level](https://img.shields.io/badge/Level-Intermediate-orange)

---

## 📌 Project Overview

This project is a Java-based **in-memory key-value cache system** designed to simulate core functionalities of real-world caching systems like Redis.

It demonstrates how data can be **stored, retrieved, expired, and monitored efficiently** using fundamental data structures and system design principles.

---

## 🎯 Problem Statement

The goal is to build a high-performance cache system that supports:

* Fast key-value storage and retrieval
* Time-based expiration (TTL)
* Manual data deletion
* Performance tracking (hits & misses)
* Reporting of active keys

The system processes commands dynamically and returns results in a structured format.

---

## 🔥 Features

### ✅ Core Functionalities

* **SET** → Store key-value pair
* **GET** → Retrieve value
* **DELETE** → Remove key
* **PASS** → Simulate time
* **REPORT** → Show active keys

### ⏳ Advanced Features

* TTL (Time-To-Live) expiration
* Lazy deletion of expired keys
* Alphabetical sorting of keys
* JSON-like output formatting

---

## 🧠 Concepts Used

* HashMap (Key-Value Storage)
* Object-Oriented Programming (OOP)
* Time Simulation Logic
* Sorting Algorithms
* String Parsing
* System Design Basics

---

## ⚙️ How It Works

* Each key is stored with a value and expiry time
* A simulated time (`currentTime`) is maintained
* TTL is calculated as:

```
expiry = currentTime + ttl
```

* Expired keys are removed when accessed
* REPORT filters and displays only active keys

---

## 📥 Input Format

Commands are given line-by-line:

```text
SET key value ttl
GET key
DELETE key
PASS time
REPORT
```

---

## 📤 Output Format

All outputs follow this structure:

```json
[{"key":["output1"]},{"key":["output2"]}]
```

---

## 📊 Sample Input

```text
SET a 1 100
SET b 2 200
GET a
PASS 50
GET b
PASS 100
GET a
DELETE b
GET b
REPORT
```

---

## 📊 Sample Output

```json
[
 {"key":["OK"]},
 {"key":["OK"]},
 {"key":["1"]},
 {"key":["TIME_PASSED"]},
 {"key":["2"]},
 {"key":["TIME_PASSED"]},
 {"key":["NULL"]},
 {"key":["DELETED"]},
 {"key":["NULL"]},
 {"key":["[]"]}
]
```

---

## ▶️ How to Run

### Step 1: Compile

```bash
javac Solution.java
```

### Step 2: Run

```bash
java Solution
```

### Step 3: Provide Input

You can:

* Enter commands manually
* OR use file input:

```bash
java Solution < sample_input.txt
```

---

## 📁 Project Structure

```text
InMemory-Cache-TTL-Lite/
│
├── README.md
├── PROBLEM_STATEMENT.md
├── report.pdf
├── SYSTEM_DESIGN.md
├── sample_input.txt
├── ARCHITECTURE.md
│
├── problems/
│   ├── problem1_basic_storage.md
│   ├── problem2_delete.md
│   ├── problem3_stats.md
│   ├── problem4_ttl.md
│   └── problem5_report.md
│
├── solutions/
│   ├── solution1_basic_storage.java
│   ├── solution2_delete.java
│   ├── solution3_stats.java
│   ├── solution4_ttl.java
│   └── solution5_report.java
│
├── src/
    └── Solution.java   ← FINAL COMBINED CODE

```

---

## 📄 Project Report

The detailed project report includes:

* Introduction
* Methodology
* Implementation
* Results
* Challenges
* Conclusion

---

## 🧪 Test Cases Covered

* Basic SET/GET operations
* TTL expiration
* Time simulation (PASS)
* DELETE functionality
* REPORT generation

---

## 📈 Learning Outcomes

* Built a complete cache system using Java
* Understood TTL-based expiration logic
* Implemented performance tracking (hits/misses)
* Learned lazy deletion strategy
* Applied system design concepts

---

## 🚀 Future Enhancements

* LRU Cache (Eviction Policy)
* Multi-threading support
* Persistent storage (Database)
* REST API (Spring Boot)
* Web UI Dashboard

---

## 💼 Resume Highlight

> Developed a Java-based in-memory cache system with TTL expiration, performance tracking, and dynamic reporting, simulating core functionalities of Redis.

---

## 👨‍💻 Author

---
## Adarsh Lilhare 

🎓 B.Tech in Artificial Intelligence & Data Science

💼 AI & Data Science Student | 💻 Developer | 🌍 Open Source Contributor

📧 [Email](adarshlilhare5@gmail.com)

🐙 [GitHub](https://github.com/AdarshVL) 

🌐 [Portfolio](https://adarshlilhare.dev)

🔗 [LinkedIn](https://www.linkedin.com/in/adarsh-lilhare-b98a91290/)

---
## ⭐ Acknowledgement

This project was developed as part of the AICTE EduSkills Virtual Internship program, focusing on practical system design and backend development concepts.

---

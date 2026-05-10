# Java Socket Programming using Single-Threaded and Multi-Threaded Servers

This repository demonstrates the implementation of TCP Socket Programming in Java using two different server architectures:

- Single-Threaded Server
- Multi-Threaded Server

The project focuses on understanding how client-server communication behaves under sequential and concurrent request handling.

---

# Project Structure

```text
Threads/
│
├── SingleThread/
│   ├── Server.java
│   └── Client.java
│
├── MultiThread/
│   ├── Server.java
│   └── Client.java
│
└── README.md
```

---

# Single-Threaded Server

The single-threaded server handles one client connection at a time.

## Workflow

1. Server starts and listens on a specific port.
2. A client sends a connection request.
3. Server accepts the request.
4. Communication happens between server and client.
5. Connection closes.
6. Server waits for the next client.

## Characteristics

- Sequential execution
- One client processed at a time
- Simple implementation
- Blocking architecture

---

# Multi-Threaded Server

The multi-threaded server creates a separate thread for every connected client.

## Workflow

1. Server starts and listens on a specific port.
2. Multiple clients send requests simultaneously.
3. Server accepts connections continuously.
4. A new thread is created for every client.
5. Multiple clients are processed concurrently.

## Characteristics

- Concurrent execution
- Multiple clients handled simultaneously
- Improved responsiveness
- Better scalability

---

# Concepts Implemented

- Java Socket Programming
- TCP/IP Communication
- ServerSocket and Socket APIs
- BufferedReader and PrintWriter
- Multithreading in Java
- Runnable Interface
- Functional Interfaces using Consumer
- Concurrent Client Handling

---

# Load Testing

JMeter was used to test server behavior under concurrent client requests.

The implementation demonstrates:

- Sequential request processing in single-threaded architecture
- Parallel request handling in multi-threaded architecture
- Connection management using sockets
- Real-time client-server communication

---

# Running the Project

## Compile

```bash
javac Server.java
javac Client.java
```

## Run Server

```bash
java Server
```

## Run Client

```bash
java Client
```

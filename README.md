## Overview ##
This project demonstrates a secure communication system between a server and client using RSA encryption. The communication involves the exchange of encrypted messages to ensure confidentiality. The RSA algorithm is a widely used asymmetric key algorithm for secure data transmission.

## Features ##
- Secure Communication: The system ensures secure communication between a server and a client by encrypting and decrypting messages using the RSA algorithm.

- OTP Verification: The client-server interaction starts with a one-time password (OTP) verification for added security. The OTP is used to establish a secure connection between the server and client.

- Real-time Chat: The system supports real-time chat functionality where encrypted messages are exchanged between the server and client.

## Components ##
### Server ###
- Server GUI: The server has a graphical user interface (GUI) built with Java Swing, providing a user-friendly environment.

- RSA Key Generation: The server generates RSA public and private keys for secure communication.

- OTP Verification: The server requests OTP verification from the client, ensuring a secure connection.

- Message Decryption: The server decrypts incoming messages using its private key.
  
### Client ###
- Client GUI: Similar to the server, the client has a GUI built with Java Swing for user interaction.

- RSA Key Generation: The client generates RSA public and private keys for secure communication.

- OTP Verification: The client responds to the server's OTP request, establishing a secure connection.

- Message Encryption: The client encrypts outgoing messages using the server's public key.

## Usage ##
- Compile and Run: Compile and run the Server5.java and Client5.java files to start the server and client interfaces.

- OTP Verification: The client provides the OTP received to establish a secure connection.

- Real-time Chat: Use the chat window to send and receive encrypted messages securely.

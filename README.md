# Java Banking System

## Overview
This is a simple Java console application that simulates a basic banking system. It allows users to add customers, create savings and checking accounts, deposit and withdraw money, and display customer and account information.

## Features
- Add new customers with unique customer IDs
- Create Savings and Checking accounts with specific rules:
  - **SavingsAccount**: Has an interest rate and a minimum balance requirement
  - **CheckingsAccount**: Supports overdraft up to a specified limit
- Deposit and withdraw funds with validation
- Display all customers and their accounts
- Input validation for numeric fields and customer names

## Classes

### Account (abstract)
- Represents a generic bank account with an account number and balance.
- Abstract method `withdraw(double amount)` must be implemented by subclasses.
- Supports deposit and displaying account info.

### SavingsAccount
- Extends `Account`.
- Has an interest rate.
- Enforces a minimum balance of R100.
- Can calculate and add interest to the balance.

### CheckingsAccount
- Extends `Account`.
- Has an overdraft limit.
- Allows withdrawal up to the overdraft limit.

### Customer
- Represents a bank customer with a name and unique ID.
- Can hold multiple accounts.
- Displays customer and account information.

### Bank
- Holds a list of customers.
- Allows adding customers and displaying all customers.

### BankingApp
- Main application class with a console menu.
- Handles user input and interaction.
- Validates inputs including customer name and numeric values.

## How to Run

1. Make sure you have Java JDK 8 or higher installed.
2. Compile all `.java` files:
   ```bash
   javac *.java

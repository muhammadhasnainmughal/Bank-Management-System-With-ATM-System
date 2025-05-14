# Inventory-Management-System-With-MYSQL-Database

# 🛒 Inventory Management System

A simple inventory management system using **MySQL** and **Java** for managing products, categories, customers, employees, and orders.

---

## 📋 Features

- Manage Product Categories and Inventory.
- Register Customers and Track Balances.
- Process Orders and Detailed Order Items.
- Employee Login and Management System.
- Clean MySQL Schema with Relationships.

---

## 🧱 Database Schema Overview

- `category`: Product category list.
- `product`: Item details and stock.
- `customer`: Tracks customer info and payment balance.
- `employees`: Employee login and contact info.
- `orders`: Customer purchase records.
- `orderdetails`: Line items per order.

🧮 **Customer Balance = Debit - Credit**

---

## 🛠 Setup Instructions

### 💾 Database Setup (MySQL)

1. Open your MySQL client (e.g., MySQL Workbench or XAMPP/phpMyAdmin).
2. Create a new database:
   ```sql
   CREATE DATABASE inventory;
   USE inventory;
3. Run the `inventory_schema.sql` file (included in the repo) to create tables.

## ⚙ Java Requirements

✅ Java Development Kit (**JDK 17 or above**)  
✅ NetBeans IDE (**recommended for GUI**)  

## 📦 Technologies Used

- Java SE  
- MySQL 8.0  
- NetBeans IDE  
- Swing or JavaFX UI (if applicable)
   


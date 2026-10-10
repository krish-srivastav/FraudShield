
# FraudShield — AI-Powered Financial Transaction Fraud Detection System

## Overview
FraudShield is a Java-based financial transaction screening application that identifies potentially suspicious transactions using a rule-based detection mechanism.

## Features
- Checks transactions for suspicious activity.
- Flags transactions above ₹50,000 for review.
- Stores transaction records and their status in MySQL.
- Retrieves saved transactions through a REST API.
- Validates transaction amounts, types, and locations.
- Performs background audit logging.

## Technologies Used
- Java 17
- Spring Boot
- Spring MVC REST API
- JDBC
- MySQL
- Maven
- PowerShell for API testing

## How It Works
1. A client submits transaction details to the API.
2. The application checks the transaction amount.
3. Amounts above ₹50,000 are marked `SUSPICIOUS`; other valid amounts are marked `SAFE`.
4. The transaction and its status are saved to MySQL.
5. A background task logs the transaction audit information.

**Note:** The current detector uses a fixed rule-based threshold; it is not a trained machine-learning model.

## API Endpoints

### Check a transaction
`POST /api/transactions/check`

Example request:

```json
{
  "amount": 75000,
  "type": "TRANSFER",
  "location": "Delhi"
}
```

### Retrieve saved transactions
`GET /api/transactions`

### Health check
`GET /api/health`

## Database Setup
Create a MySQL database named `fraudshield` and a `transactions` table with the required columns:

- `id`
- `amount`
- `type`
- `location`
- `status`
- `created_at`

Configure the database connection in `backend/src/main/resources/application.properties`. Set the `DB_PASSWORD` environment variable to your local MySQL password before starting the application.

## Run Locally
From the `backend` directory:

```powershell
$env:DB_PASSWORD = Read-Host "Enter your MySQL password"
.\mvnw.cmd spring-boot:run
```

The API runs on port `8080` by default.

## Project Status
This project is under development as part of a Java academic project.

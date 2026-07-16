# Week 1 — PL/SQL Programming (Mandatory)

Oracle PL/SQL. Run in **SQL Developer**, SQL*Plus, or any Oracle instance
(Oracle XE is free). Run the scripts **in order**:

| Order | File | Covers |
|-------|------|--------|
| 1 | `00_schema_setup.sql` | Creates `Customers`, `Accounts`, `Loans`, `Employees` + sample rows |
| 2 | `01_control_structures.sql` | **Exercise 1** — loops + IF/THEN (age discount, VIP flag, due reminders) |
| 3 | `03_stored_procedures.sql` | **Exercise 3** — `ProcessMonthlyInterest`, `UpdateEmployeeBonus`, `TransferFunds` |

> Enable console output first with `SET SERVEROUTPUT ON;` (already included at the top of each script).

### Exercise 1 — Control Structures
Three anonymous blocks demonstrating cursor `FOR` loops and `IF` conditions:
apply a 1% loan-rate discount to customers over 60, flag customers with balance > $10,000
as VIP, and print reminders for loans due within 30 days.

### Exercise 3 — Stored Procedures
Three procedures showing `IN` parameters, DML, `SQL%ROWCOUNT`, exception handling and
`RAISE_APPLICATION_ERROR` (insufficient-funds guard in `TransferFunds`).

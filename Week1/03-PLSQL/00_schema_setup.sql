-- =====================================================================
-- Schema setup for the PL/SQL mandatory hands-on (Oracle).
-- Run this FIRST, then run 01_control_structures.sql and 03_stored_procedures.sql.
-- =====================================================================

-- Clean up (ignore errors on first run)
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Loans';     EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts';  EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customers'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    DOB          DATE,
    Balance      NUMBER(12,2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE',
    LastModified DATE DEFAULT SYSDATE
);

CREATE TABLE Accounts (
    AccountID   NUMBER PRIMARY KEY,
    CustomerID  NUMBER REFERENCES Customers(CustomerID),
    AccountType VARCHAR2(20),          -- e.g. 'SAVINGS', 'CURRENT'
    Balance     NUMBER(12,2),
    LastModified DATE DEFAULT SYSDATE
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    LoanAmount   NUMBER(12,2),
    InterestRate NUMBER(5,2),
    DueDate      DATE
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100),
    Department VARCHAR2(50),
    Salary     NUMBER(12,2)
);

-- Sample data ---------------------------------------------------------
INSERT INTO Customers (CustomerID, Name, DOB, Balance) VALUES (1, 'Ravi Kumar',  DATE '1958-04-10', 15000);
INSERT INTO Customers (CustomerID, Name, DOB, Balance) VALUES (2, 'Anita Sharma',DATE '1990-09-25',  8000);
INSERT INTO Customers (CustomerID, Name, DOB, Balance) VALUES (3, 'John Mathew', DATE '1955-01-15', 22000);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (1001, 1, 'SAVINGS', 15000);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (1002, 2, 'SAVINGS',  8000);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (1003, 3, 'CURRENT', 22000);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate) VALUES (5001, 1, 200000, 10.5, SYSDATE + 15);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate) VALUES (5002, 3, 500000,  9.0, SYSDATE + 45);

INSERT INTO Employees (EmployeeID, Name, Department, Salary) VALUES (1, 'Meena Iyer', 'IT',      60000);
INSERT INTO Employees (EmployeeID, Name, Department, Salary) VALUES (2, 'Arjun Rao',  'IT',      55000);
INSERT INTO Employees (EmployeeID, Name, Department, Salary) VALUES (3, 'Sara Ali',   'FINANCE', 70000);

COMMIT;

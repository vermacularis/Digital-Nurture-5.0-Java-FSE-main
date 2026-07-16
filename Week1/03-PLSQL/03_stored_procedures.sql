-- =====================================================================
-- Exercise 3: Stored Procedures  (run 00_schema_setup.sql first)
-- Enable output:  SET SERVEROUTPUT ON;
-- =====================================================================
SET SERVEROUTPUT ON;

-- ---------------------------------------------------------------------
-- Scenario 1: ProcessMonthlyInterest
-- Apply 1% interest to the balance of all SAVINGS accounts.
-- ---------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET    Balance = Balance + (Balance * 0.01),
           LastModified = SYSDATE
    WHERE  UPPER(AccountType) = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated with 1% interest.');
    COMMIT;
END;
/

-- ---------------------------------------------------------------------
-- Scenario 2: UpdateEmployeeBonus
-- Add a bonus percentage to salaries of employees in a given department.
-- ---------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET    Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE  UPPER(Department) = UPPER(p_department);

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) in ' || p_department ||
        ' received a ' || p_bonus_pct || '% bonus.');
    COMMIT;
END;
/

-- ---------------------------------------------------------------------
-- Scenario 3: TransferFunds
-- Transfer an amount between two accounts if the source has enough balance.
-- ---------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER(12,2);
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount ||
        ' from account ' || p_from_account || ' to ' || p_to_account || '.');
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: source account not found.');
        ROLLBACK;
END;
/

-- ---------------------------------------------------------------------
-- Demo calls
-- ---------------------------------------------------------------------
BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(1001, 1002, 5000);
END;
/

-- =====================================================================
-- Exercise 1: Control Structures  (run 00_schema_setup.sql first)
-- Enable output:  SET SERVEROUTPUT ON;
-- =====================================================================
SET SERVEROUTPUT ON;

-- ---------------------------------------------------------------------
-- Scenario 1: Apply a 1% discount to loan interest rates for customers
--             aged above 60.
-- ---------------------------------------------------------------------
BEGIN
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate,
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS age
        FROM   Loans l
        JOIN   Customers c ON c.CustomerID = l.CustomerID
    ) LOOP
        IF rec.age > 60 THEN
            UPDATE Loans
            SET    InterestRate = InterestRate - 1
            WHERE  LoanID = rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Loan ' || rec.LoanID ||
                ': age ' || rec.age || ' > 60 -> 1% discount applied.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ---------------------------------------------------------------------
-- Scenario 2: Promote customers with balance over $10,000 to VIP.
-- ---------------------------------------------------------------------
BEGIN
    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET    IsVIP = 'TRUE'
            WHERE  CustomerID = c.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || c.CustomerID ||
                ' set to VIP (balance = ' || c.Balance || ').');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ---------------------------------------------------------------------
-- Scenario 3: Print reminders for loans due within the next 30 days.
-- ---------------------------------------------------------------------
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.DueDate
        FROM   Loans l
        JOIN   Customers c ON c.CustomerID = l.CustomerID
        WHERE  l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name ||
            ', loan ' || rec.LoanID ||
            ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

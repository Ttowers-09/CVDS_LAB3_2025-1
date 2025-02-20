package edu.eci.cvds.tdd.library.loan;

/**
 * Enum representing the possible statuses of a loan.
 * This enum defines the two possible states a loan can have:
 * - ACTIVE: The loan is currently active, meaning the book has been borrowed and not yet returned.
 * - RETURNED: The loan has been completed, meaning the book has been returned.
 */
public enum LoanStatus {
    ACTIVE,  // The loan is active; the book has been borrowed but not returned yet.
    RETURNED // The loan is complete; the book has been returned.
}

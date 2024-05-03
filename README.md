# CapstoneOne_AccountingLedger

## Finance Management System

This project is a simple finance management system implemented in Java. It allows users to perform various financial transactions such as adding deposits, making payments, and viewing ledger reports.

### Project Structure

- **Main Class:** `Main.java`
    - Entry point of the program.
    - Displays the main menu and handles user input.
    - Allows users to add deposits, make payments, view ledger, and exit the program.
![CapstoneOne_AccountingLedger_HomeScreen.PNG](..%2FCapstoneOne_AccountingLedger_HomeScreen.PNG)

- **Transactions Class:** `Transactions.java`
    - Represents a financial transaction.
    - Contains attributes such as date, time, description, vendor, and amount.
    - Provides getters and setters for these attributes.

- **Deposit Class:** `Deposit.java`
    - Provides functionality to add deposit transactions.
    - Allows users to input deposit details and stores them in the transactions list:
![CapstoneOne_AccountingLedger_DepositChoice_WithInput.PNG](..%2FCapstoneOne_AccountingLedger_DepositChoice_WithInput.PNG)
    - Updates the transactions file with new deposit entries:
![CapstoneOne_AccountingLedger_TransactionsFile_WithDeposit.PNG](..%2FCapstoneOne_AccountingLedger_TransactionsFile_WithDeposit.PNG)

- **Payment Class:** `Payment.java`
    - Provides functionality to make payment transactions.
    - Allows users to input payment details and stores them in the transactions list:
![CapstoneOne_AccountingLedger_PaymentChoice_WithInput.PNG](..%2FCapstoneOne_AccountingLedger_PaymentChoice_WithInput.PNG)
    - Updates the transactions file with new payment entries:
![CapstoneOne_AccountingLedger_TransactionsFile_WithPayment.PNG](..%2FCapstoneOne_AccountingLedger_TransactionsFile_WithPayment.PNG)

- **Ledger Class:** `Ledger.java`
    - Provides functionality to display ledger reports.
    - Allows users to view: 
      - All transactions:
    ![CapstoneOne_AccountingLedger_LedgerMenu_AllChoice.PNG](..%2FCapstoneOne_AccountingLedger_LedgerMenu_AllChoice.PNG)
      - Deposits:
    ![CapstoneOne_AccountingLedger_LedgerMenu_DepositChoice.PNG](..%2FCapstoneOne_AccountingLedger_LedgerMenu_DepositChoice.PNG)
      - Payments: 
    ![CapstoneOne_AccountingLedger_LedgerMenu_PaymentChoice.PNG](..%2FCapstoneOne_AccountingLedger_LedgerMenu_PaymentChoice.PNG)
      - Generate reports based on:
      ![CapstoneOne_AccountingLedger_LedgerMenu_ReportsMenu.PNG](..%2FCapstoneOne_AccountingLedger_LedgerMenu_ReportsMenu.PNG)
        - Month to Date:
        ![CapstoneOne_AccountingLedger_ReportsMenu_MonthToDate.PNG](..%2FCapstoneOne_AccountingLedger_ReportsMenu_MonthToDate.PNG)
        - Previous Month:
        ![CapstoneOne_AccountingLedger_ReportsMenu_PreviousMonth.PNG](..%2FCapstoneOne_AccountingLedger_ReportsMenu_PreviousMonth.PNG)
        - Year to Date:
        ![CapstoneOne_AccountingLedger_ReportsMenu_YearToDate.PNG](..%2FCapstoneOne_AccountingLedger_ReportsMenu_YearToDate.PNG)
        - Previous Year:
        ![CapstoneOne_AccountingLedger_ReportsMenu_PreviousYear.PNG](..%2FCapstoneOne_AccountingLedger_ReportsMenu_PreviousYear.PNG)
        - Vendor names:
        ![CapstoneOne_AccountingLedger_ReportsMenu_SearchByVendor.PNG](..%2FCapstoneOne_AccountingLedger_ReportsMenu_SearchByVendor.PNG)

- **transactions.txt:**
    - Sample file containing pre-existing transactions data.
    - Used to initialize the transactions list when the program starts.
  ![CapstoneOne_AccountingLedger_TransactionsTxtFile.PNG](..%2FCapstoneOne_AccountingLedger_TransactionsTxtFile.PNG)

### Interesting Piece of Project:
- I had a hard time figuring out how to call on the Ledger menu from the Home Screen menu in the Main class. It turns out my mistake was not adding "transactions" to "Ledger.displayLedgerMenu(scanner);".


![CapstoneOne_AccountingLedger_InterestingSection_Part1.PNG](..%2FCapstoneOne_AccountingLedger_InterestingSection_Part1.PNG)


### Getting Started

1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA.
3. Run the `Main` class to start the program.
4. Follow the on-screen instructions to perform various financial transactions and view ledger reports.

### Dependencies

- Java Development Kit (JDK) 8 or higher

### Contributing

Contributions are welcome! Feel free to make improvements and submit pull requests.

### License

This project is licensed under the [MIT License](LICENSE).

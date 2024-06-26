﻿# CapstoneOne_AccountingLedger

## Finance Management System

This project is a simple finance management system implemented in Java. It allows users to perform various financial transactions such as adding deposits, making payments, and viewing ledger reports.

### Project Structure

- **Main Class:** `Main.java`
    - Entry point of the program.
    - Displays the main menu and handles user input.
    - Allows users to add deposits, make payments, view ledger, and exit the program.
![CapstoneOne_AccountingLedger_HomeScreen](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/beab7757-1c6b-443f-aebc-da623454406b)


- **Transactions Class:** `Transactions.java`
    - Represents a financial transaction.
    - Contains attributes such as date, time, description, vendor, and amount.
    - Provides getters and setters for these attributes.


- **Deposit Class:** `Deposit.java`
    - Provides functionality to add deposit transactions.
    - Allows users to input deposit details and stores them in the transactions list:
![CapstoneOne_AccountingLedger_DepositChoice_WithInput](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/01c77091-60c3-425d-9034-e3c98f7a8576)

    - Updates the transactions file with new deposit entries:
![CapstoneOne_AccountingLedger_TransactionsFile_WithDeposit](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/01142564-e632-4aca-9f1b-d633495ca971)



- **Payment Class:** `Payment.java`
    - Provides functionality to make payment transactions.
    - Allows users to input payment details and stores them in the transactions list:
![CapstoneOne_AccountingLedger_PaymentChoice_WithInput](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/fb50c53b-f2a2-4f87-b476-b27965003449)

    - Updates the transactions file with new payment entries:
![CapstoneOne_AccountingLedger_TransactionsFile_WithPayment](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/5739fb7a-ed5c-4a0f-a5cc-2a727d5ba30b)



- **Ledger Class:** `Ledger.java`
    - Provides functionality to display ledger reports:
 
        ![CapstoneOne_AccountingLedger_LedgerChoice](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/7c8a3773-10b8-444b-9b65-6d7641b96a30)

- **Allows users to view:**
    - All transactions:
  
       ![CapstoneOne_AccountingLedger_LedgerMenu_AllChoice](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/aedfd577-8c4e-4038-8bdc-4a2f5bafd263)

    - Deposits:
      
        ![CapstoneOne_AccountingLedger_LedgerMenu_DepositChoice](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/ed74600f-7f66-427b-9703-1e5d357c2556)

    - Payments:
      
        ![CapstoneOne_AccountingLedger_LedgerMenu_PaymentChoice](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/33f19d6d-cd93-406b-b0ec-077278b54316)

      - **Generate reports based on:**
        
          ![CapstoneOne_AccountingLedger_LedgerMenu_ReportsMenu](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/9225d153-57da-4b66-9908-e1b124ecb0b7)

          - Month to Date:
            
            ![CapstoneOne_AccountingLedger_ReportsMenu_MonthToDate](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/09aff008-b79f-4f28-ad40-9b1b880ac301)

          - Previous Month:
            
            ![CapstoneOne_AccountingLedger_ReportsMenu_PreviousMonth](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/6515eb4d-9cd7-4744-be68-caaa78866aa2)

          - Year to Date:
            
            ![CapstoneOne_AccountingLedger_ReportsMenu_YearToDate](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/7b629357-7529-4465-93c2-b00ad6bae661)

          - Previous Year:
            
            ![CapstoneOne_AccountingLedger_ReportsMenu_PreviousYear](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/71f12e3a-f257-40d4-b8c2-215c7176a304)

          - Vendor names:
            
            ![CapstoneOne_AccountingLedger_ReportsMenu_SearchByVendor](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/fb0bcf61-15b3-4b16-81e5-3a2dd9d54f76)


- **transactions.txt:**
    - Sample file containing pre-existing transactions data.
    - Used to initialize the transactions list when the program starts.
      
      ![CapstoneOne_AccountingLedger_TransactionsTxtFile](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/14e3ac35-44b5-42d2-b6df-7fa33c5d1e02)


### Interesting Piece of Project:
- I had a hard time figuring out how to call on the Ledger menu from the Home Screen menu in the Main class. It turns out my mistake was not adding "transactions" to "Ledger.displayLedgerMenu(scanner);".

![CapstoneOne_AccountingLedger_InterestingSection_Part1](https://github.com/SergJac/CapstoneOne_AccountingLedger/assets/166542383/aaee88e8-54f0-41f7-b88b-1dc826c95235)




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

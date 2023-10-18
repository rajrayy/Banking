# Banking
End to end banking system with ability to create, deposit and withdraw from an account. Pass time functionality built in to calculated interest accured and payments due.


The abstract class to define common behaviour of Savings, Checking and CD accounts is named 'Account.java'. AccountTest.java test this common system behaviour (mainly, deposit and withdraw functionality). Initialization test cases are included in individual test classes for all 3 accounts (SavingsTest.java, CheckingTest.java and CDTest.java).

I have used a hashmap as the data structure of choice to maintain bank accounts. The key of the map is a unique string id and the corresponding value is the associated account object of specified type. BankTest.java tests the create account functionality - some tests have 2 assertions to test exhaustively.


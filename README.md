# Eportfolio

Creating a program that allows a user to access and handle investments in stocks and or mutual funds. Users can buy, sell, update, or analyze 
their gains as well as search for certain investments. Additionally, the system supports case insensitive search. 


The limits of my solutions are that the investments must be stored in either stocks or mutual funds and can only be sold if the amount being 
inputted exists in an arraylist.

Test Plans 

On start up, system will read all investments from file if file name is provided through command line arguments.

Enter one of the following commands:
1 - BUY
2 - SELL
3 - UPDATE
4 - GAIN
5 - SEARCH
6 - EXIT

Enter "1", "2" , "3" , "4" , "5" , "6"

Following options are available for user.

User enters option 1, and then enters the type of investment (stock or mutual fund), symbol of the investment, quantity of investment and price 
of investment. If the investment is already in our system, then it's quantity and price will be updated, otherwise the system will ask you for name of the
investment and then save the investment as the new investment.

Enter "1", "2" , "3" , "4" , "5" , "6"
1
Investment type(stock or mutualfund)? : stock
Investment symbol? : ALFARDAN
Quantity? : 300
Price? : 500.45
Investment name? : Alfardan Exchange 

In this case ALFARDAN gets added  into the investment list and the bookvalue is calculated, the quantity and price is also added into the attributes 
for the investment array list. A Hashmap is also populated against each token of investment name.

User enters option 2, and then enters symbol, quantity and price for the investment to sell it.

Enter "1", "2" , "3" , "4" , "5" , "6"
2
Enter the investment symbol: ALFARDAN
Enter the price: 200.20
Enter quantity: 100

If the required quantity is available to sell then the system will sell it otherwise it will generate an error. Also the system will not accept negative
and zero values because price and quantity can't be negative or zero. If the user sells the whole quantity, then it will be removed from the system and it's search
related data in the hash map is also erased. 

User enters option 3 and then enters new price values for all existing individual investments. 
In this case all price values in attributes should be updated to the new prices inputted by the user.

User enters option 4 and then the system will print the total gain of all investments.

User enters option 5, and the system will ask you for the search criteria.
You can either search by symbol, by price range, or by name.
System has the capability to search by any key word that appears in the name of an investment. I implemented the fast searching using a Hashmap.

User enters option 6, and the system will save all investments if the file name has been provided through command line arguments, otherwise the system will
exit without writing to the file.

If I was to do this again I would be more careful about limitations and add better statements for users when they make a mistake or enter invalid 
input. This would make it an easier and better developed program for users. 

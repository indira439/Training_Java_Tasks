Develop Spring boot with spring data with view as Thymeleaf
Create Account table with accno(PK), name, amount -→ you can use the orm feature to create thetable using spring boot.
Then create Entity class as Account using @Entity annotation with accno(PK), name, amount etc
AccountRepository interface extends JpaRepositoryAccountService with methods ascreateAccount: condition amount must be > 1,000 and accno must be unique.

Deposit amount -→ you can deposit at a time less than 50,000 else you need to provide PANnumber. Pan card number only for reference. 
Display only message if we are going to deposit morethan 50,000 and don’t deposit.

Withdraw -→ maintain min 1,000 in account. 
If it doesn’t , this condition doesn’t withdrawn theamount

checkBalance : ask accno and display the balance.
AccountController --→ help to interface with view as thymeleaf.
View can be index.html or more than one view pages.


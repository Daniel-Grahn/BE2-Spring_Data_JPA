To start the SpringBoot you can start it with:
./ run.sh


//a (skapar en kund)
Create a new customer
http://localhost:8080/customer

//b (skapar en fordon)
Create a new vehicle
http://localhost:8080/vehicle

//c (Koppla en fordon till en kund)
Attach a vehicle to a customer
http://localhost:8080/attach

//d (returnera en lista av alla kunder med fordon)
Get customers that has a vehicle
http://localhost:8080/customers

//e (returnerar en lista av alla fordon)
???

//f (returnerar alla fordon med deras märke (brand))
Get vehicles with {id, registrationNumber, brand} by the customers id
http://localhost:8080/carsbrand

//g (tar kunden namn och returnerar id.)
Get the customerId by there name
http://localhost:8080/CustomerId
To run the Spring Boot application, simply use:
./run.sh

Make sure the script is executable:
chmod u+x run.sh

//a (skapar en kund)
Create a new customer
http://localhost:8080/customer
exempel: 
{
	"name": "Foo",
	"phoneNumber": "1234"
}

//b (skapar en fordon)
Create a new vehicle
http://localhost:8080/vehicle
exempel: 
{
	"registrationNumber": "abc123",
	"brand": "volvo"
}

//c (Koppla en fordon till en kund)
Attach a vehicle to a customer
http://localhost:8080/attach
exempel:
http://localhost:8080/attach?customerId=1&vehicleId=1


//d (returnera en lista av alla kunder med fordon)
Get customers that has a vehicle
http://localhost:8080/customers

//e (returnerar en lista av alla fordon)
Get a list with all the vehicles
(OBS!!! no customer is showed)
http://localhost:8080/vehicles


//f (returnerar alla fordon med deras märke (brand))
Get all the vehicles with a specific brand
http://localhost:8080/carsbrand
exempel:
http://localhost:8080/carsbrand?brand=volvo

//g (tar kunden namn och returnerar id.)
Get the customerId by there name
http://localhost:8080/CustomerId
exempel: 
http://localhost:8080/CustomerId?name=Foo
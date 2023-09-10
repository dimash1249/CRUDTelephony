# Tools and Technologies
* IntelliJ IDEA 2023.1.3
* pgAdmin 4 6.12
* Postman 10.17.7
* MongoDB Compass 1.39.4
* Spring Boot 3.1
* Java 17.0.8
* Gradle 8.3
* PostgreSQL 14

# How to set up or start project?
To start the project, you need to run the command using Git 
```git clone https://github.com/dimash1249/CRUDTelephony.git```
After cloning the repository, you need to open the folder in the IDE, for me this is IntelliJ IDEA. 
![image](https://github.com/dimash1249/CRUDTelephony/assets/86044980/8b847567-1544-4750-b6cb-8c5051353a12)

Since the type of packaging is jar and the project has a built-in server, we just need to click the green triangle to launch the application.

![image](https://github.com/dimash1249/CRUDTelephony/assets/86044980/53f4f3b4-4a73-4dec-acfc-3a78f92871d1)

After the launch, it will be written on which port the application was launched. By default, the server starts locally on port 8080. 
Next, you will need to go to the web browser and enter the URL ```http://localhost:8080/api/person-phones/by-id-or-phone-number/1```.

![image](https://github.com/dimash1249/CRUDTelephony/assets/86044980/3ae03eff-0aa3-4495-9384-ce8f82faa3bc)

For more detailed testing of the application, you need to use Postman. To do this, open HTTP requests saved in . 

# Methods in controllers
The application works with two PostgreSQL and MongoDB databases. Two controllers are implemented for correct operation:
* PostgreSQLPersonPhoneConntroller. The controller implements such methods:
  - ```public List<PostgreSQLPersonPhoneDto> getAllPersonPhones(@RequestBody Filter filter) { }```;
    - Takes as a parameter an object of ```Filter``` class which has attributes such as ```limit``` and ```offset```;
  - ```public ResponseEntity<PostgreSQLPersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") String idOrPhoneNumber) { }```;
    - Accepts ```id``` or ```phone number``` as a parameter;
  - ```public ResponseEntity<PostgreSQLPersonPhoneDto> updatePersonPhone(@PathVariable String id, @RequestBody PostgreSQLPersonPhoneDto postgreSQLPersonPhoneDto) { }```;
    - As a parameter, it takes ```id``` or ```phone number```, an object of ```PostgreSQLPersonPhoneDto``` class with updated data.
  - ```public ResponseEntity<String> deletePersonPhone(@PathVariable(name = "id") String id) { }```.
    - Accepts ```id``` or ```phone number``` as a parameter.
* MongoDBPersonPhoneControlle. The controller implements such methods:
  - ```public List<MongoDBPersonPhoneDto> getAll(@RequestBody Filter filter) { }```;
    - Takes as a parameter an object of ```Filter``` class which has attributes such as ```limit``` and ```offset```.
  - ```public ResponseEntity<MongoDBPersonPhoneDto> getByIdOrPhoneNumber(@PathVariable(name = "id") String id) { }```;
    - Accepts ```id``` or ```phone number``` as a parameter.
  - ```public ResponseEntity<MongoDBPersonPhoneDto> update(@PathVariable String id, @RequestBody MongoDBPersonPhoneDto mongoDBPersonPhoneDto) { }```;
    - As a parameter, it takes ```id``` or ```phone number```, an object of ```MongoDBPersonPhoneDto``` class with updated data.
  - ```public ResponseEntity<String> delete(@PathVariable String id) ```.
    - Accepts ```id``` or ```phone number``` as a parameter.

# HTTP requests in Postman



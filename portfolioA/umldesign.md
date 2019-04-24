# OO and UML Design
The following paragraphs describe the further details the components of the Class UML and Sequence UML Diagram

### Class UML Diagram

![image_name](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/portfolioA/Class%20UML.png)

The User class contains two subclasses Student and Lecturer which share the main attribute (includes email address, ID, password and department of faculty) and function(includes registration, login, booking and cancel)(details in user requirement as mentioned before). The difference is that there is an attendance system for students(details in black list as mentioned before). Moreover, the lecturer should be able to book more than one seat in order for teaching blocks.

The **MainForm** is the boundary class and like **LoginForm**, it is the main window. The **LoginForm** is the login entrance which omits the way of dealing interface and button. The **loginBO** is a logical function for login. The **IUserDAO** is an abstract data access interface which displays the function for user list in database. And the **UserDAO** achieves the function above in **IUserDAO** and omits the search and other functions. On the other hand, for register part, RegisterForm need to access database through **UserDTO**’s transfer function. Both **OracleUserDAO** and **userDAO** are subclass of **IUserDAO**, they have realization relationship with **IUserDAO**.

The user should register and login via form by using user interface. The *DAO* part allows data transfer between database and interface. When user trying to register a new account, the interface should be able to add the information into the database.When the user is trying to login with their account, the interface(findUserAcc&Pwd) should be able to query and compare the information from database.

The main booking interface should be able to make all function(includes Check User Number, update seat and equipment status and send confirmation email)(details in system requirement as mentioned before).

The reason we choose this static class UML diagram is that it helps us to build a basic idea of what we need to, get a start with database and also design our first sample of function for our project.


### Sequence UML Diagram

![image_name](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/portfolioA/Sequence%20UML.png)

This is the sequence UML diagram for our project. It describes a high-level workflow for our lab booking system. The design workflow is built from how we and the client agrees that the user workflow should be.

The student and admin has different types of access levels and control of the system, hence the operations of each function may differ.

Admin has the right to directly modify the status of seats and equipment. Users should follow the normal booking flow after they register and login. The confirmation email should be sent after the users confirm their booking. Both the admin and user can select the seats and time where the admin has more privileges in terms of how many seats can be booked at once. In addition, the admin can control the available number of equipments (may change later) and also delete/add/edit any user bookings. Once the booking has been canceled, the seat and equipment should be available again to users. The arrow to the right represent the data being POST (or sent) to the database and back-end whereas the left arrow represents the data that will be send/replied by back-end and to be displayed to the front-end for the user accordingly.

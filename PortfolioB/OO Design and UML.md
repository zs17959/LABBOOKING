# OO Design and UML 
### High Level Architecture Diagram
![
](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/PortfolioB/high%20level.png)

This high level architecture provides an overview of our entire system including the website and oracle cloud services, identifying the main components that would be developed for our project and its interface. It also expresses the connection between each individual clients/devices that will be connected to the server and our website along with how it is connected. It also expresses the fact that our web functionality also depends on the internet connection and server status. If the internet the client is connected to is not good/stable enough, the website may not be functioning as intended. This is similar to the status of Oracle Cloud where maintenance of cloud service or emergency offline process may affect our system.

## Class Diagrams:

![Entity (Classes)](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/PortfolioB/EntitySPE.png)

Because javascript and java sometimes different format, we decided to add the **AdminBooking** and **TempBooking** which changes some attributes in order to fit the information sent through the POST method to the controller. The main difference is that the the seatNo (seat Number) is a list in **AdminBooking** while a it is a string in the **TempBooking** since admin can book many seats at once. In addition, because HTML and _Thymleaf_ is better at displaying a String than a Java *LocalDateTime* , we decided to send the date and time as an Int and String then turn it into the correct format in the Controller instead.

The attributes of **Student** is similar to the ones displayed for input in the HTML and Thymeleaf, hence we did not use the same approach as **Booking**. However, we have the **Role** Class which is the attribute which defines if a user is the admin or normal user.

**Attendance** class is used specifically to send information in only the UCARD number of the student. Since attendance is a seperate function, it make sense

![Controller and Service](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/PortfolioB/BookingSPE.png)

In addition, we also have the diagram for all functions in the Controller and Service for Students and (Admin) Booking which are connected to the _CRUD_ repository.

## Sequence UML Diagram

![](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/PortfolioB/sequence%20diagram.png)

This is the sequence UML diagram for our project. It describes a high-level workflow for our lab booking system. The design workflow is built from how we and the client agrees that the user workflow should be.

The student and admin have different types of access levels and control of the system, hence the operations of each function may differ.

Admin has the right to directly modify the status of users and bookings, including blacklisting any users. Users should follow the normal booking flow after they register and login. The confirmation email should be sent after the users confirm their booking.

Both the admin and user can select the seats and time where the admin has more privileges in terms of how many seats can be booked at once. In addition, the admin can control the available number of equipments in the lab and also delete/add/edit any user bookings while the students can write a note to the admin and select equipments that they need for the session.

The arrow to the right represent the data being POST (or sent) to the database and back-end whereas the left arrow represents the data that will be send/replied by back-end and to be displayed to the front-end for the user accordingly.

In addition, users must record their attendance or they will be striked by the admin. Admin can manually remove or add strikes to any users.

Users can only record their attendance 10 minutes before the start time until the end of the session. Users can only delete their booking before their session begins. Users can also edit their name,last name, email and UCARD in Edituser function. In addition, users can also view their past bookings while the admin can see all the bookings and delete them. Users will be notified with an email after a booking is successful.


### Reflection of Modelling Choices

The High-Level Architecture diagram gives us a clear overall image of how each device,user and system works as a whole. By using the information from the diagram, we can know reflect and analyze in depth on the requirements of each specific element. For example, the user interface requirement of smartphones, laptop and tablet is that it must be scaled to the correct size.

Class Diagram gives us the connection between each Entity and what attributes should be changed in order to fit each class’s purpose. For example, the date in Booking Class must be change from Java LocalDateTime to String and Int in order to properly connect with the POST format and input from HTML and Thymeleaf.

Sequence UML Diagram shows us all the required functions for the whole system and shows how information flows between different functions and types of users. In addition, it is a diagram which we use as a standard to ask ourselves if we have done all of the required functions and if they work as intended. For example, only the Admin should be able to view all bookings while the users can only view their own bookings. This modelling helped us achieve our goal of completing the goal and functionality of the product.

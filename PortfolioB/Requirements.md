

## Requirements:

**StakeHolders**:

1. **Normal User** :
	- **Students**: The main user of this web-app. They can use only the main features, they can book a single seat in a time-slot on a certain day in the week and select equipment for that booking. They can also view their own bookings and register their attendance. They will be using this all the time.

	- **Lecturers**: Lecturers may also book the system as a single booking or inform the admin in order to block book a bay or the whole lab for certain time period. This is likely to be a rare occasion where a lecturer signs up with the system. They will most likely ask the admin to allocate the seats for them.


2. **Admin** (Lab Technician - Richard Walker) : The lab technician who will be using the project on a daily basis. They will be booking seats each week for set classes and will be the administrator of the system, they will be able to block book seats and can have any number of bookings. The admin can also manage the strikes of students and can remove any bookings, even a student.


**High Level Use Case Diagram:**
![](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/PortfolioB/high%20level.png)


**Non-Human Actors:**
We have one non-human actor, the server. If it fails, there is no backup server, so the application will go down and possibly data may be lost. We cannot control this as this is Oracle who we rely on.


**Goals:**
**1. Booking a seat (Primary / Core goal)**

_**Atomic goals/tasks**_
-   Log-in
-   Navigate to booking page
-   Booking slot details:
	-   Select date
	-   Select time    
	-   Select seat
	-   Select required extra equipment
    -   Add a note to the admin
-   Confirm   
-   Receive confirmation email

**Alternative Flow:** The user could do the above booking slot details in any order, (select date, time, seat, equipment). The user can also not select any equipment and instead write a note to the admin (optional) or alternatively both select equipements and write the note.

**Exceptional Flow:** The booking seat that the user has selected may become booked whilst they are booking it themselves. The website would not show that the seat is booked until the user confirms their seat, which would then display an error message saying the seat has been booked. At this point the user must then select either a different date and time, or seat. This is unlikely to happen often.



**Functional Requirements:**

-   System should only allow students to book one week in advance   
-   Students should be able to cancel their booking prior to time allocated    
-   Students should not be able to cancel it after the time    
-   Students must only be able to select one booking  
-   Time and date must be set according to opening and closing time of lab each day   
-   Confirmation email must match student's booking and description    
-   Seat labeling must match real seats location using a floor plan and matches the database information




**Non-functional Requirement:**

-   *Dependability*: The user must be able to book their time slot if it is available or must be able to book an alternative seat in that time slot if its unavailable, (parallel access should be solved).    
-   *Security*: Other than the admin, the system should not allow any users to edit their own id, email or other's bookings. This includes the exclusion of being able to login into other's account.
-   *Reliability*:  The system should be able to handle multiple user requests to the same booking page, and no two different users should be able to book the same seat. It is a first come first serve system and so the first person to book the seat should get the seat and the other user should be informed they have to select a different time or seat.  
-   *Scalability*: The system should be able to handle request from more than one user at any time.    
-   *Operation Constraints*: Database should be running/online at all time, meaning there must be a viable back-up system (which oracle provides one)  
-   *Usability*: The user should know, within a small time frame of a few seconds, what each button does and how to navigate through the web system, if there is confusion in beta testing, it should be fixed right away  
-   *Precision*: The precision of booking seat time slot, number, equipment should always match what user input to prevent failure in booking time (100% precise)


**2. Blacklisting**

_**Atomic goals/tasks**_
 - Student does not turn up for booking time slot
 - A strike is sent into their account and to admin table of names
 - If there are 3 strikes, the system will set blacklisted value of the account to True
 - The Student booking account is temporarily blocked and student cannot booking any slots
 - Student is sent an email to contact admin and set up a meeting

**Alternative Flow:** The student could notice that they have one or two strikes before they get the third and then go and talk to the admin and try to get the strikes removed if there is good enough reasoning. The student could also have forgotten their UCARD yet be in the lab and so would not be able to record their attendance. They would then have to go to the admin to make sure they are set as attended or remove the strike.

**Exceptional Flow:** The student doesn’t set up a meeting and admin must be the one who contacts them instead, or the student does not use the lab booking system and just walks in and takes a seat. This would cause problems for the admin.

**Functional Requirement:**
-   Admin must be able to delete/add strikes manually
-   Students can be given strike both automatically and manually

**Non-functional Requirement:**
-   *Security*: Only admin has the ability to unblacklist someone
-   *Efficiency*: Blacklisting happens automatically, so no manual blacklisting required by the admin

**3. Registering**

***Atomic Goals/Tasks***
- Student navigate to registration page
- Student Enter details as requested
- Student Register an account at home and leave the UCARD slot as blank
-  Scan UCARD at the lab
- Registration completed

**Alternative Flow:** The above goal steps is for a user registering via the website at home. They could alternatively be in the lab and use the tablet in the lab to sign up. They could then use the RFID scanner to scan their ucard and associate it with their account straight away instead of having to do it at a later date.

**Exceptional Flow:** Student will immediately get a strike because they did not bring their UCARD to the lab the first time and associate their UCARD with their account. They cannot register their attendance because they haven't finished registering their account.

**Functional Requirement:**
-   System should be able to provide a valid account for each individual student(to their UCARD)    
-   System must register the unique ID of UCARD each time it is scanned  
-   Registration and must be done on the website / tablet    
-   Students user ID should be strictly linked to their ID on university email address.
-   Password should be encrypted, so not stored in plaintext




**Non-Functional Requirement:**
-   *Security*: The users personal info must be accessed by them and them alone. The admin can also have access to all the users information apart from the ability to see their password.
-   *Security*: Students should use strong passwords but a unique password. They should not use their Bristol account password incase of a security leak / issue. Students should use their own UCARD for registration.


**4. Edit User Details**

***Atomic Goals/Tasks***
- The student logs in
- The student navigates to the edit user page
- The student types in their intended changes
- The student clicks confirm
- A success message is displayed

**Alternative Flow**: The edit user page would normally be so that the user can scan their UCARD after registration. So an alternative would be not needing to scan their UCARD since they registered at the lab and associated it with their account there and then. The user can change any number of their details at one time.

**Exceptional Flow**: The student cannot change their username password via this function.

**Functional Requirements:**
-   Student can only edit their name, email and UCARD.    
-   System should not let student edit their username and password.    
-   System should not let students see/access other accounts and edit them.




**Non Functional Requirements:**
-   *Security*: Only can the logged in user and the admin edit their details, nobody else.
-   *Useability*: It should be simple to understand. The user must be able to understand what everything does on the page within a time frame of a few seconds.


**5. Attendance Check**

***Atomic Goals/Tasks***
- The student will enter the lab and go to the UCARD scanner connected to the tablet
- They will login
- They will go to the attendance page
- They will scan their UCARD
- Attendance is successfully checked

**Alternative Flow:** Student did not bring their UCARD but is present. In this case, the student must contact the admin to ensure that their account is not striked.

**Exceptional Flow:** Student did not book the lab slot in advanced and is not allowed/cannot enter their attendance. Another exception may be that student did not turn up for their attendance and is marked with a strike.

**Functional Requirements:**
-   System will only and must clearly display success/error messages for attendance check   
-   Function is not intended for students to check if any other users has particular attendance at a particular time  
-   Must only be able to mark attendance in the time slot that they booked, not before or after.  

**Non Functional Requirements:**
-   *Useability*: It should be simple to understand. The user must be able to understand what everything does on the page within a time frame of a few seconds.
-   *Efficiency*: Once the UCARD is scanned it should within a second move to the next page.
-   *Precision*: The precision of reader should be 100%. The RFID reader must correctly read the users UCARDs.


**User Interface Requirements:**
-   Seats should be numbered for ease of use and common understanding.
-   The user interface should be efficient in terms of both feedback speed and interaction time.    
-   The personal information for each user should be protected and only accessed by its account owner.    
-   The booking information should be described with all personal information detail.    
-   Images and its description form the signature of the document.    
-   The User Interface should be able to interoperate across a wide variety of platforms, media types and networks.    
-   Each button must clearly be labeled for the user  
-   Each important progress should have a confirmation.   
-   The User Interface should differentiate read-only displays from those that allow users to edit.   
-   The control panel button should be large enough to guarantee that users do not hit a wrong one accidently.
-   The currently selected options should be highlighted in a list of options.   
-   The font size (character height) shall be based on reading distance and guidance of HE75.
-   Character height (inches) = Distance (minutes of arc)/(57.3 x 60)
-   Admin should only be able to access delete user and delete all bookings in the display page beside each user/booking

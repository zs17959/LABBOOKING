# Laboratory Booking System : Requirements

### StakeHolders :
1. Approximately 200 EE students (user) : The main user of this web-app. Booking a single seat in a time-slot at a time.
2. Mr.Richard Walker (admin) : The lab technician who will be using the project on a daily basis. Will be booking seats each week for set classes and will be the administrator of the system.
3. (Optional) Support / Maintenance people after the project is finished
4. Lecturers (user)  : There may be lecturers who want to use the lab for their own work or book it for special cases

![image_name](https://github.com/konszy/LAB-BOOKING-ATTENDANCE/blob/master/portfolioA/Stakeholders%20Diagram.png)



#  Goals
###  1.Booking a seat (Core goal)
##### Atomic goals/tasks
* Log-in
* Select time slot for booking
    * select date
    * select time
* Select single seat number for booking
* Select extra equipment needed
* Confirm
* Receive confirmation email

__Alternative Flow__: You click the equipment first then go back and find the slot which corresponds to the equipment available.

**Exceptional Flow** : The booking seat you want becomes “in progress” and the user has to wait until it is available or select an alternative seat.

**Functional Requirements**:
* System should only allow students to book one week in advance
* Student should be able to cancel their booking prior to time allocated
* Student should not be able to cancel it after the time
* Student must only be able to edit their own bookings  
* Student must be able to reset their password in case they forget it
* Time and date must be set according to opening and closing time of lab/buidling each day
* Confirmation email must match student's booking and description
* Seat labeling must match real seats location and matches the database information
* Seats must be displayed as "in-progress", "unavaliable", "avaliable" or "class booked" and must match data in database

**Non-functional Requirement:**
* Dependability : The user must be able to book their time slot if it is not “in progress” or must be able to book an alternative seat in that time slot (parallel access should be solved)
* Security : Other than the admin, the system should not allow any users to edit their own id, email or other's bookings. This includes the exclusion of being able to login into other's account.
* Reliabillity : The system should be able to handle multiple user requests to the same booking page, meaning the users should see that the seats are not avaliable if the other users are selecting on it, preventing the error in booking system
* Scalabillity : The system should be able to handle request from more than one user in any time period
* Operation Constrants : Database should be running/online at all time, meaning there must be a viable back-up system (which oracle provides one)
* Usabillity : The user should know right away what each button works and how to navigate through the web system , if there is confusion in beta testing , it should be fixed right away
* Precision : The precision of booking seat time slot, number , equipment should always match what user input to prevent failure in booking time (100% precise)

### 2. Admin Booking
* Admin Login
* Select time slot
* Select the seat(s) number
* Click confirm

**Alternative Flow** : Sometimes the admin wants to book the slot of seats first then select the time.
**Exceptional Flow**: If the seat is not available, he select the alternative time slot or select other seats.

**Functional Requirement:**
* System should provide the admin absolute control of the timetable
* Admin should be able to cancel/edit/add any bookings any time during the one week period
* Admin should have a strong validation / secure login in order to access their privileges
* Admin should be able to view/edit the blacklist of students
* Admin must be able to print out the timetable
* Admin should be able to access the timetable of the next week on Friday (9am)

### 3. Admin selection of Equipments (similar functional requirement as Admin Booking and Booking a seat)
* Admin Login
* Go to Equipment Page
* Select Time slot
* Select the number available for each

**Alternative Flow**: The Admin select the equipment first then select time slot (if the equipment is not going to be available for the whole day.

**Exceptional Flow**: none since he has the absolute control

### 4.Blacklisting
* Student does not turn up for booking time slot
* A strike is sent into their account and to admin table of names
* If there are 3 strikes we send the name into blacklist
* The Student booking account is temporarily blocked
* Student is sent an email to contact admin and set up a meeting

**Alternative Flow**: The student sets up their own meeting with the admin and resolve problem at the first or two strikes.

**Exceptional Flow**: The student doesn’t set up a meeting and admin must be the one who contacts them instead.

### 5. Registering
* Scan UCARD at the lab
* Enter Details

**Alternative Flow:** : None. The details cannot be entered first since it will compromise the *Blacklisting* function
**Exceptional Flow:** If the scanner is not working or the user cannot scan their ucard, then they must go to the lab technician who has a spare RFID reader. If there is still a problem then the lab technician will use the number written on the UCARD in place of the scanned number.

**Functional Requirement:**
* System should be able to provide a valid account for each individual student(to their UCARD)
* Students should be able to edit their account details
* Students should be able to access/register/login using their UCARD
* System must register the unique ID of UCARD each time it is scanned
* System must be friendly to all users (Especially those with dyslexia) by using san serif font
* Registration and Bookings must be done on the web app available
* Students user ID should be strictly linked to their ID on university email address.

**Non-Functional Requirement:**
* Security Requirement : User personal info must be accessed by them
* Students should use strong password(combination of capital letter, numbers and lower case...).
* Students should use their own UCARD for registration.

# User Interface Requirements :
* Seats should be numbered for ease of use and common understanding.
* The user interface should be efficient in terms of both feedback speed and interaction time.
* The personal information for each user should be protected and only accessed by its account owner.
* The booking information should be described with all personal information detail.
* Images and its description form the signature of the document.
* The User Interface should be able to interoperate across a wide variety of platforms, media types and networks.
* Each button must clearly be labeled for the user
* Each important progress should have a confirmation.
* The User Interface should differentiate read-only displays from those that allow users to edit.
* The control panel button should be large enough to guarantee that users do not hit a wrong one accidently.
* The currently selected options should be highlighted in a list of options.
* The font size (character height) shall be based on reading distance and guidance of HE75. * Character height (inches) = Distance (minutes of arc)/(57.3 x 60)
* There should be a saving button/function where the admin can save the schedule of last * week booking and re-book it again in the next week

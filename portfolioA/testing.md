# Development and Release Testing Test Cases
### Type of tests
__Unit Testing__ : Each component/function will be testing using the **JUnit Assertion**. If any cannot be tested using the Assertion, it will be tested manullay instead using curl/manual input check.

**Integration Test:** The following are test cases designed to make sure each functions and properties of Entity in the architectural diagram are performing as intended. In addition, some of the test cases will also check that the UI front-end is displaying the real-time and correct information to the user. Assertions will be made using **JUnit** and **Terminal Curl** (in cases where JUnit cannot detect output). The input will either be inserted by the *JUnit Assertion* code, a seperate test program or manually input then test manually.

| Related Function in Architectural Diagram and Test types  |  Assertion Input / Test Cases | Expected Output |
| --------------| ----------------| -------------- |
| login(), FindUserAcc(), FindUserPass(), Validate() | Registered Username with wrong password | Error Message : Username or Password incorrect |
| Logout() | Logout function processed and cannot access account after refreshing| User cannot access account after refresh |
|Login(), Validate(), FindUserAcc(), FindUserPass() |  Enter either only username and password | A text popup with “both username and password is required to login” |
| Registration(), SetUserDAO(), addUserDao() | Registered using existing ucard number | Account id and email are already in the database and filled within registration form |
| Registration(), SetUserDAO(), addUserDao() |Registered using non-existing ucard number| Account id and email should not exist and error message is displayed |
| SelectSeat(), SelectBlock(), SelectEquip(), Confirm() | Admin books the whole seats of a block/all seats/ a row | The student’s display of booking should show that it is booked/locked |
|UpdateSeat( ), UpdatEquip( ), SelectSeat(), Confirm( ), Test UI design and HTTP Get request, Test Real-time refresh of web-page after two users click on the same seat | Two users are in the same page with one booking a seat and the other still looking at a seat |The user who is still looking should see the seat status as “locked” and shouldn’t be able to access the booking of the particular seat |
| UI Design Test, HTTP get test, updateSeat() | Time slot selected and seats and are displayed | Check with database, the information on both should matched |
| UI Design Test, Connection to database Test | Manipulate the seats selection in the database | The seat booked should match in the student/admin display on web UI |
| SelectSeat(), SelectBlock(), SelectEquip(), Confirm() | Book a seat with selected equipment and time slot | Check confirmation email, the details should matched what was being selected |
|  login(), FindUserAcc(), FindUserPass(), Validate(), Prevention and Security test, User Authentication Test |Enter “000000000000” as username and “11111111” as password | Error should display as “format of username doesn’t match” |
|  login(), FindUserAcc(), FindUserPass(), Validate(), Prevention and Security test, User Authentication Test |Enter “admin” as username and “00000000000000” as password | Error should display “format of username doesn’t match” |
|  login(), FindUserAcc(), FindUserPass(), Validate() |Enter correct username “test@my.bristol.ac.uk” and “12345Abc” as password while adding it manually on the database | Login should be successful
| sendConfirm() | Enter all bookings and seats with equipment and then click confirm | check if the system has sent the email to the right address and data in database matches input |

Most of the functions both related to the service and database can be tested throug JUnit and comparing the information inside the database and the test input. This includes the accuracy of information between front-end (UI display and Back-end) However, the only test that cannot be directly tested by us is the User Acceptance testing for the UI design.

# User Acceptance Testing
In user acceptance testing, we will ask the client to bring some students for Beta testing in which the client and admin (Richard Walker) will test the product as well. There will be some questions and guidance for the user on how to navigate or try certain functions in order to check the Human-Computer interaction between the user and the system. Each of the team members will monitor how the user interacts with the product and report results back for analysis and further improvement.

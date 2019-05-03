
## Development Testing

**Unit Testing** : 
Each component/function will be testing using the JUnit Assertion and Mockito. While Unit testing for Controller and Service in Booking has been completed. This includes unit testing for functions such as getuserbyID, getAllUsers, etc. 
However, we experienced a huge barrier in doing Integration testing and Unit Testing for Students and Booking. For Students, there is a login function that requires the Mockito to logged in before testing the Controller and Service. The same goes for Integration testing where the login function also blocks out the Mockito. 

**Continuous Integration Testing with Selenium** :
To overcome our problem in integration testing, we decided to use Selenium as a testing tool for our website functionality. Selenium can test the user workflow itself as an automation each time we have a  new version up and running, hence is an continuous integration test. Selenium has helped us discover if there are any problems with links or functions in the backend and the server itself as it goes through with the user workflow. 

**Manual Testing and Black Box Testing**: As an alternative way to test our system, we decided to test the product manually. For every sub test in this part, we create a table where we record in each version what problem still persists and what problem has been solved as a continuous testing and user workflow test. This includes inserting 

**Login Manual Test** : Testing if normal users cannot access admin-only URLs such as deleting students and delete strikes
Registration Manual Test: Inserting correct and incorrect input for user information and testing if username and email has not been registered by someone else.
Booking Manual Test: Inserting incorrect input such as booking a time slot that has already been booked and not inserting date/time/seat for the input.
Deletion Test : In display all bookings, deleting is a major features where we test if the delete button works as expected. 

**Stress Test** : Because the system is an online booking system that will handle many users, stress test is a key part of our development to determine if the system can handle many users at once. We manually tested the system by selecting the same booking seat and same time to see whether the system would respond as it should. Our final test suggests that the system can handle multiple users at once and is still successful at all its functionality. 

**Web Testing with Pentest-Tools.com**: 
After testing the security of the website, we find that there are two key points that could be improved. Firstly, we use HTTP protocol to connect web browser and server, which transmits unencrypted data over the network. Therefore, attackers might be able to read and modify the transmitted data easily, such as passwords and secret tokens. In this case, we are recommended to configure the server to use HTTPS, which can help us to protect the transmitted data during the communication process between web browser and the server. In addition, Nginx 1.14.0 is used for the project, which should be continuously updated in order to ensure the security of the website. If we always use the current version, worker processes might be crashed or the memory of worker processes might be disclosed by using a specially crafted mp4 file.


# credit_card_info_finder
v1


![github-large](https://miro.medium.com/max/640/1*9PFax8JDvffYsebCmi6BYA.gif)




* Android app which make use of  BINLIST API  to get credit card details and display the card information.
* well tested Unit and UI tests with junit and expresso  
* Design pattern used - MVVM (Model-View-ViewModel) 
* App can scan Credit card using PAY-CARD library - ( https://github.com/faceterteam/PayCards_Android) which use ocr
* App also automated to send request once your card IIN is completed (16 - digits) in the edit text

Explaining project file
- db store the responds data from api responds
- server folder contain class to make request to the server (using retrofit)

* ui folder file
-activity - contain the user interface view class
-base    -- it is an abstract class for activity that share same properties,
-repository -- class for making network call to the server
-view -- interface  to pass server response to viewmodel
--viewmodel. -- is a class that is responsible for preparing and managing the data for an Activit




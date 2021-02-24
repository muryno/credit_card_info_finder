# credit_card_info_finder
v1

![alt text](https://github.com/muryno/credit_card_info_finder/blob/master/ezgif.com-gif-maker.gif?raw=true)




* Android app which make use of  BINLIST API  to get credit card details and display the card information.
* well tested Unit and UI tests with junit and expresso  
* Design pattern used - MVVM (Model-View-ViewModel) 
* App can scan Credit card using PAY-CARD library - ( https://github.com/faceterteam/PayCards_Android) which use ocr
* App also automated to send request once your card IIN is completed (16 - digits) in the edit text

Explaining project file
- db store the responds data from api responds
- server folder contain class to make request to the server (using retrofit)

-ui folder contain { *activity - to hold ui
                   *base    -- for activity that share same property,
                   *repository  -- since database it contain network request{ do the dirty work to talk to server or local database}
                   *view   -- interface to transfer data
                   *viewmodel -- to give any activity that want to observe}
}

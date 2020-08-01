# Testing phptravels.net
Selenium test automation practices on the phptravels.net website.
 
## Running
Before the first run install packages listed in pom.xml file using Maven. 

Run tests using the standard Selenium way. The phptravel.net website is very buggy and frequently crashes, so tests should be repeated several times.

## Test sets description
The project is structured as following: the package `tests` contains the implementation of tests and the package pageobjects contains the implementation of page classes referring to appropriate web pages.

The package test contains classes:
- `BaseTest` which contains general setup for all tests.
- `BookFlightTest` which contains test whether user can correctly login and book flight.
- `BookHotelTest` which contains test whether user can correctly login and book hotel.
- `ChangeLanguageTest` which contains tests on language change to Russian and German.
- `LoginTest` which contains test wheter user can correctly login. It also contains tests whether user can not correctly login.
- `LogoutTest` which contains test whether user can correctly login and logout.
- `RegisterTest` which contains test wheter user can correctly register and tests wheter user can not correctly register.
- `SearchFlightTest` which contains tests on choosing single/round trip, adding 100 adults, changing classes, changing currency, converting currenty prices, changing price range, changing choosen airline.
- `SearchHotelsTest` which contains tests on choosing single hotel, list of hotels and no result.

## The negative tests
- `ChangeLanguageTest.shouldChangeToGermanLanguage` - after changing language to German the language ot the content of website in not changing.
- `SearchFlightTest.shouldChangeClassToBusinessAndReturnResultsFoundDislpay` - after changing type class to Business the class in not changing.
- `SearchFlightTest.shouldChangeClassToFirstsAndReturnResultsFoundDislpay` - after changing type class to First the class in not changing.
- `SearchFlightTest.shouldRoundTripResultsFoundDisplay` - after changing trip option to round, empty results page is displayed.
- `SearchFlightTest.shouldChangeCurrencyToSAR` - after changing the currency to SAR, price currency names are not changing.
- `SearchFlightTest.shouldAdd100AdultsAndReturnTripResultsFoundDisplay` - after selecting trip for 100 adults, results for adult is displayed.
- `SearchFlightTest.shouldReturnRoundTripWithChangeDepartAndReturnDataResultsFoundDisplay` - after changing trip dates, empty results page is displayed.

## The positive tests
All test except those mentioned above.
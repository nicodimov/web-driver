# web-driver

## Requirements

Chromedriver and geckodriver must be located in the same directory where maven command is executed

To run the tests execute the following command: 

```
mvn clean install -Dbrowser-ut=<browserToTest>
```
Where browserToTest can take 'firefox' or 'googlechrome' values. If property is not present the default value is 'googlechrome'

## Versions

Tested successfully with 
geckodriver 0.27 and Firefox 65
chromedriver 86 and Chrome 87

## Known Issues

With Firefox driver (geckodriver 0.21) there is an issue when tries to change the current tab. Only tests under Chrome (chromedriver) is working so far.



# web-driver

## Requirements

Chromedriver must be located in the same directory where maven command is executed

To run the tests execute the following command: 

```
mvn clean install
```

## Known Issues

With Firefox driver (geckodriver 0.21) there is an issue when tries to change the current tab. Only tests under Chrome (chromedriver) is working so far.

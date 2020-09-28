# nRF91ServerTest
Spring Boot server for IoT nRF91 

## Test Spring Boot - NB-IoT TCP server 

### Linode - Deploy Spring Boot Applications
    https://www.linode.com/docs/development/java/how-to-deploy-spring-boot-applications-nginx-ubuntu-16-04/

### Build 
    $ ./gradlew build
    
### Run 
    $ java -jar build/libs/nRF91ServerTest-0.0.1-SNAPSHOT.jar
    
### HTTP and HTTPS
    Server context path '/'
    Server supports both HTTP and HTTPS
    # HTTP -> port : 42511
    # HTTPS -> port : 42512

### Curl CLient Test

## HTTPS
    curl Test 
    # curl --cacert nrftestserver.cer https://139.162.251.115:42512
    # {"ActionName":"BSDTest","LED1":false,"LED2":true}
    
## HTTP
    curl Test 
    # curl https://139.162.251.115:42511
    # {"ActionName":"BSDTest","LED1":false,"LED2":true}
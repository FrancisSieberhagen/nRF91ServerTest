# nRF91ServerTest
Spring Boot server for IoT nRF91 

## Test Spring Boot - NB-IoT TCP server 

### Linode - Deploy Spring Boot Applications
    https://www.linode.com/docs/development/java/how-to-deploy-spring-boot-applications-nginx-ubuntu-16-04/

### Build 
    $ ./gradlew build
    
### Run locally
    $ java -jar build/libs/nRF91ServerTest-0.0.1-SNAPSHOT.jar

### Deploy to linode server
    $ scp build/libs/nRF91ServerTest-0.0.1-SNAPSHOT.jar root@139.162.251.115:~/dev/nRF91ServerTest/
      
### Run/restart the server app remotely
    $ ssh root@139.162.251.115 "killall -9 java; cd /root/dev/nRF91ServerTest; nohup java -jar nRF91ServerTest-0.0.1-SNAPSHOT.jar"    

### HTTP and HTTPS
    Server context path '/'
    Server supports both HTTP and HTTPS
    # HTTP -> port : 42512
    # HTTPS -> port : 42513

### Curl Client Test

## HTTPS
    curl test 
    $ curl --cacert nrftestserver.cer https://139.162.251.115:42513
    {"ActionName":"BSDTest","LED1":false,"LED2":true}
    
## HTTP
    curl test 
    $ curl http://139.162.251.115:42512
    {"ActionName":"BSDTest","LED1":false,"LED2":true}
    
## Generating self-signed SSL certificate

Use the Java ```keytool``` command to generate the self signed cert keystore.jks like this:

    $ keytool -genkeypair -alias nrftestserver -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.jks -validity 3650
        Enter keystore password: password
        Re-enter new password: password
        What is your first and last name?
          [Unknown]: 139.162.251.115
        What is the name of your organizational unit?
          [Unknown]:  Standard Bank IOT
        What is the name of your organization?
          [Unknown]:  Standard Bank
        What is the name of your City or Locality?
          [Unknown]:  Johannesburg
        What is the name of your State or Province?
          [Unknown]:  Gauteng
        What is the two-letter country code for this unit?
          [Unknown]:  ZA
        Is CN=139.162.251.115, OU=Standard Bank IOT, O=Standard Bank, L=Johannesburg, ST=Gauteng, C=ZA correct?
          [no]:  yes

Export the cert to use for the client applications from the keystore like this:

    $ keytool -export -keystore keystore.jks -alias nrftestserver -file nrftestserver.cer -rfc

Simple postcode service. 

Application was implemented with Java 8 and Spring Boot(actuator and cache dependency) and Gradle build.

I've used PostCoder Web from Allies as postcode lookup provider. (https://www.alliescomputing.com/)

Added caching on service layer to avoid costly calls to lookup provider and to improve performance. 

Enjoy !
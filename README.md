webservice-tdd
==============

An example JSON webservice with its Java client built using TDD with functional and unit tests. The steps being taken are in individual commits.

Technologies
------------
* maven
* spring
* jackson
* tomcat7

Build
-----

Build project, run tests:
```
   mvn verify
```

Build project, run tests, start Tomcat and deploy app at `localhost:9876`
```
   mvn verify -P runapp
```

#drop-angular

An example project showing a way to lash together [dropwizard](dropwizard.io) and a [browserified](http://browserify.org) [angular](https://angularjs.org) app.

##Prerequisites

* Java 7
* gradle

##Building

```
gradle jar
````

##Running

```
java -jar build/libs/drop-angular.jar server demo.yml
```
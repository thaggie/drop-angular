#drop-angular

An example project showing a way to lash together [dropwizard](http://dropwizard.io) and a [browserified](http://browserify.org) [angular](https://angularjs.org) app.

##Prerequisites

* Java 7
* gradle

##Building

```
gradle shadowJar
````

##Running

```
java -jar build/libs/drop-angular-all.jar server demo.yml
```

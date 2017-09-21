## AptSpringProcessor demo

Currently using version 1.1.0 of AptSpring:

```
        <dependency>
            <groupId>com.salesforce.aptspring</groupId>
            <artifactId>AptSpringAPI</artifactId>
            <version>1.1.0</version>
        </dependency>
        <dependency>
            <groupId>com.salesforce.aptspring</groupId>
            <artifactId>AptSpringProcessor</artifactId>
            <version>1.1.0</version>
        </dependency>
```

Version 1.13.2 of takari-lifecycle, which is an incremental compiler for maven, base on eclipse's jdt.

```
        <groupId>io.takari.maven.plugins</groupId>
        <artifactId>takari-lifecycle-plugin</artifactId>
        <version>${plugin.maven.takari.version}</version>
```

And an unfortunately unreleased version of io.takari.m2e.lifecycle, which is m2e support for takari-lifecycle.

https://github.com/rexhoffman/io.takari.m2e.lifecycle

Check out demo video here: [Demo](https://youtu.be/XTYIDOsCKTM "Demo") 

Unmentioned in the video is that types are checked at injection points as well.
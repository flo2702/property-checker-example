This example project illustrates how the Property Checker can be used in your project.

It is organized as follows:

* The file `lattice_interval` contains the definiton for a property qualifier hierarchy.
* The package `qual` contains the annotation types used in `lattice_interval`.
* The package `client` contains a simple example project which uses this qualifier hierarchy.

To type-check this program using the Property Checker, run the following commands.
The commands assume that the working directory contains the following:

* A directory `property-checker` containg fully assembled the Property Checker (see the Property Checker's documention for how to build it).
* A directory `property-checker-tutorial` containg this example project.

If your local configuaration differs from this, adjust the command as needed.

```
cd property-types/property-checker-tutorial
./gradlew assemble
cd ..

property-checker/checker-framework/bin/javac \
-cp property-checker/build/libs/property-checker.jar:\
property-checker-tutorial/build/libs/property-checker-tutorial.jar:\
property-checker/checker-framework/dist/checker.jar:\
property-checker/checker-framework/dist/checker-dist.jar \
-processor edu.kit.iti.checker.property.checker.PropertyChecker \
property-checker-tutorial/src/main/java/*/*.java \
-APropertyChecker_inDir=property-checker-tutorial/src/main/java \
-APropertyChecker_outDir=property-checker-out \
-APropertyChecker_lattices=property-checker-tutorial/lattice_interval \
-APropertyChecker_qualPkg=qual
```

The command is made up of the following parts:

* `-cp` specifies the classpath, which must contain the Property Checker and the Checker Framework, but also the `qual` package from our project, hence the jar from our project is included.
* `-processor` specifies the checker(s) to use, in our case the Property Checker
* The line after that gives the files which should be checked.
* `-APropertyChecker_inDir` gives the root directory for our project's source code. This may seen redundant with the previous line, but it is necessary for the Property Checker to know not just the files it should check, but also the file/package structure of the project.
* `-APropertyChecker_ourDir` gives the directory the JML translation should be written to.
* `-APropertyChecker_qualPkg` gives the fully qualified name of the `qual` package.


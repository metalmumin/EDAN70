EDAN70 - JastAdd name-analysis library
======
JastAdd name-analysis-library was developed at Lund University by Daniel Forsman, Jakub Gorski under supervision of Niklas Fors.
For additional contributors, see the change logs. The library is elaborately explained in [this paper](https://www.writelatex.com/read/jzddnhrndmvs).

License
-------
Copyright (c) 2014, Jakub Górski and Daniel Forsman. All rights reserved.

Dependencies
------------

JastAdd name-analysis-library requires [JastAdd2](http://jastadd.org) to be intefaced with, a Java Runtime Environment (JRE) to run, and a JDK to build.
The minimum required Java version for JastAdd2 is Java SE 6.
See [https://bitbucket.org/jastadd/jastadd2](https://bitbucket.org/jastadd/jastadd2) for a complete list of JastAdd2 dependencies.

The JastAdd name-analysis-library is meant to be interfaced with classes generated 
by context-free grammar.

For the moment there is no binary distribution, only the file `NameAnalysisLibrary.jrag`.

Building Demo Examples and Testing
--------
Builds are done by using the Apache Ant script build.xml residing in each Demo folder:

* Ordinary build (generate and compile):

        > ant

* Create a new jar file (compiler.jar)

        > ant jar

* Perform tests:

        > ant test

* Delete generated files

        > ant clean

The `ant test` command runs the test files in the project directory. To view these testfiles go into the testfolder, `testfiles`, in the demo folder. The test files all end with `.lang`, while their respective expected output are of type `.expected`.
To test separate example files go to the project directory where the `compiler.jar` file is created with the `ant jar` command as instructed earlier, then type
> java -jar compiler.jar testfiles/\<test_file_name\>

File Types
----------

* `.ast`      JastAdd abstract syntax tree files
* `.jrag`     JastAdd semantics files. Usually declarative.
* `.jadd`     JastAdd semantics files. Usually imperative.
* `.java`     Regular Java sources

Directory Structure
-------------------
There are three different compilers. Each done with manual name analysis (directory name ends with "_Manually") and with name analysis using the Name Analysis Library. Here follows the structure of each directory:

* `build.xml` Compiled generated source files.
* `bin/`
* `lib/`
* `src/`
    - `gen/` Generated source files.
    - `jastadd/` JastAdd aspect and AST specifications.
    - `java/` Java source files
        - `lang/`
            - `Compiler.java` The main class. Compiles the .ast and .jrag files to Java files and performs name analysis.
        - `tests/`
            - `AbstractParametrizedTest.java` A parameterized test suite. Adds helper methods for parameterized testing.
            - `AbstractTestSuite.java` Utility methods for running tests.
            - `ShowErrors.java` JUnit test class.
    - `parser/` JastAdd parser specifications.
    - `scanner/` JastAdd scanner specifications.
* `testfiles/` Written test files to test name analysis.

Understanding the Implementation
--------------------------------
Overall interfacing with our JastAdd name analysis library:

* Generated AST classes with declarations, their usages, and scope definitions
  are interfaced with name-analysis-library.
* The attribute named `decl()` should be a bound reference to the symbols, `Usage`, declaration. This is given to the user.
* The attribute named `isMultiplyDeclared()` which is a boolean attribute belonging to the class `Declaration`. This is given to the user.
* The attribute named `_checkEnclosingScopes()` which is a boolean attribute belonging to the class `Scope`. Has to be set by the user.
* The attribute named `_declareBefureUse()` which is a boolean attribute belonging to the class `Scope`. Has to be set by the user.
* There are more attributes which are used to evaluate the above attributes. The attributes which are not listed above are there but they are not intended to be used in this release.

All attributes have to be set by the user. The JastAdd compiler will complain if this is not done.

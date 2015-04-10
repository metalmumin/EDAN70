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

* `.flex`     JastAdd scanner files
* `.beaver`   JastAdd parser files
* `.ast`      JastAdd abstract syntax tree files

* `.jrag`     JastAdd semantics files. Usually declarative
* `.jadd`     JastAdd semantics files. Usually imperative
* `.java`     Regular Java sources

* `.lang`     Test file
* `.expected` Expected test result file

Directory Structure
-------------------

* `build.xml` Ant script.
* `bin/`
* `lib/`
* `src/`
    - `gen/` Generated .java files.
    - `jastadd/` JastAdd AST .jrag .ast specifications.
    - `java/` Java source files.
        - `lang/`
            - `Compiler.java` Main class.
        - `tests/`
            - `AbstractParametrizedTest.java` Helper methods for parameterized testing.
            - `AbstractTestSuite.java` Utility methods for running tests.
            - `ShowErrors.java` Helper methods for parameterized testing.
    - `parser/` JastAdd parser .beaver specification.
    - `scanner/` JastAdd scanner .flex specification.
* `testfiles/` Written test files to test name analysis.

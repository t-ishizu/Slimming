The following readme is an instruction manual for the usage of the
CCM Prototype Tool. For additional information about the background
of this tool and why it was developed refer to the paper found at
this url: http://sel.ist.osaka-u.ac.jp/lab-db/betuzuri/contents.en/1037.html

For questions and comments please email: bufordedwards3@gmail.com

======================
---- Introduction ----
======================

Some quick notes before beginning. Included in the package are 3 programs, CCFinderX, CLOC, and CCMPT.
CCFinderX is the program CCMPT uses to generate code clone pair data as part of its required input.
CLOC is a program to remove comments and whitespace in order to help "normalize" the code as a sort
of pre-processing before running CCMPT.
CCMPT is the Complete Code-Clone Merge Prototype Tool which performs the CCM algorithm. 

Also included in this package are two scripts. The most important of which is "runCCM" which is what the
following usages pertaint to as detailed in the Quick Start Guide and Help and Options sections.

Secondly, because of the way in which this tool was developed alongside CCFinderX, the tool currently works
the most accurately when it is analyzing only one file. For that reason, the tool will only accept one
file to analyze. However, using the script "quickAppend" one can quickly merge several files into one and
runCCM on the appended file. For example, if one wanted to merge all the java files in a directory into
a single file and run the tool, they would do the following:

./quickAppend java AppendedJavaFiles.java

Then they would do ./runCCM java AppendedJavaFiles.java

I hope you have an easy time running the tool.

===========================
---- Quick Start Guide ----
===========================

Usage: runCCM [filetype] [file] (options)

Example usage: 
runCCM java Multilap.java

Example output: 
|S|     TCL     |S'|    PR
154     138     100     35.064934

|S| - Initial source code size (number of lines)
TCL - Total clone lines
|S'| - Source code size after merge
PR - Percent reduction

==========================
---- Help and Options ----
==========================

Usage: CCM [fileType] [file] (options)

Acceptable args for [fileType]:
 -- cobol
 -- cpp
 -- csharp
 -- java
 -- plaintext
 -- visualbasic
Options:
-o <filename>   change outputfile
-c              display calculations
-ver            display version number
-t              show runtime
-p              outputs S-Prime outline
-f              outputs shared function visualization
-sm             changes default to using smallest version of code clone instead of largest
-rnr <value>    filters CID's with RNR less than arg value
-v              changes output to verbose
-mo             displays maximum output (-f-v-p-c-t-ver-o)

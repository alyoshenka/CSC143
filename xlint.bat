echo off

REM Create a temp directory and move all test files into it
md temp
move *test.java temp

REM Clear the screen, then do the requested Xlint and Xdoclint runs
cls
"C:\Program Files\Java\jdk1.8.0_201\bin\javac.exe" -Xlint:unchecked *.java 
"C:\Program Files\Java\jdk1.8.0_201\bin\javac.exe" -Xdoclint:all *.java

REM Move the files back and delete the now-empty directory
move temp\*.* .
rd temp
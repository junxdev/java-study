@echo off

set /p day=Enter the day: 
 
set /p class=Enter the class name: 


javac -d . -encoding utf8 day%day%\%class%.java

echo.  
echo          �� �� �� �� �� �� �� �� ��  result  �� �� �� �� �� �� �� �� �� 
echo.  

java com.bit.day%day%.%class%
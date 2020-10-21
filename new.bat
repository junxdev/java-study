@echo off

set /p day=Enter the day: 
set /p class=Enter the class name: 

echo package com.bit.day%day%; > Ex.java
echo. >> Ex.java
echo class %class% { >> Ex.java
echo. >> Ex.java
echo 	public static void main(String[] args) { >> Ex.java
echo. >> Ex.java
echo 		System.out.println(); >> Ex.java
echo. >> Ex.java
echo 	} // main end >> Ex.java
echo. >> Ex.java
echo } // class end >> Ex.java

move Ex.java .\day%day%
ren .\day%day%\Ex.java %class%.java
start notepad .\day%day%\%class%.java

@echo off 
call mvn clean install -Pweb-local -Dmaven.test.skip=true
pause  
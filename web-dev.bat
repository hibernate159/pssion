@echo off 
call mvn clean install -Pweb-dev -Dmaven.test.skip=true
pause  
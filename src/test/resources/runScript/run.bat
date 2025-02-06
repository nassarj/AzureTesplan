rem
rem Autor: joseph.nassar@msg.group
rem
echo Jar-File: ../config/wissenstransfer_jar.properties -Doperating-sys=%COMPUTERNAME% -jar Wissentransfer_Tobias-1.0-SNAPSHOT.jar
del ..\config\log4j2.xml
type ..\config\log4j2-run-jar.xml > ..\config\log4j2.xml
java -DconfigFile=../config/wissenstransfer_jar_windows.properties -Doperating-sys=%COMPUTERNAME% -Dlog4j.configurationFile=../config/log4j2.xml -jar Wissentransfer_Tobias-1.0-SNAPSHOT.jar
pause
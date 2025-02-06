#
#Autor: joseph.nassar@msg.group
#
#!/bin/bash
echo which java
which java
java -version
echo $JAVA_HOME/bin
export PATH=$JAVA_HOME/bin:$PATH
export classpath=../config:$classpath


pushd .
cd ../webdriver/
mv geckodriver-v0.30.0 geckodriver
chmod 744 geckodriver
cp geckodriver /daten1/san_daten1/checkout4jenkins/OEAWS_gui_testing.development/target/execute/bin/
export PATH=/daten1/san_daten1/checkout4jenkins/OEAWS_gui_testing.development/target/execute/bin:$PATH
cd ../bin/
chmod 744 geckodriver

echo which geckodriver
which geckodriver
geckodriver --version

echo which firefox
which firefox
firefox --version

cd ../config
rm log4j2.xml
cp log4j2-run-jar.xml log4j2.xml
cp applicationContext.xml ../bin/applicationContext.xml
export classpath=$classpath:$PATH
echo $classpath
cd ../bin
pwd
ls -al

echo which applicationContext.xml
which applicationContext.xml

echo check locale
locale
echo check locale -a
locale -a
echo check locale status
localectl status
echo check LC_TIME
locale LC_TIME
echo "$LC_CTYPE"
echo $LC_CTYPE

echo set deutsche locale
sudo localectl set-locale LANG=de_DE.UTF-8



popd
EXECUTABLE_JAR=$(find . -type f -name 'Wissentransfer_Tobias-*\.jar')
echo Jar-File: ../config/wissenstransfer_jar_linux.properties -Doperating-sys=$MACHTYPE -Druntime-env=$HOSTNAME -jar $EXECUTABLE_JAR
java -DconfigFile=../config/wissenstransfer_jar_linux.properties -Doperating-sys=$MACHTYPE -Druntime-env=$HOSTNAME -Dlog4j.configurationFile=../config/log4j2.xml -jar $EXECUTABLE_JAR

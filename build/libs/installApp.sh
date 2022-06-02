sudo killall -9 java
cd /app
chmod 765 spep-0.0.1-SNAPSHOT.jar
nohup java -jar spep-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

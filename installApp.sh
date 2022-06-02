sudo killall -9 java
chmod 765 spep-0.0.1-SNAPSHOT.jar
nohup java -jar /home/ubuntu/demo-project/spep-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
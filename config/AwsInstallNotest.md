# AWS Installationsnotizen

## Marina DB
    1 mysql -u root -p
	2 GRANT ALL ON techupdate.* TO techupdate@localhost IDENTIFIED BY 'updatetech';
	3 mysql -u techupdate -p -D techupdate

	4 sudo cat /etc/my.cnf 
	 [mysqld]
	 lower_case_table_names=1

## User
    2  sudo yum update -y
    3  sudo yum install -y docker nginx git
    4  wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
    10  java -version
    12  sudo yum install java-1.8.0-openjdk-devel
    13  sudo /usr/sbin/alternatives --config java
    14  sudo /usr/sbin/alternatives --config javac
    15  java -version
    16  sudo yum install -y tomcat8
    17  sudo yum install tomcat8-webapps tomcat8-docs-webapp tomcat8-admin-webapps
    18  cd /etc/tomcat8/
    20  vi server.xml 
    33  pwd mkdir -p ~/.gradle && echo "org.gradle.daemon=false" >> ~/.gradle/gradle.properties
    35  cd ./git/techupdate/tecdemo/RestJpa/
    41  mkdir git
    42  cd git
    47  git clone https://github.com/ChristianAdam/techupdate.git
    50  cd techupdate/tecdemo/RestJpa/
    52  ./gradlew war
    53  chmod 755 gradlew
    54  ./gradlew war
    59  ./gradlew flywayMigrate
    60  ./gradlew derbyCreateDb
    37  nohup ./gradlew derbyStart > ~/derby.log &
    81  ls -l /usr/share/tomcat8/webapps/
    96  sudo -u tomcat cp build/libs/RestJpa-0.1.0.war /usr/share/tomcat8/webapps/RestJpa.war
    86  sudo service tomcat8 restart
    91  sudo cat /usr/share/tomcat8/logs/catalina.out
    98  curl -H "Content-Type: application/json" -X PUT -d '{"bankNumber":3321,"description":"Demo","serverAdress":"localhost"}' http://localhost:8090/RestJpa/corebanking/banks/create
    137  cd /etc/tomcat8/
    141  sudo vi tomcat-users.xml 
    150  sudo vi /etc/yum.repos.d/MariaDB.repo
    151  sudo yum install MariaDB-server MariaDB-client
    152  sudo service mysql start
    154  sudo vi /etc/my.cnf
    171  git clone https://github.com/ChristianAdam/restjpa.git
    191  mysql -u techupdate -p -D techupdate
    200  wget https://downloads.mariadb.com/Connectors/java/connector-java-1.5.7/mariadb-java-client-1.5.7.jar
    206  sudo cp mariadb-java-client-1.5.7.jar /usr/share/tomcat8/lib/
    211  sudo -u tomcat cp corebanking.xml /usr/share/tomcat8/conf/Catalina/localhost/
    214  cd git/techupdate/
    221  chmod 755 gradlew
    222  ./gradlew war
    224  sudo -u tomcat cp build/libs/corebanking-0.1.0.war /usr/share/tomcat8/webapps/corebanking.war
  
## Root
    1  wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
    2  rpm --import http://pkg.jenkins-ci.org/redhat-stable/jenkins-ci.org.key
    3  yum install jenkins
    4  service jenkins start
    5  chkconfig jenkins on
    6  cat /var/lib/jenkins/secrets/initialAdminPassword
    8  service nginx start
    9  chkconfig nginx on
    17  chkconfig tomcat8 on
    32  vi /var/lib/jenkins/users/admin/config.xml 
    34  mkswap -f /dev/xvdf
    35  swapon /dev/xvdf
    36  free -m
    37  history
  
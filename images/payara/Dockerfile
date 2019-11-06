FROM payara/server-full:5.183

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>


# Copy MySQL connector into payara instance
ADD drivers/mysql-connector-java-5.1.39-bin.jar /opt/payara5/glassfish/lib/


USER root
RUN export DEBIAN_FRONTEND=noninteractive && \
 apt-get update -y && \
 apt-get install -y --no-install-recommends apt-utils telnet

USER payara

RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/gfpw.txt && \  
  ./glassfish/bin/asadmin start-domain domain1  && \
  ./glassfish/bin/asadmin --user admin --passwordfile=/tmp/gfpw.txt enable-secure-admin && \
  ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=adminpw:DatabaseName=AMT_SCHEDULE:ServerName=db:port=3306 pool_course && \
  ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_course jdbc/AMT_SCHEDULE

# RUN ./glassfish/bin/asadmin stop-domain domain1


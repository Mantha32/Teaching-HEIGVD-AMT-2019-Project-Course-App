FROM payara/server-full:5.183

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>


# Copy MySQL connector into payara instance
ADD drivers/mysql-connector-java-5.1.39-bin.jar /payara5/glassfish/lib/


USER root
RUN export DEBIAN_FRONTEND=noninteractive && \
 apt-get update -y && \
 apt-get install -y --no-install-recommends apt-utils telnet

USER payara
RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/gfpw.txt && \
  /opt/payara/glassfish/bin/asadmin start-domain domain1 && \
  /opt/payara/glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=adminpw:DatabaseName=sakila:ServerName=db:port=3306 pool_sakila && \
  /opt/payara/glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_sakila jdbc/sakila && /opt/payara/glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=adminpw:DatabaseName=AMT_COURSE:ServerName=db:port=3306 pool_AMT_COURSE && \
  /opt/payara/glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_AMT_COURSE jdbc/AMT_COURSE



# RUN ./glassfish/bin/asadmin stop-domain domain1

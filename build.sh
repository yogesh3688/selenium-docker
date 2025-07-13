mvn clean package -DskipTest
cp dummy.txt target/docker-resources/dummy.txt

# This is code can be use to replace below code from pox.xml

#<resource>
#               <directory>.</directory>
#  <includes>
#    <include>dummy.txt</include>
#  </includes>
#</resource>
#! /bin/sh
echo '***************************************************************************'
echo '*********** This script runs liquibase updates from assembly **************'
echo '*********** Usage: ./update.sh profile-name                  **************'
echo '*********** where profile-name is dev, qa, prod, etc         **************'
echo '*********** look for liquibase-*.properties files            **************'
echo '*********** in profiles directory for more details           **************'
echo '***************************************************************************'
PROFILE=profiles/liquibase-$1.properties
echo profile value: $PROFILE
if [ ! -f $PROFILE ]; then
  echo Cannot find profile properties file: $PROFILE
  exit
fi

echo "Using ${PROFILE}"
   
## obtain LIQUIBASE_HOME
PRG="$0"
echo PRG value:  $PRG
while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`"/$link"
  fi
done

LIQUIBASE_HOME=`dirname "$PRG"`
echo LIQUIBASE_HOME $LIQUIBASE_HOME
echo pwd is : $pwd
# make it fully qualified
LIQUIBASE_HOME=`cd "$LIQUIBASE_HOME" && pwd`

echo $LIQUIBASE_HOME
  for i in ./lib/liqui*.jar; do
    CP="$i"
	##CP="$CP":"$i"
  done
  ## ECHO CP IS $CP 
  ## CP="$(echo $CP|cut -c2-)"
## ECHO CP IS $CP 
# build command-line
##CMD_LINE_ARGS="--defaultsFile=${PROFILE} --classpath=${CP} --changeLogFile=liquibase/dbchangelog-master.xml update"
CMD_LINE_ARGS="--defaultsFile=${PROFILE} --changeLogFile=dbchangelog-master.xml --username=$2 --password=$3 update"
echo CMD_LINE_ARGS $CMD_LINE_ARGS
# add any JVM options here
## JAVA_HOME="C:/Program Files/Java/jdk1.6.0_45"

## java  -jar "$pwd/lib/liquibase-core-3.3.3.jar" $CMD_LINE_ARGS
java -jar "$CP"  ${CMD_LINE_ARGS}

#!/usr/bin/env bash

hadoop fs -mkdir -p    /tmp
hadoop fs -mkdir -p    /user/hive/warehouse

cd /dog \
  && hive -f dog_table.hql \
  && hdfs dfs -put -f ./dog.csv /user/hive/warehouse/animal/dog

  hadoop fs -chmod -R g+w   /user/hive/warehouse
  hadoop fs -chmod -R g+w   /tmp

cd $HIVE_HOME/bin
./hiveserver2 --hiveconf hive.server2.enable.doAs=false

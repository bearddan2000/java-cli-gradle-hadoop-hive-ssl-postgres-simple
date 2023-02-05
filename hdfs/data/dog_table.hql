create database if not exists animal;

use animal;

create external table if not exists dog (
  id int,
  breed string,
  color string
)
row format delimited
fields terminated by ','
lines terminated by '\n'
stored as textfile location 'hdfs://namenode:8020/user/hive/warehouse/animal/dog';

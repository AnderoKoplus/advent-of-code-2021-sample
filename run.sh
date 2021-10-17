#!/bin/bash
for solution in $(seq -w 1 25)
do
  for runCounter in $(seq 1 3)
  do
    filename="day${solution}.jar"
    if [[ -f $filename ]]; then
      echo "> Running solution $solution/25 run $runCounter/3"
      java -jar "${filename}"
      echo "> End running solution $solution/25 run $runCounter/3"
      sleep 1
    fi
    ((ctr++))
  done
done

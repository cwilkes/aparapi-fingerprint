java \
  -Djava.library.path=native/ \
  -Dcom.amd.aparapi.executionMode=$1 \
  -classpath 'lib/*' \
  com.ladro.fingerprint.ArraySum $2 $3

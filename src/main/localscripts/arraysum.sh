java \
  -Djava.library.path=src/main/native/ \
  -Dcom.amd.aparapi.executionMode=$1 \
  -classpath 'repo/com/amd/aparapi/754/aparapi-754.jar:target/classes' \
  com.ladro.fingerprint.ArraySum $2 $3

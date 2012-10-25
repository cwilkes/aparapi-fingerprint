java \
  -Djava.library.path=native/ \
  -Dcom.amd.aparapi.executionMode=GPU \
  -classpath 'lib/*' \
  com.ladro.fingerprint.CLI

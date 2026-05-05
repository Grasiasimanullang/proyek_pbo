compile:
    javac -cp ".;lib/*" -d out src/app/*.java src/model/*.java src/service/*.java src/mapper/*.java src/db/*.java src/util/*.java

run:
    java -cp ".;out;lib/*" app.Main

test_01:
    java -cp ".;out;lib/*" app.DriverTugas1

test_02:
    java -cp ".;out;lib/*" app.DriverTugas2

test_03:
    java -cp ".;out;lib/*" app.DriverTugas3

test_04:
    java -cp ".;out;lib/*" app.DriverTugas4

clean:
    if exist out rmdir /s /q out

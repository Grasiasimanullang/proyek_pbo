compile:
	javac -cp ".;lib/*" -d out src/app/*.java src/model/*.java src/service/*.java src/mapper/*.java src/db/*.java src/util/*.java

run:
	java -cp ".;out;lib/*" app.Main

clean:
	if exist out rmdir /s /q out

resetdb:
	if exist database\cookies.db del database\cookies.db

rebuild:
	if exist out rmdir /s /q out
	javac -cp ".;lib/*" -d out src/app/*.java src/model/*.java src/service/*.java src/mapper/*.java src/db/*.java src/util/*.java
	java -cp ".;out;lib/*" app.Main


Penjelasan Makefile
______________________________________________
| Command | Fungsi                           |
| ------- | -------------------------------- |
| compile | Compile seluruh source code Java |
| run     | Menjalankan program utama        |
| clean   | Menghapus folder `out`           |
| resetdb | Menghapus database SQLite        |
| rebuild | Compile ulang + langsung run     |
|____________________________________________|
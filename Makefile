run: build
	"C:\Program Files\Java\jdk1.8.0_45\bin\java.exe" com.team5.helloex.Hello

build : 
	"C:\Program Files\Java\jdk1.8.0_45\bin\javac.exe" com/team5/helloex/Hello.java
	"C:\Program Files\Java\jdk1.8.0_45\bin\javac.exe" com/team5/helloex/Printer.java

clean:
	del com/team5/helloex/*.class
JFLAGS = -g
JC = javac
JVM= java 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java


CLASSES = \
	gameboard.java \
  robot.java \
  euclidian.java \
  manhattan.java \
	aEuclidian.java \
	aManhattan.java

MAIN = gameboard

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)

clean:
	$(RM) *.class

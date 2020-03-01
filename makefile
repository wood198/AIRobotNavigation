JFLAGS = -g
JC = javac
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

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

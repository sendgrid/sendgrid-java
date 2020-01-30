.PHONY: install test

install:
	@java -version || (echo "Java is not installed, please install Java >= 7"; exit 1);
	mvn clean install -DskipTests=true -Dgpg.skip -Dmaven.javadoc.skip=true -B

test:
	mvn test 

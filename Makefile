.PHONY: install test test-integration clean

install:
	@java -version || (echo "Java is not installed, please install Java >= 7"; exit 1);
	mvn clean install -DskipTests=true -Dgpg.skip -B

test:
	mvn test

test-integration:
	./scripts/startPrism.sh &
	sleep 5

clean:
	mvn clean

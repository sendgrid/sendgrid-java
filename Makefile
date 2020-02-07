.PHONY: install test test-integration clean

VERSION := $(shell mvn help:evaluate -Dexpression=project.version --batch-mode | grep -e '^[^\[]')
install:
	@java -version || (echo "Java is not installed, please install Java >= 7"; exit 1);
	mvn clean install -DskipTests=true -Dgpg.skip -B
	cp target/sendgrid-java-$(VERSION)-shaded.jar sendgrid-java.jar

test:
	mvn test

test-integration:
	./scripts/startPrism.sh &
	sleep 5

clean:
	mvn clean

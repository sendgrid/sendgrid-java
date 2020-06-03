.PHONY: install test test-integ test-docker clean

VERSION := $(shell mvn help:evaluate -Dexpression=project.version --batch-mode | grep -e '^[^\[]')
install:
	@java -version || (echo "Java is not installed, please install Java >= 7"; exit 1);
	mvn clean install -DskipTests=true -Dgpg.skip -Dmaven.javadoc.skip=true -B
	cp target/sendgrid-java-$(VERSION)-shaded.jar sendgrid-java.jar

test:
	mvn test

test-integ: test

version ?= latest
test-docker:
	curl -s https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/prism/prism.sh -o prism.sh
	version=$(version) bash ./prism.sh

clean:
	mvn clean

.PHONY: install package test test-integ test-docker update-deps clean

VERSION := $(shell mvn help:evaluate -Dexpression=project.version --batch-mode | grep -e '^[^\[]')
install:
	@java -version || (echo "Java is not installed, please install Java >= 7"; exit 1);
	mvn clean install -DskipTests=true -Dgpg.skip -Dmaven.javadoc.skip=true -B
	cp target/sendgrid-java-$(VERSION)-shaded.jar sendgrid-java.jar

package:
	mvn package -DskipTests=true -Dgpg.skip -Dmaven.javadoc.skip=true -B
	cp target/sendgrid-java-$(VERSION)-shaded.jar sendgrid-java.jar

test:
	mvn test spotbugs:spotbugs checkstyle:check -Dcheckstyle.config.location=google_checks.xml

test-integ: test

version ?= 8
COMPOSE := $(shell docker compose version >/dev/null 2>&1 && echo "docker compose" || echo "docker-compose")
test-docker:
	version=$(version) $(COMPOSE) -f mock-server/docker-compose.yml up --build --force-recreate \
		--abort-on-container-exit --exit-code-from helper-runner --remove-orphans; \
	status=$$?; version=$(version) $(COMPOSE) -f mock-server/docker-compose.yml down --remove-orphans; exit $$status

update-deps:
	mvn versions:use-latest-releases versions:commit -DallowMajorUpdates=false

clean:
	mvn clean

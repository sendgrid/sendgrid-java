Hello! Thank you for choosing to help contribute to one of the Twilio SendGrid open source libraries. There are many ways you can contribute and help is always welcome. We simply ask that you follow the following contribution policies.

**All third party contributors acknowledge that any contributions they provide will be made under the same open source license that the open source project is provided under.**

- [Improvements to the Codebase](#improvements-to-the-codebase)
  - [Development Environment](#development-environment)
    - [Install and Run Locally](#install-and-run-locally)
      - [Prerequisites](#prerequisites)
      - [Initial setup:](#initial-setup)
- [Environment Variables](#environment-variables)
      - [Execute:](#execute)
- [Understanding the Code Base](#understanding-the-code-base)
- [Testing](#testing)
- [Style Guidelines & Naming Conventions](#style-guidelines--naming-conventions)
- [Creating a Pull Request](#creating-a-pull-request)
- [Code Reviews](#code-reviews)

There are a few ways to contribute, which we'll enumerate below:

<a name="improvements-to-the-codebase"></a>
## Improvements to the Codebase

We welcome direct contributions to the sendgrid-java code base. Thank you!

Please note that we utilize the [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) for Git to help keep project development organized and consistent.

### Development Environment ###

#### Install and Run Locally ####

##### Prerequisites #####

- Java 8 or 11
- [java-http-client](https://github.com/sendgrid/java-http-client)

##### Initial setup: #####

```bash
git clone https://github.com/sendgrid/sendgrid-java.git
cd sendgrid-java
```

### Environment Variables

First, get your free Twilio SendGrid account [here](https://sendgrid.com/free?source=sendgrid-java).

Next, update your environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys).

```bash
echo "export SENDGRID_API_KEY='YOUR_API_KEY'" > sendgrid.env
echo "sendgrid.env" >> .gitignore
source ./sendgrid.env
./gradlew build
```

##### Execute: #####

See the [examples folder](examples) to get started quickly.

Check out the documentation for [Web API v3 endpoints](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html).

```bash
./gradlew build
cd examples
touch Example.java
```

Add the example you want to test to Example.java, including the headers at the top of the file.

``` bash
javac -classpath ../repo/com/sendgrid/4.10.3/sendgrid-4.10.3-jar.jar:. Example.java && java -classpath ../repo/com/sendgrid/4.10.3/sendgrid-4.10.3-jar.jar:. Example
```

<a name="understanding-the-codebase"></a>
## Understanding the Code Base

**/examples**

Working examples that demonstrate usage.

**/src/test**

Unit and integration tests.

**/src/main**

The interface to the Twilio SendGrid API.

<a name="testing"></a>
## Testing

All PRs require passing tests before the PR will be reviewed.

All test files are in the [`tests`](src/test/java/com/sendgrid) directory.

For the purposes of contributing to this repo, please update the [`SendGridTest.java`](src/test/java/com/sendgrid/SendGridTest.java) file with unit tests as you modify the code.

The integration tests require a Twilio SendGrid mock API in order to execute. We've simplified setting this up using Docker to run the tests. You will just need [Docker Desktop](https://docs.docker.com/get-docker/) and `make`.

Once these are available, simply execute the Docker test target to run all tests: `make test-docker`. This command can also be used to open an interactive shell into the container where this library is installed. To start a *bash* shell for example, use this command: `command=bash make test-docker`.

<a name="style-guidelines-and-naming-conventions"></a>
## Style Guidelines & Naming Conventions

Generally, we follow the style guidelines as suggested by the official language. However, we ask that you conform to the styles that already exist in the library. If you wish to deviate, please explain your reasoning.

Please run your code through:
- [FindBugs](http://findbugs.sourceforge.net/)
- [CheckStyle](http://checkstyle.sourceforge.net/) with [Google's Java Style Guide](https://google.github.io/styleguide/javaguide.html).

<a name="creating-a-pull-request"></a>
## Creating a Pull Request


1. [Fork](https://help.github.com/fork-a-repo/) the project, clone your fork,
   and configure the remotes:

   ```bash
   # Clone your fork of the repo into the current directory
   git clone https://github.com/sendgrid/sendgrid-java

   # Navigate to the newly cloned directory
   cd sendgrid-java

   # Assign the original repo to a remote called "upstream"
   git remote add upstream https://github.com/sendgrid/sendgrid-java
   ```

2. If you cloned a while ago, get the latest changes from upstream:

   ```bash
   git checkout <dev-branch>
   git pull upstream <dev-branch>
   ```

3. Create a new topic branch (off the main project development branch) to
   contain your feature, change, or fix:

   ```bash
   git checkout -b <topic-branch-name> development
   ```

4. Commit your changes in logical chunks. Please adhere to these [git commit
   message guidelines](http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html)
   or your code is unlikely be merged into the main project. Use Git's
   [interactive rebase](https://help.github.com/articles/interactive-rebase)
   feature to tidy up your commits before making them public.

4a. Create tests.

4b. Create or update the example code that demonstrates the functionality of this change to the code.

5. Locally merge (or rebase) the upstream `development` branch into your topic branch:

   ```bash
   git pull [--rebase] upstream development
   ```

6. Push your topic branch up to your fork:

   ```bash
   git push origin <topic-branch-name>
   ```

7. [Open a Pull Request](https://help.github.com/articles/using-pull-requests/)
    with a clear title and description against the `main` branch. All tests must be passing before we will review the PR.

## Code Reviews<a name="code-reviews"></a>
If you can, please look at open PRs and review them. Give feedback and help us merge these PRs much faster! If you don't know how, GitHub has some <a href="https://help.github.com/articles/about-pull-request-reviews/">great information on how to review a Pull Request.</a>

Hello! Thank you for choosing to help contribute to one of the Twilio SendGrid open source libraries. There are many ways you can contribute and help is always welcome. We simply ask that you follow the following contribution policies.

**All third party contributors acknowledge that any contributions they provide will be made under the same open source license that the open source project is provided under.**

- [Feature Request](#feature-request)
- [Submit a Bug Report](#submit-a-bug-report)
  - [Please use our Bug Report Template](#please-use-our-bug-report-template)
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

<a name="roadmap"></a>
We use [Milestones](https://github.com/sendgrid/sendgrid-java/milestones) to help define current roadmaps, please feel free to grab an issue from the current milestone. Please indicate that you have begun work on it to avoid collisions. Once a PR is made, community review, comments, suggestions and additional PRs are welcomed and encouraged.

There are a few ways to contribute, which we'll enumerate below:

<a name="feature-request"></a>
## Feature Request

If you'd like to make a feature request, please read this section.

The GitHub issue tracker is the preferred channel for library feature requests, but please respect the following restrictions:

- Please **search for existing issues** in order to ensure we don't have duplicate bugs/feature requests.
- Please be respectful and considerate of others when commenting on issues

<a name="submit-a-bug-report"></a>
## Submit a Bug Report

Note: DO NOT include your credentials in ANY code examples, descriptions, or media you make public.

A software bug is a demonstrable issue in the code base. In order for us to diagnose the issue and respond as quickly as possible, please add as much detail as possible into your bug report.

Before you decide to create a new issue, please try the following:

1. Check the GitHub issues tab if the identified issue has already been reported, if so, please add a +1 to the existing post.
2. Update to the latest version of this code and check if issue has already been fixed
3. Copy and fill in the Bug Report Template we have provided below

### Please use our Bug Report Template

In order to make the process easier, we've included a [sample bug report template](https://github.com/sendgrid/sendgrid-java/blob/master/ISSUE_TEMPLATE.md) (borrowed from [Ghost](https://github.com/TryGhost/Ghost/)). The template uses [GitHub flavored markdown](https://help.github.com/articles/github-flavored-markdown/) for formatting.

<a name="improvements-to-the-codebase"></a>
## Improvements to the Codebase

We welcome direct contributions to the sendgrid-java code base. Thank you!

Please note that we utilize the [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) for Git to help keep project development organized and consistent.

### Development Environment ###

#### Install and Run Locally ####

##### Prerequisites #####

- Java version Oracle JDK 7, 8 or OpenJDK 7
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

See the [examples folder](https://github.com/sendgrid/sendgrid-java/tree/master/examples) to get started quickly.

Check out the documentation for [Web API v3 endpoints](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html).

```bash
./gradlew build
cd examples
touch Example.java
```

Add the example you want to test to Example.java, including the headers at the top of the file.

``` bash
javac -classpath ../repo/com/sendgrid/4.4.2/sendgrid-4.4.2-jar.jar:. Example.java && java -classpath ../repo/com/sendgrid/4.4.2/sendgrid-4.4.2-jar.jar:. Example
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

All test files are in the [`tests`](https://github.com/sendgrid/sendgrid-java/tree/master/src/test/java/com/sendgrid) directory.

For the purposes of contributing to this repo, please update the [`SendGridTest.java`](https://github.com/sendgrid/sendgrid-java/tree/master/src/test/java/com/sendgrid/SendGridTest.java) file with unit tests as you modify the code.

1. Download [prism](http://stoplight.io/platform/prism/) for your platform ([Mac OS X](https://github.com/stoplightio/prism/releases/download/v0.6.21/prism_darwin_amd64), [Linux](https://github.com/stoplightio/prism/releases/download/v0.6.21/prism_linux_amd64), [Windows](https://github.com/stoplightio/prism/releases/download/v0.6.21/prism_windows_amd64.exe)) and save the binary to the sendgrid-java directory (or any directory you would like. The sendgrid-java directory is chosen mostly for convenience.)

1. Add execute permissions

   ```bash
   chmod +x prism
   ```

1. In a separate terminal, cd into the directory you chose for prism and start the sendgrid local server which the tests will use.

   ```bash
   ./prism run --mock --list --spec https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/oai_stoplight.json
   ```

1. Now you can run the test suite from the root of the project

   ```bash
   ./gradlew test -i
   ```

<a name="style-guidelines-and-naming-conventions"></a>
## Style Guidelines & Naming Conventions

Generally, we follow the style guidelines as suggested by the official language. However, we ask that you conform to the styles that already exist in the library. If you wish to deviate, please explain your reasoning.

Please run your code through:
- [FindBugs](http://findbugs.sourceforge.net/)
- [CheckStyle](http://checkstyle.sourceforge.net/) with [Google's Java Style Guide](http://checkstyle.sourceforge.net/reports/google-java-style.html).

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
    with a clear title and description against the `development` branch. All tests must be passing before we will review the PR.

If you have any additional questions, please feel free to [email](mailto:dx@sendgrid.com) us or create an issue in this repo.

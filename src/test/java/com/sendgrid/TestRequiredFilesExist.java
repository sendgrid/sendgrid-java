package com.sendgrid;

import static org.junit.Assert.assertTrue;

import java.io.File;
import org.junit.Test;

public class TestRequiredFilesExist {

  // ./Dockerfile
  @Test
  public void checkDockerExists() {
    assertTrue(new File("./Dockerfile").exists());
  }

  // ./.env_sample
  @Test
  public void checkEnvSampleExists() {
    assertTrue(new File("./.env_sample").exists());
  }

  // ./.gitignore
  @Test
  public void checkGitIgnoreExists() {
    assertTrue(new File("./.gitignore").exists());
  }

  // ./CHANGELOG.md
  @Test
  public void checkChangelogExists() {
    assertTrue(new File("./CHANGELOG.md").exists());
  }

  // ./CODE_OF_CONDUCT.md
  @Test
  public void checkCodeOfConductExists() {
    assertTrue(new File("./CODE_OF_CONDUCT.md").exists());
  }

  // ./CONTRIBUTING.md
  @Test
  public void checkContributingGuideExists() {
    assertTrue(new File("./CONTRIBUTING.md").exists());
  }

  // ./ISSUE_TEMPLATE.md
  @Test
  public void checkIssuesTemplateExists() {
    assertTrue(new File("./ISSUE_TEMPLATE.md").exists());
  }

  // ./LICENSE
  @Test
  public void checkLicenseExists() {
    assertTrue(new File("./LICENSE").exists());
  }

  // ./PULL_REQUEST_TEMPLATE.md
  @Test
  public void checkPullRequestExists() {
    assertTrue(new File("./PULL_REQUEST_TEMPLATE.md").exists());
  }

  // ./README.md
  @Test
  public void checkReadMeExists() {
    assertTrue(new File("./README.md").exists());
  }

  // ./TROUBLESHOOTING.md
  @Test
  public void checkTroubleShootingGuideExists() {
    assertTrue(new File("./TROUBLESHOOTING.md").exists());
  }

  // ./USAGE.md
  @Test
  public void checkUsageGuideExists() {
    assertTrue(new File("./USAGE.md").exists());
  }
}

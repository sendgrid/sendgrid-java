import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class TestRequiredFilesExist {

    // ./Docker or docker/Docker
    @Test public void checkDockerExists() {
        boolean dockerExists = new File("./Dockerfile").exists() ||
        new File("./docker/Dockerfile").exists();
        assertTrue(dockerExists);
    }

    // // ./docker-compose.yml or ./docker/docker-compose.yml
    // @Test public void checkDockerComposeExists() {
    //     boolean dockerComposeExists = new File("./docker-compose.yml").exists() ||
    //     new File("./docker/docker-compose.yml").exists();
    //     assertTrue(dockerComposeExists);
    // }

    // ./.env_sample
    @Test public void checkEnvSampleExists() {
        assertTrue(new File("./.env_sample").exists());
    }

    // ./.gitignore
    @Test public void checkGitIgnoreExists() {
        assertTrue(new File("./.gitignore").exists());
    }

    // ./.travis.yml
    @Test public void checkTravisExists() {
        assertTrue(new File("./.travis.yml").exists());
    }

    // ./.codeclimate.yml
    @Test public void checkCodeClimateExists() {
        assertTrue(new File("./.codeclimate.yml").exists());
    }

    // ./CHANGELOG.md
    @Test public void checkChangelogExists() {
        assertTrue(new File("./CHANGELOG.md").exists());
    }

    // ./CODE_OF_CONDUCT.md
    @Test public void checkCodeOfConductExists() {
        assertTrue(new File("./CODE_OF_CONDUCT.md").exists());
    }

    // ./CONTRIBUTING.md
    @Test public void checkContributingGuideExists() {
        assertTrue(new File("./CONTRIBUTING.md").exists());
    }

    // ./.github/ISSUE_TEMPLATE
    @Test public void checkIssuesTemplateExists() {
        assertTrue(new File("./.github/ISSUE_TEMPLATE").exists());
    }

    // ./LICENSE.md
    @Test public void checkLicenseExists() {
        assertTrue(new File("./LICENSE.md").exists());
    }

    // ./.github/PULL_REQUEST_TEMPLATE
    @Test public void checkPullRequestExists() {
        assertTrue(new File("./.github/PULL_REQUEST_TEMPLATE").exists());
    }

    // ./README.md
    @Test public void checkReadMeExists() {
        assertTrue(new File("./README.md").exists());
    }

    // ./TROUBLESHOOTING.md
    @Test public void checkTroubleShootingGuideExists() {
        assertTrue(new File("./TROUBLESHOOTING.md").exists());
    }

    // ./USAGE.md
    @Test public void checkUsageGuideExists() {
        assertTrue(new File("./USAGE.md").exists());
    }

    // ./USE_CASES.md
    @Test public void checkUseCases() {
        assertTrue(new File("./USE_CASES.md").exists());
    }
}

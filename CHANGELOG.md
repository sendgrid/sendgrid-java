# Change Log
All notable changes to this project will be documented in this file.

[2024-09-18] Version 4.10.3
---------------------------
**Library - Chore**
- [PR #767](https://github.com/sendgrid/sendgrid-java/pull/767): move Bouncy Castle dependency to test scope. Thanks to [@tiwarishubham635](https://github.com/tiwarishubham635)!


[2024-02-14] Version 4.10.2
---------------------------
**Library - Chore**
- [PR #745](https://github.com/sendgrid/sendgrid-java/pull/745): update jackson version and licence year. Thanks to [@tiwarishubham635](https://github.com/tiwarishubham635)!


[2023-11-17] Version 4.10.1
---------------------------
**Library - Chore**
- [PR #744](https://github.com/sendgrid/sendgrid-java/pull/744): updates bouncy castle to 1.76 (latest 1.7x). Thanks to [@mrdziuban](https://github.com/mrdziuban)!
- [PR #741](https://github.com/sendgrid/sendgrid-java/pull/741): updates bouncy castle to 1.75 (latest 1.7x). Thanks to [@kebeda](https://github.com/kebeda)!


[2023-11-06] Version 4.10.0
---------------------------
**Library - Feature**
- [PR #743](https://github.com/sendgrid/sendgrid-java/pull/743): Add data residency for eu and global regions. Thanks to [@shrutiburman](https://github.com/shrutiburman)!

**Library - Test**
- [PR #735](https://github.com/sendgrid/sendgrid-java/pull/735): Adding misc as PR type. Thanks to [@rakatyal](https://github.com/rakatyal)!


[2022-06-29] Version 4.9.3
--------------------------
**Library - Chore**
- [PR #727](https://github.com/sendgrid/sendgrid-java/pull/727): bump jackson-databind from 2.13.2 to 2.13.3. Thanks to [@dependabot](https://github.com/dependabot)!


[2022-05-18] Version 4.9.2
--------------------------
**Library - Docs**
- [PR #732](https://github.com/sendgrid/sendgrid-java/pull/732): Modify README.md in alignment with SendGrid Support. Thanks to [@garethpaul](https://github.com/garethpaul)!

**Library - Chore**
- [PR #726](https://github.com/sendgrid/sendgrid-java/pull/726): security upgrade jackson-databind from 2.13.0 to 2.13.2. Thanks to [@tomoyaY](https://github.com/tomoyaY)!

**Library - Fix**
- [PR #725](https://github.com/sendgrid/sendgrid-java/pull/725): override default gh token. Thanks to [@beebzz](https://github.com/beebzz)!


[2022-03-23] Version 4.9.1
--------------------------
**Library - Chore**
- [PR #723](https://github.com/sendgrid/sendgrid-java/pull/723): Security upgrade com.fasterxml.jackson.core:jackson-databind from 2.12.1 to 2.13.0. Thanks to [@svcprodsec-sendgrid](https://github.com/svcprodsec-sendgrid)!


[2022-03-09] Version 4.9.0
--------------------------
**Library - Chore**
- [PR #721](https://github.com/sendgrid/sendgrid-java/pull/721): push Datadog Release Metric upon deploy success. Thanks to [@eshanholtz](https://github.com/eshanholtz)!

**Library - Feature**
- [PR #717](https://github.com/sendgrid/sendgrid-java/pull/717): add GH action to update dependencies. Thanks to [@JenniferMah](https://github.com/JenniferMah)!


[2022-02-09] Version 4.8.3
--------------------------
**Library - Chore**
- [PR #716](https://github.com/sendgrid/sendgrid-java/pull/716): add gh release to workflow. Thanks to [@shwetha-manvinkurke](https://github.com/shwetha-manvinkurke)!
- [PR #715](https://github.com/sendgrid/sendgrid-java/pull/715): merge test and deploy workflows. Thanks to [@Hunga1](https://github.com/Hunga1)!


[2022-01-12] Version 4.8.2
--------------------------
**Library - Fix**
- [PR #713](https://github.com/sendgrid/sendgrid-java/pull/713): fix sendgrid-java unit tests. Thanks to [@beebzz](https://github.com/beebzz)!

**Library - Chore**
- [PR #712](https://github.com/sendgrid/sendgrid-java/pull/712): update license year. Thanks to [@JenniferMah](https://github.com/JenniferMah)!


[2021-12-01] Version 4.8.1
--------------------------
**Library - Chore**
- [PR #710](https://github.com/sendgrid/sendgrid-java/pull/710): fix pom for release. Thanks to [@eshanholtz](https://github.com/eshanholtz)!
- [PR #709](https://github.com/sendgrid/sendgrid-java/pull/709): migrate to github actions. Thanks to [@eshanholtz](https://github.com/eshanholtz)!


[2021-11-03] Version 4.8.0
--------------------------
**Library - Fix**
- [PR #707](https://github.com/sendgrid/sendgrid-java/pull/707): Add missing bypass settings to MailSettings. Thanks to [@arkitex](https://github.com/arkitex)!

**Library - Feature**
- [PR #706](https://github.com/sendgrid/sendgrid-java/pull/706): allow personalization of the From name and email for each email recipient. Thanks to [@beebzz](https://github.com/beebzz)!


[2021-10-18] Version 4.7.6
--------------------------
**Library - Docs**
- [PR #705](https://github.com/sendgrid/sendgrid-java/pull/705): improve signed webhook events docs. Thanks to [@shwetha-manvinkurke](https://github.com/shwetha-manvinkurke)!


[2021-09-22] Version 4.7.5
--------------------------
**Library - Chore**
- [PR #703](https://github.com/sendgrid/sendgrid-java/pull/703): update docker. Thanks to [@eshanholtz](https://github.com/eshanholtz)!


[2021-08-11] Version 4.7.4
--------------------------
**Library - Chore**
- [PR #694](https://github.com/sendgrid/sendgrid-java/pull/694): [Snyk] Security upgrade com.sendgrid:java-http-client from 4.3.6 to 4.3.7. Thanks to [@svcprodsec-sendgrid](https://github.com/svcprodsec-sendgrid)!


[2021-06-30] Version 4.7.3
--------------------------
**Library - Docs**
- [PR #679](https://github.com/sendgrid/sendgrid-java/pull/679): Fix number of free emails in README. Thanks to [@mjjs](https://github.com/mjjs)!


[2021-02-24] Version 4.7.2
--------------------------
**Library - Chore**
- [PR #671](https://github.com/sendgrid/sendgrid-java/pull/671): bump jackson.version from 2.10.2 to 2.12.1. Thanks to [@dependabot](https://github.com/dependabot)!


[2020-12-16] Version 4.7.1
--------------------------
**Library - Fix**
- [PR #657](https://github.com/sendgrid/sendgrid-java/pull/657): Utilize headers set on the Request object. Thanks to [@prputnam](https://github.com/prputnam)!


[2020-11-18] Version 4.7.0
--------------------------
**Library - Docs**
- [PR #656](https://github.com/sendgrid/sendgrid-java/pull/656): Fix broken link in readme. Thanks to [@KakeJopulsky](https://github.com/KakeJopulsky)!
- [PR #405](https://github.com/sendgrid/sendgrid-java/pull/405): Create use-cases directory. Thanks to [@jamietanna](https://github.com/jamietanna)!
- [PR #418](https://github.com/sendgrid/sendgrid-java/pull/418): Fixes Javadoc errors in Attachments.java. Thanks to [@pacbac](https://github.com/pacbac)!
- [PR #628](https://github.com/sendgrid/sendgrid-java/pull/628): Correct number of free emails. Thanks to [@twogood](https://github.com/twogood)!
- [PR #304](https://github.com/sendgrid/sendgrid-java/pull/304): Save attachment to Dropbox. Thanks to [@deepapanwar](https://github.com/deepapanwar)!
- [PR #357](https://github.com/sendgrid/sendgrid-java/pull/357): Fix code issues in examples/clients/clients.java. Thanks to [@pushkyn](https://github.com/pushkyn)!

**Library - Feature**
- [PR #292](https://github.com/sendgrid/sendgrid-java/pull/292): Add helper for get unassigned IPs. Thanks to [@pushkyn](https://github.com/pushkyn)!


[2020-11-05] Version 4.6.8
--------------------------
**Library - Chore**
- [PR #651](https://github.com/sendgrid/sendgrid-java/pull/651): Fix PR link for PRs. Thanks to [@jsoref](https://github.com/jsoref)!
- [PR #650](https://github.com/sendgrid/sendgrid-java/pull/650): fix spelling typos. Thanks to [@jsoref](https://github.com/jsoref)!


[2020-10-14] Version 4.6.7
--------------------------
**Library - Docs**
- [PR #360](https://github.com/sendgrid/sendgrid-java/pull/360): reorganize examples. Thanks to [@derjayjay](https://github.com/derjayjay)!


[2020-09-28] Version 4.6.6
--------------------------
**Library - Docs**
- [PR #504](https://github.com/sendgrid/sendgrid-java/pull/504): Update documentation for GET /templates. Thanks to [@LinkedList](https://github.com/LinkedList)!

**Library - Fix**
- [PR #649](https://github.com/sendgrid/sendgrid-java/pull/649): update the eventwebhook sample data, example, tests, and byte handling. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-09-16] Version 4.6.5
--------------------------
**Library - Docs**
- [PR #477](https://github.com/sendgrid/sendgrid-java/pull/477): Run *.md documents through Grammar.ly. Thanks to [@vinird](https://github.com/vinird)!


[2020-08-19] Version 4.6.4
--------------------------
**Library - Docs**
- [PR #491](https://github.com/sendgrid/sendgrid-java/pull/491): add contribution guide for first-timers. Thanks to [@daniloff200](https://github.com/daniloff200)!

**Library - Test**
- [PR #496](https://github.com/sendgrid/sendgrid-java/pull/496): Add spotbugs and checkstyle maven plugins for Travis CI. Thanks to [@rosariopfernandes](https://github.com/rosariopfernandes)!

**Library - Chore**
- [PR #644](https://github.com/sendgrid/sendgrid-java/pull/644): update GitHub branch references to use HEAD. Thanks to [@thinkingserious](https://github.com/thinkingserious)!


[2020-08-05] Version 4.6.3
--------------------------
**Library - Chore**
- [PR #539](https://github.com/sendgrid/sendgrid-java/pull/539): tidied up a little. Thanks to [@RohanTalip](https://github.com/RohanTalip)!

**Library - Docs**
- [PR #370](https://github.com/sendgrid/sendgrid-java/pull/370): breakup examples to their own files in examples/user/user.java. Thanks to [@rivenhk](https://github.com/rivenhk)!
- [PR #390](https://github.com/sendgrid/sendgrid-java/pull/390): Update README link to avoid redirection. Thanks to [@Rolstenhouse](https://github.com/Rolstenhouse)!

**Library - Fix**
- [PR #643](https://github.com/sendgrid/sendgrid-java/pull/643): Replace `bcprov-jdk15to18` with `bcprov-jdk15on`. Thanks to [@Stephan202](https://github.com/Stephan202)!
- [PR #642](https://github.com/sendgrid/sendgrid-java/pull/642): remove the content verifier. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-07-22] Version 4.6.2
--------------------------
**Library - Chore**
- [PR #639](https://github.com/sendgrid/sendgrid-java/pull/639): migrate to new default sendgrid-oai branch. Thanks to [@eshanholtz](https://github.com/eshanholtz)!

**Library - Docs**
- [PR #638](https://github.com/sendgrid/sendgrid-java/pull/638): add multi-recipient examples. Thanks to [@childish-sambino](https://github.com/childish-sambino)!
- [PR #637](https://github.com/sendgrid/sendgrid-java/pull/637): fix the kitchen sink example and link to it in the use cases doc. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-07-08] Version 4.6.1
--------------------------
**Library - Fix**
- [PR #635](https://github.com/sendgrid/sendgrid-java/pull/635): don't use dependency version ranges. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-06-10] Version 4.6.0
--------------------------
**Library - Feature**
- [PR #626](https://github.com/sendgrid/sendgrid-java/pull/626): add prism Docker setup. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-05-13] Version 4.5.0
--------------------------
**Library - Feature**
- [PR #622](https://github.com/sendgrid/sendgrid-java/pull/622): verify signature from event webhook. Thanks to [@anujs3](https://github.com/anujs3)!
- [PR #621](https://github.com/sendgrid/sendgrid-java/pull/621): add support for Twilio Email. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-04-15] Version 4.4.8
--------------------------
**Library - Fix**
- [PR #618](https://github.com/sendgrid/sendgrid-java/pull/618): correct the User-Agent casing. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-04-01] Version 4.4.7
--------------------------
**Library - Docs**
- [PR #617](https://github.com/sendgrid/sendgrid-java/pull/617): support verbiage for login issues. Thanks to [@adamchasetaylor](https://github.com/adamchasetaylor)!
- [PR #615](https://github.com/sendgrid/sendgrid-java/pull/615): fix link to jar file. Thanks to [@eshanholtz](https://github.com/eshanholtz)!

**Library - Fix**
- [PR #612](https://github.com/sendgrid/sendgrid-java/pull/612): correct the serialization of Setting to include non-null values. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-03-18] Version 4.4.6
--------------------------
**Library - Docs**
- [PR #264](https://github.com/sendgrid/sendgrid-java/pull/264): Overhaul javadocs, using Oracle's styleguide. Thanks to [@jamierocks](https://github.com/jamierocks)!

**Library - Chore**
- [PR #610](https://github.com/sendgrid/sendgrid-java/pull/610): fix JDK Travis failures. Thanks to [@childish-sambino](https://github.com/childish-sambino)!


[2020-02-19] Version 4.4.5
--------------------------
**Library - Docs**
- [PR #540](https://github.com/sendgrid/sendgrid-java/pull/540): Update the link for Google's Style Guide. Thanks to [@RohanTalip](https://github.com/RohanTalip)!


[2020-02-08] Version 4.4.4
--------------------------
**Library - Fix**
- [PR #608](https://github.com/sendgrid/sendgrid-java/pull/608): update release jar. Thanks to [@eshanholtz](https://github.com/eshanholtz)!


[2020-02-05] Version 4.4.3
--------------------------
**Library - Docs**
- [PR #604](https://github.com/sendgrid/sendgrid-java/pull/604): Fix GitHub spelling. Thanks to [@friederbluemle](https://github.com/friederbluemle)!
- [PR #534](https://github.com/sendgrid/sendgrid-java/pull/534): Fix whitespace errors and typos. Thanks to [@friederbluemle](https://github.com/friederbluemle)!
- [PR #402](https://github.com/sendgrid/sendgrid-java/pull/402): Add Code Review to Contributing.md. Thanks to [@derekneuland](https://github.com/derekneuland)!
- [PR #603](https://github.com/sendgrid/sendgrid-java/pull/603): baseline all the templated markdown docs. Thanks to [@childish-sambino](https://github.com/childish-sambino)!
- [PR #387](https://github.com/sendgrid/sendgrid-java/pull/387): makes Environmental Variables a sub topic in CONTRIBUTING.md. Thanks to [@thepriefy](https://github.com/thepriefy)!
- [PR #516](https://github.com/sendgrid/sendgrid-java/pull/516): fix a minor type in README. Thanks to [@anuragsachdeva28](https://github.com/anuragsachdeva28)!
- [PR #590](https://github.com/sendgrid/sendgrid-java/pull/590): fix typo in README. Thanks to [@brianjester](https://github.com/brianjester)!

**Library - Chore**
- [PR #542](https://github.com/sendgrid/sendgrid-java/pull/542): Removed the apiKey instance variable as it wasn't being used. Thanks to [@RohanTalip](https://github.com/RohanTalip)!
- [PR #563](https://github.com/sendgrid/sendgrid-java/pull/563): Remove unnecessary access modifiers on interface methods. Thanks to [@ethanwood17](https://github.com/ethanwood17)!
- [PR #602](https://github.com/sendgrid/sendgrid-java/pull/602): Bump jackson.version from 2.9.9 to 2.10.2. Thanks to [@dependabot](https://github.com/dependabot)!


[2020-02-01] Version 4.4.2
--------------------------
**Library - Chore**
- [PR #471](https://github.com/sendgrid/sendgrid-java/pull/471): Update build.gradle. Thanks to [@doilio](https://github.com/doilio)!
- [PR #557](https://github.com/sendgrid/sendgrid-java/pull/557): Update Jackson dependencies to the latest version. Thanks to [@wkurniawan07](https://github.com/wkurniawan07)!
- [PR #574](https://github.com/sendgrid/sendgrid-java/pull/574): maven-compiler-plugin 3.8.1. Thanks to [@sullis](https://github.com/sullis)!
- [PR #599](https://github.com/sendgrid/sendgrid-java/pull/599): prep the repo for automated release. Thanks to [@eshanholtz](https://github.com/eshanholtz)!


[2019-05-20] Version 4.4.1
---------------------------
### Fix
- 4.4.0 release not deployed properly to Maven

## [4.4.0] - 2019-05-20
### Added
- [PR #500](https://github.com/sendgrid/sendgrid-java/pull/500/files): Update CONTRIBUTING.md - using gitflow workflow, development branch instead of main -- BIG thanks to [Alex](https://github.com/pushkyn)
- [PR #521](https://github.com/sendgrid/sendgrid-java/pull/521/files): Updating prerequisites -- BIG thanks to [Rishabh](https://github.com/Rishabh04-02)
- [PR #495](https://github.com/sendgrid/sendgrid-java/pull/495/files): Add ability to impersonate subusers -- BIG thanks to [Rohit Tarachandani](https://github.com/Rohit-T)
- [PR #569](https://github.com/sendgrid/sendgrid-java/pull/495/files): Twilio Branding + CLA Policy Update

### Fix
- [PR #497](https://github.com/sendgrid/sendgrid-java/pull/497): USE_CASES.md was missing the subject in the template and the dynamic data for the subject -- BIG thanks to [Kyle Roberts](https://github.com/kylearoberts)
- [PR #306](https://github.com/sendgrid/sendgrid-java/pull/306): Java packages were not corresponding to the actual location of classes,
all packages were update to match class location -- BIG thanks to [Bojan Trajkovski](https://github.com/btrajkovski)
- [PR #544](https://github.com/sendgrid/sendgrid-java/pull/544): Remove references to "Whitelabel" -- BIG thanks to [Chandler Weiner](https://github.com/crweiner)
- [PR #507](https://github.com/sendgrid/sendgrid-java/pull/507): Update TROUBLESHOOTING.md broken link -- BIG thanks to [Andrew Joshua Loria](https://github.com/ajloria)

## [4.3.0] - 2018-10-11
### Added
- [PR #449](https://github.com/sendgrid/sendgrid-java/pull/449/files): Dynamic Templates support -- BIG thanks to [Marcus Vinícius](https://github.com/Markuus13)
- [PR #451](https://github.com/sendgrid/sendgrid-java/pull/451/files): Added CodeTriage tag -- BIG thanks to [Anshul Singhal](https://github.com/af4ro)
- [PR #453](https://github.com/sendgrid/sendgrid-java/pull/453/files): Documentation readability update -- BIG thanks to [Anshul Singhal](https://github.com/af4ro)
- [PR #461](https://github.com/sendgrid/sendgrid-java/pull/461/files): Update README to use implementation instead of compile -- BIG thanks to [Rosário Pereira Fernandes](https://github.com/rosariopfernandes)
- [PR #463](https://github.com/sendgrid/sendgrid-java/pull/463/files): Link to the online version of CLA in README.md -- BIG thanks to [Bharat Raghunathan](https://github.com/Bharat123rox)

### Fix
- [PR #358](https://github.com/sendgrid/sendgrid-java/pull/358): Fixing similar code issue in examples/ips/ips.java -- BIG thanks to [Julian Jacques Maurer](https://github.com/derjayjay)
- [PR #475](https://github.com/sendgrid/sendgrid-java/pull/475): Fix formatting of README in examples/accesssettings -- BIG thanks to [Nathan Seebarran](https://github.com/nathan78906) 

## [4.2.1] - 2018-05-08
### Security Fix
- Update to the latest Jackson recommended dependency, based on [this article](https://medium.com/@cowtowncoder/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062).

## [4.2.0] - 2018-05-04
### Added
- [PR #275](https://github.com/sendgrid/sendgrid-java/pull/275/files): Add a way to verify that the content doesn't contain sensitive information -- BIG thanks to [Diego Camargo](https://github.com/belfazt)
- [PR #249](https://github.com/sendgrid/sendgrid-java/pull/249): Add optional rate limit support -- BIG thanks to [Andy Trimble](https://github.com/andy-trimble)
- [PR #379](https://github.com/sendgrid/sendgrid-java/pull/379): Break up the examples in examples/subusers/subusers.java to their own files -- BIG thanks to [huytranrjc](https://github.com/huytranrjc)
- [PR #365](https://github.com/sendgrid/sendgrid-java/pull/365): Test to check year in license file -- BIG thanks to [Alex](https://github.com/pushkyn)
- [PR #345](https://github.com/sendgrid/sendgrid-java/pull/345): Add .codeclimate.yml file -- BIG thanks to [Rostyslav Zatserkovnyi](https://github.com/rzats)
- [PR #319](https://github.com/sendgrid/sendgrid-java/pull/319): Add .env_sample file -- BIG thanks to [Thiago Barbato](https://github.com/thiagobbt)
- [PR #223](https://github.com/sendgrid/sendgrid-java/pull/223): The license file is now in the release jar -- BIG thanks to [sccalabr](https://github.com/sccalabr)
- [PR #224](https://github.com/sendgrid/sendgrid-java/pull/224): Adding SendGridApi interface -- BIG thanks to [sccalabr](https://github.com/sccalabr)

### Fix
- [PR #410](https://github.com/sendgrid/sendgrid-java/pull/410): Update Jackson dependencies to the latest version -- BIG thanks to [Dmitry Avershin](https://github.com/dmitraver)
- [PR #380](https://github.com/sendgrid/sendgrid-java/pull/380): Fix "similar-code" issue in examples/whitelabel/ips.java -- BIG thanks to [huytranrjc](https://github.com/huytranrjc)
- [PR #255](https://github.com/sendgrid/sendgrid-java/pull/225): Fix Mail deserialization issue -- BIG thanks to [sccalabr](https://github.com/sccalabr)
- [PR #359](https://github.com/sendgrid/sendgrid-java/pull/359): Fix code issue in examples/suppression/suppression.java -- BIG thanks to [Alex](https://github.com/pushkyn)
- [PR #228](https://github.com/sendgrid/sendgrid-java/pull/228): Changes serialization type from default to non-empty -- BIG thanks to [Dmitry Avershin](https://github.com/dmitraver)
- [PR #373](https://github.com/sendgrid/sendgrid-java/pull/373): Fix file_lines issue in examples/mailsettings/mailsettings.java -- BIG thanks to [Mithun Sasidharan](https://github.com/mithunsasidharan)


## [4.1.2] - 2017-10-30
### Added
- PR #220 Alway serialize click-tracking parameters.
- BIG thanks to [Mattia Barbon](https://github.com/mbarbon)

## [4.1.1] - 2017-10-10
### Added
- PR #247 Added Javadocs.
- BIG thanks to [Andy Trimble](https://github.com/andy-trimble)

## [4.1.0] - 2017-08-16
### Added
- PR #211 Return empty collections in place of nulls
- BIG thanks to [Antonio Bucciol](https://github.com/TBuc)

## [4.0.1] - 2017-05-22
### Fix
- PR #199 Return correct Email in getFrom
- BIG thanks to [Jared Dellitt](https://github.com/jareddellitt)

## [4.0.0] - 2017-04-18
### BREAKING CHANGE
- PR #162 Update java HTTP client dependency to [4.1.0 from 2.3.4](https://github.com/sendgrid/java-http-client/releases)
- BIG thanks to [Diego Camargo](https://github.com/belfazt) for the pull request!
- The breaking change is that variables that were public are now private and accessible only via getters and setters
- The `Request` object attributes are now only accessible through getters/setters
- `request.method` is now `request.setMethod(string)`
- `request.endpoint` is now `request.setEndpoint(string)`
- `request.body` is now `request.setBody(string)`
- The `Response` object attributes are now only accessible through getters/setters
- `response.statusCode` is now `response.getStatusCode()`
- `response.body` is now `response.getBody()`
- `response.headers` is now `response.getHeaders()`
- Adding a query parameter goes from:

```java
Map<String,String> queryParams = new HashMap<String, String>();
request.addQueryParam("limit", "1");
queryParams.put("limit", "1");
request.queryParams = queryParams;
```

to:

```java
request.addQueryParam("limit", "1");
```

## [3.2.1] - 2017-04-13
### Added
- PR #175
- Simplified method `makeCall()`. 
- BIG thanks to [Rafał Wrzeszcz](https://github.com/rafalwrzeszcz) for the pull request!

## [3.2.0] - 2017-03-22
### Added
- PR #160
- [Enhancement] Adds an attachment builder that supports InputStream content
- BIG thanks to [Dmitry Avershin](https://github.com/dmitraver) for the pull request!

## [3.1.0] - 2016-10-11
### Added
- PR #158, Solves #138
- [Enhancement] allow using custom Client, HTTP proxy support
- BIG thanks to [David Maicher](https://github.com/dmaicher) for the pull request!

## [3.0.9] - 2016-08-24
### Added
- Table of Contents in the README
- Added a [USE_CASES.md](USE_CASES.md) section, with the first use case example for transactional templates

## [3.0.8] - 2016-08-09
### Fixed
- Updated dependency for [java-http-client](https://github.com/sendgrid/java-http-client/releases/tag/v2.3.4)
- [Pull #7](https://github.com/sendgrid/java-http-client/pull/7): Fix Response Charset to UTF-8
- Fixes [issue #6](https://github.com/sendgrid/java-http-client/issues/6): Multi-byte character got garbled on received mail
- BIG thanks to [Yoichi Kikuta](https://github.com/kikutaro) for the pull request!

## [3.0.7] - 2016-08-08
### Added
- Updated dependency for [java-http-client](https://github.com/sendgrid/java-http-client/releases/tag/v2.3.3)
- Pull request [#11](https://github.com/sendgrid/java-http-client/pull/11)
- Solves [issue #10](https://github.com/sendgrid/java-http-client/issues/10): Improve Error Handling
- Now error messages are passed through from the SendGrid server
- BIG thanks to [shuron](https://github.com/shuron) / [Alexander Holbreich](https://github.com/aholbreich) for the pull request!

## [3.0.6] - 2016-07-26
### Added
- [Troubleshooting](TROUBLESHOOTING.md) section

## [3.0.5] - 2016-07-20
### Added
- README updates
- Update introduction blurb to include information regarding our forward path
- Update the v3 /mail/send example to include non-helper usage
- Update the generic v3 example to include non-fluent interface usage

## [3.0.4] - 2016-07-19
### Fixed
- [Fix for issue #120](https://github.com/sendgrid/sendgrid-java/issues/120): Unsupported Media Type if the subject has letters with an accent (like 'é' )
- Updated [java-http-client](https://github.com/sendgrid/java-http-client) dependency to [2.3.2](https://github.com/sendgrid/java-http-client/releases/tag/v2.3.2)

## [3.0.3] - 2016-07-12
### Added
- Update docs, unit tests and examples to include Sender ID

## [3.0.2] - 2016-07-05
### Updated
- Content based on our updated [Swagger/OAI doc](https://github.com/sendgrid/sendgrid-oai)

## [3.0.1] - 2016-06-28
### Fixed
- Accept header via [Get Satisfaction](https://community.sendgrid.com/sendgrid/topics/sendgrid-v3-webapi-issue-with-accept-header-response-406-not-acceptable)

## [3.0.0] - 2016-06-13
### Added
- Breaking change to support the v3 Web API
- New HTTP client
- v3 Mail Send helper

## [2.2.2] - 2015-5-23
### Fixed
- Substitution orders being swapped via [#65](https://github.com/sendgrid/sendgrid-java/pull/65)

## [2.2.1] - 2015-5-14
### Changed
- Update smtpapi-java to v1.2.0

## [2.2.0] - 2015-4-27
### Added
- Support for API keys
- setTemplateId to use the Template Engine

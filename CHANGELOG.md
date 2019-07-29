# Change Log
All notable changes to this project will be documented in this file.

## [4.4.1] - 2019-05-20
### Fix
- 4.4.0 release not deployed properly to Maven

## [4.4.0] - 2019-05-20
### Added
- [PR #500](https://github.com/sendgrid/sendgrid-java/pull/500/files): Update CONTRIBUTING.md - using gitflow workflow, development branch instead of master -- BIG thanks to [Alex](https://github.com/pushkyn)
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
- Update to latest Jackson recommended dependency, based on [this article](https://medium.com/@cowtowncoder/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062).

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
- PR #162 Update java http client dependency to [4.1.0 from 2.3.4](https://github.com/sendgrid/java-http-client/releases)
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
- Simplified `makeCall()` method.
- BIG thanks to [Rafał Wrzeszcz](https://github.com/rafalwrzeszcz) for the pull request!

## [3.2.0] - 2017-03-22
### Added
- PR #160
- [Enhancement] Adds an attachment builder that supports InputStream content
- BIG thanks to [Dmitry Avershin](https://github.com/dmitraver) for the pull request!

## [3.1.0] - 2016-10-11
### Added
- PR #158, Solves #138
- [Enhancement] allow using custom Client, http proxy support
- BIG thanks to [David Maicher](https://github.com/dmaicher) for the pull request!

## [3.0.9] - 2016-08-24
### Added
- Table of Contents in the README
- Added a [USE_CASES.md](https://github.com/sendgrid/sendgrid-java/blob/master/USE_CASES.md) section, with the first use case example for transactional templates

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
- [Troubleshooting](https://github.com/sendgrid/sendgrid-python/blob/master/TROUBLESHOOTING.md) section

## [3.0.5] - 2016-07-20
### Added
- README updates
- Update introduction blurb to include information regarding our forward path
- Update the v3 /mail/send example to include non-helper usage
- Update the generic v3 example to include non-fluent interface usage

## [3.0.4] - 2016-07-19
### Fixed
- [Fix for issue #120](https://github.com/sendgrid/sendgrid-java/issues/120): Unsupported Media Type if subject has letters with accent (like 'é' )
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

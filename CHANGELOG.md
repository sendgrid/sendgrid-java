# Change Log
All notable changes to this project will be documented in this file.

## [3.2.2] - 2018-05-08
### Security Fix
- Update to latest Jackson recommended dependency, based on [this article](https://medium.com/@cowtowncoder/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062).

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
- Subsitution orders being swapped via [#65](https://github.com/sendgrid/sendgrid-java/pull/65)

## [2.2.1] - 2015-5-14
### Changed
- Update smtpapi-java to v1.2.0

## [2.2.0] - 2015-4-27
### Added
- Support for API keys
- setTemplateId to use the Template Engine

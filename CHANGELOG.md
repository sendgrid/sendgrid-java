# Change Log
All notable changes to this project will be documented in this file.

## [3.0.7] - 2017-08-08
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

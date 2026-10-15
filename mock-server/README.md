# Mock SendGrid API for tests

`make test-docker` runs the test suite against a local mock of `api.sendgrid.com`:

- **prism**: [Prism](https://github.com/stoplightio/prism) v2.0.17 mocking `oai_stoplight.json`.
  The binary's sha256 is checked in `Dockerfile.prism`.
- **nginx**: answers TLS as `api.sendgrid.com` with the self-signed test certificate in
  `nginx/` and proxies to prism. The certificate and key exist only for this mock.
- **helper-runner**: the repo's root `Dockerfile`, which trusts that certificate and runs
  `make test-integ`.

`oai_stoplight.json` is vendored from `sendgrid/sendgrid-oai` at commit
`eb7a825bf06dfec7da2622735c5334c0d35da9fa`, the same commit the previous
remote `prism-java.sh` script pinned. These files used to be downloaded at test time
from that repository, which is no longer publicly readable.

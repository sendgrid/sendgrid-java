## Publishing to Maven

This only works if you have the correct permissions - for admins only basically.

Let's begin with the permissions.

```
cp gradle.properties.example ~/.gradle/gradle.properties
```

Edit that file and set your `sonatypeUsername` and sonatypePassword`. You also need to set the values for your keys. Here's how to list/create them. [1](http://central.sonatype.org/pages/working-with-pgp-signatures.html).

```
gpg --list-keys
gpg --gen-key
```

Set the signing.KeyId, signing.password, and the signing.secretKeyRingFile.

The signing.KeyId is the 'pub' one. It's the part of your list of keys that looks something like this: `2048R/5D64A177`. So in this scenario it would be `5D64A177`. [1](http://www.gradle.org/docs/current/userguide/signing_plugin.html) [2](http://yennicktrevels.com/blog/2013/10/11/automated-gradle-project-deployment-to-sonatype-oss-repository/)

The signing.password is the password you used when generating this key. It could be blank if you didn't use a password.

The signing.secretKeyRingFile is the path to the secring.gpg.

Now, upload that key to the keyserver.

```
gpg --keyserver hkp://pool.sks-keyservers.net --send-keys 5D64A177
```

Now, you can finally upload! Ah, Java!

```
./gradlew uploadArchives
```

Login to [Sonatype](https://oss.sonatype.org/index.html#stagingRepositories).

Go to [staging repositories page](https://oss.sonatype.org/index.html#stagingRepositories).

Click 'Close' with the archive selected.

![](https://raw.githubusercontent.com/sendgrid/sendgrid-java/master/maven-help.png)

Wait a few minutes, and refresh the staging repositories page.

Check the box for the SendGrid repo again and this time click 'Release'.

You're all done.

[Further help](https://github.com/sendgrid/sendgrid-java/pull/15).

# Maven CI-Friendly App management

## Context

This application depends on the repository ci-friendly-lib which is managed/built using a ci-friendly maven approach

In the application, we ensure library versions are not conflicting using the maven enforcer plugin.

From the library's standpoint, the practice of developing and releasing the library can be done several times a day if need be. The publication of the RELEASE versions can then be accessible for app developers to refer to and ensure they use the desired release.

## Version management for specific dependencies

_Note_: Keep in mind dependencies must have their versions hardcoded in version, not using properties placeholders. (see pom.xml dependency ci-friendly-lib)

### List available latest versions

```shell
./mvnw versions:display-dependency-updates
...
[INFO] --- versions-maven-plugin:2.10.0:display-dependency-updates (default-cli) @ ci-friendly-app ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.kevvlvl.cifriendly:ci-friendly-lib ................ 1.0.0 -> 1.0.1

```

We can see that RELEASE 1.0.1 is available as we are set to 1.0.0

Let's update our dep to use the latest available release

```shell
./mvnw versions:use-latest-releases                                                                                                                                                                         ci-friendly-app -> main !
...
[INFO] --- versions-maven-plugin:2.10.0:use-latest-releases (default-cli) @ ci-friendly-app ---
[INFO] Major version changes allowed
[INFO] Updated org.kevvlvl.cifriendly:ci-friendly-lib:jar:1.0.0 to version 1.0.1
```

Now, imagine we want again to point to the latest snapshot, perhaps because we're doing local development on this same depenendy, and we want to ensure our code pulls the snapshot from our local m2 repo, then we manually change the versions to the SNAPSHOT matching our local dev. 

Once we're complete and that a new release is available. Change back to release using these two steps:

- ``mvnw versions:use-releases`` Changes the snapshot versions to release.
- ``mvnw versions:use-latest-releases`` Sets to the latest found release.

```shell
 ./mvnw versions:use-releases 
 [INFO] --- versions-maven-plugin:2.10.0:use-releases (default-cli) @ ci-friendly-app ---
[INFO] Updated org.kevvlvl.cifriendly:ci-friendly-lib:jar:1.0.0-SNAPSHOT to version 1.0.0
...
./mvnw versions:use-latest-releases    
...
[INFO] --- versions-maven-plugin:2.10.0:use-latest-releases (default-cli) @ ci-friendly-app ---
[INFO] Major version changes allowed
[INFO] Updated org.kevvlvl.cifriendly:ci-friendly-lib:jar:1.0.0 to version 1.0.1
```
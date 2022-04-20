# Maven CI-Friendly App management

## Context

This application depends on the repository ci-friendly-lib which is managed/built using a ci-friendly maven approach

In the application, we ensure library versions are not conflicting using the maven enforcer plugin.

From the library's standpoint, the practice of developing and releasing the library can be done several times a day if need be. The publication of the RELEASE versions can then be accessible for app developers to refer to and ensure they use the desired release.
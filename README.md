### Android RxTasks
![Build Status](https://img.shields.io/travis/ashdavies/rx-tasks.svg)
![Coverage](https://img.shields.io/codecov/c/github/ashdavies/rx-tasks.svg)
![Version](https://img.shields.io/badge/version-1.1.3-yellowgreen.svg)
![License](https://img.shields.io/badge/license-apache%202.0-blue.svg)

**Simple and lightweight RxJava2 wrapper for the GMS Tasks API**
**https://developers.google.com/android/reference/com/google/android/gms/tasks/package-summary**

#### Description
`RxTasks` is a lightweight wrapper for the GMS Tasks API,
more commonly recognised when using asynchronous results from Firebase requests.

Typically the Tasks API would allow you to add listeners that may be scoped to an activity or executor,
however this is not needed since scheduling and `Disposable`'s are handled by the user.

Please note that this library uses RxJava2 so calls must respect Completable and Single chains.

#### Usage
Import to your project with the following statement
```android
    compile 'io.ashdavies.rx.tasks:1.1.3'
```
Any `Task` returned from the Google Mobile Services API can simply be wrapped in the appropriate call.
```android
    Single<AuthResult> result = Tasks.single(FirebaseAuth.getInstance().signInAnonymously());
```

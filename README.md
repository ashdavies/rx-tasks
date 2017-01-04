### Android RxTasks
![Build Status](https://img.shields.io/travis/ashdavies/android-rxtasks.svg)
![Coverage](https://img.shields.io/codecov/c/github/ashdavies/android-rxtasks.svg)
![Version](https://img.shields.io/badge/version-1.0.0-yellowgreen.svg)
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
    compile "io.ashdavies.rxtasks:1.0.0"
```
Any `Task` returned from the Google Mobile Services API can simply be wrapped in the appropriate call.
```android
    Single<AuthResult> result = RxTasks.single(FirebaseAuth.getInstance().signInAnonymously());
```

#### License
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

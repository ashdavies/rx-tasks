# Android RxTasks

[![](https://img.shields.io/circleci/project/github/ashdavies/rx-tasks.svg)](https://circleci.com/gh/ashdavies/rx-tasks)
[![](https://img.shields.io/codacy/coverage/03ae86d9ce934421879bc407aa157732.svg)](https://app.codacy.com/project/ash.davies/rx-tasks/dashboard)
[![](https://img.shields.io/maven-central/v/io.ashdavies.rx.rxtasks/rx-tasks.svg)](https://search.maven.org/artifact/io.ashdavies.rx.rxtasks/rx-tasks)
![](https://img.shields.io/github/license/ashdavies/rx-tasks.svg)

[![](https://img.shields.io/codacy/grade/03ae86d9ce934421879bc407aa157732.svg)](https://app.codacy.com/project/ash.davies/rx-tasks/dashboard)
[![](https://img.shields.io/github/last-commit/ashdavies/rx-tasks.svg)](https://github.com/ashdavies/rx-tasks/commits/master)
[![](https://img.shields.io/github/issues-pr/ashdavies/rx-tasks.svg)](https://github.com/ashdavies/rx-tasks/pulls)

**Simple and lightweight RxJava2 conversion for the [Google Tasks APIs](https://developers.google.com/android/guides/tasks)**

## The Tasks API
> Starting with Google Play services version 9.0.0, you can use a `Task` API and a number of methods that return `Task` or its subclasses. `Task` is an API that represents asynchronous method calls, similar to `PendingResult` in previous versions of Google Play Services.

## Usage
> A common method that returns a `Task` is `FirebaseAuth.signInAnonymously()`. It returns a `Task<AuthResult>` which means the task will return an `AuthResult` object when it succeeds.

For example the Firebase sign in API asynchronously returns an `AuthResult` which can be consumed via `toSingle` method as an extension of `Task<T>`.

If consuming from Java code, the class `RxTasks.toSingle<T>(task)` can be used, this is marked as the direct extensions `SingleTaskKt.toSingle<T>(Task<T>)` and `CompletableTaskKt.toCompletable(Task<*>)` should be preferred.

It is currently only possible to create a `Completable` from a `Task<Void>`, as this honours the correct API behaviour and it is not the responsibility of this library to convert between reactive types.

```kotlin
FirebaseAuth
  .getInstance()
  .signInAnonymously()
  .toSingle()
  .subscribe { /* ... */ }
```

**Gradle**
```groovy
implementation 'io.ashdavies.rx.rxtasks:rx-tasks:+'
```

**Kotlin DSL**
```kotlin
implementation(group = 'io.ashdavies.rx.rxtasks', name = 'rx-tasks', version = '2.1.2')
```

## Threading
> Listeners attached to a thread are run on the application main (UI) thread by default. When attaching a listener, you can also specify an `Executor` that is used to schedule listeners.

You may pass an `Executor` to the `Task` extension functions to relay to the Tasks API, to specify that the `Task` listener will execute on the provided `Executor`.

```kotlin
FirebaseAuth
  .getInstance()
  .signInAnonymously()
  .toSingle(Executor { Thread(it).run() })
  .subscribe { /* ... */ }
```

## Activity-scoped listeners
> If you are listening for task results in an `Activity`, you may want to add activity-scoped listeners to the task. These listeners are removed during the onStop method of your Activity so that your listeners are not called when the Activity is no longer visible.

Additionally, you may pass an `Activity` to the `Task` extension function to relay to the Tasks API, which will result in the `Task` listener being scoped to the provided `Activity` and will be removed during `onStop`.

```kotlin
FirebaseAuth
  .getInstance()
  .signInAnonymously()
  .toSingle(activity)
  .subscribe { /* ... */ }
```

## Future development
Further development for this libary has not been planned, and will soon become deprecated, it is recommended to use Kotlin [Coroutines integration](https://github.com/Kotlin/kotlinx.coroutines/tree/master/integration/kotlinx-coroutines-play-services) with Google Play Services [Tasks API](https://developers.google.com/android/guides/tasks).

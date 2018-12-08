package io.ashdavies.rx.rxtasks

import android.app.Activity
import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import java.util.concurrent.Executor

fun Task<Void>.toCompletable(): Completable = asCompletable { addOnCompleteListener(CompletableEmitterListener(it)) }
fun Task<Void>.toCompletable(executor: Executor): Completable = asCompletable { addOnCompleteListener(executor, CompletableEmitterListener(it)) }
fun Task<Void>.toCompletable(activity: Activity): Completable = asCompletable { addOnCompleteListener(activity, CompletableEmitterListener(it)) }

private fun Task<Void>.asCompletable(block: (CompletableEmitter) -> Unit) = if (isComplete) Completable.fromCallable(::asResult) else Completable.create(block)

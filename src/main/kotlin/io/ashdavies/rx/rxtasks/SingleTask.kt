package io.ashdavies.rx.rxtasks

import android.app.Activity
import com.google.android.gms.tasks.Task
import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.util.concurrent.Executor

fun <T : Any> Task<T>.toSingle(): Single<T> = asSingle { addOnCompleteListener(SingleEmitterListener(it)) }
fun <T : Any> Task<T>.toSingle(executor: Executor): Single<T> = asSingle { addOnCompleteListener(executor, SingleEmitterListener(it)) }
fun <T : Any> Task<T>.toSingle(activity: Activity): Single<T> = asSingle { addOnCompleteListener(activity, SingleEmitterListener(it)) }

private fun <T : Any> Task<T>.asSingle(block: (SingleEmitter<T>) -> Unit): Single<T> = if (isComplete) Single.fromCallable(::asRequired) else Single.create(block)

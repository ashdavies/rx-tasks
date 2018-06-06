package io.ashdavies.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import io.ashdavies.rx.rxtasks.toSingle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.greeting

class MainActivity : AppCompatActivity() {

  private var disposables: CompositeDisposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    signInAnonymously()
  }

  override fun onDestroy() {
    disposables.clear()
    super.onDestroy()
  }

  private fun signInAnonymously() {
    disposables += FirebaseAuth.getInstance()
        .signInAnonymously()
        .toSingle()
        .map { it.user.uid }
        .subscribe(::greetAnonymousUser)
  }

  private fun greetAnonymousUser(user: String) {
    greeting.text = getString(R.string.greeting_anonymous, user)
  }

  private operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
  }
}

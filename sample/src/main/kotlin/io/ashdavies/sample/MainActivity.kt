package io.ashdavies.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.ashdavies.rx.rxtasks.RxTasks
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private var disposables: CompositeDisposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    signInAnonymously()
  }

  override fun onDestroy() {
    super.onDestroy()
    dispose()
  }

  private fun dispose() {
    if (!disposables.isDisposed) {
      disposables.dispose()
    }
  }

  private fun signInAnonymously() {
    val disposable = RxTasks.single<AuthResult>(FirebaseAuth.getInstance().signInAnonymously())
        .subscribe { result -> greetAnonymousUser(result.getUser().getUid()) }

    disposables.add(disposable)
  }

  private fun greetAnonymousUser(user: String) {
    greeting.text = getString(R.string.greeting_anonymous, user)
  }
}

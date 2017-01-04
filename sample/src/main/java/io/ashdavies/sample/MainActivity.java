package io.ashdavies.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import io.ashdavies.rxtasks.RxTasks;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

  private CompositeDisposable disposables;

  private TextView greeting;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    disposables = new CompositeDisposable();
    greeting = (TextView) findViewById(R.id.greeting);

    signInAnonymously();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    dispose();
  }

  private void dispose() {
    if (disposables != null && disposables.isDisposed()) {
      disposables.dispose();
    }
  }

  private void signInAnonymously() {
    Disposable disposable = RxTasks.single(FirebaseAuth.getInstance().signInAnonymously())
        .subscribe(result -> greetAnonymousUser(result.getUser().getUid()));

    disposables.add(disposable);
  }

  private void greetAnonymousUser(String user) {
    greeting.setText(getString(R.string.greeting_anonymous, user));
  }
}

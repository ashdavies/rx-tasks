package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import org.junit.Test;

public class RxTasksTest {

  @Test
  public void shouldRepresentTaskAsCompletable() {
    Task<Void> task = Tasks.forResult(null);

    RxTasks
        .completable(task)
        .test()
        .assertResult();
  }

  @Test
  public void shouldRepresentTaskAsSingle() {
    Task<Integer> task = Tasks.forResult(42);

    RxTasks
        .single(task)
        .test()
        .assertResult(42);
  }
}

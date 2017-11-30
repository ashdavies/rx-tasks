package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.observers.TestObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static io.ashdavies.rx.rxtasks.RxTasks.completable;
import static io.ashdavies.rx.rxtasks.RxTasks.single;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class RxTasksTest {

  private Constructor<RxTasks> constructor;

  @Rule
  public ExpectedException expected = ExpectedException.none();

  @Mock Task<Void> task;

  @Before
  public void setUp() throws Exception {
    constructor = RxTasks.class.getDeclaredConstructor();
  }

  @Test
  public void shouldHavePrivateConstructor() throws Exception {
    assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
  }

  @Test
  public void shouldThrowExceptionOnConstructor() throws Exception {
    expected.expect(InvocationTargetException.class);
    expected.expectCause(any(IllegalStateException.class));

    constructor.setAccessible(true);
    constructor.newInstance();
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldCreateCompletableTask() throws Exception {
    ArgumentCaptor<OnSuccessListener> captor = forClass(OnSuccessListener.class);

    completable(task).subscribe();

    then(task).should().addOnSuccessListener(captor.capture());
    assertThat(captor.getValue()).isInstanceOf(CompletableEmitterSuccessListener.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldCreateSingleTask() throws Exception {
    ArgumentCaptor<OnSuccessListener> captor = forClass(OnSuccessListener.class);

    completable(task).subscribe();

    then(task).should().addOnSuccessListener(captor.capture());
    assertThat(captor.getValue()).isInstanceOf(CompletableEmitterSuccessListener.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldEmitNullPointerException() throws Exception {
    ArgumentCaptor<OnSuccessListener> captor = forClass(OnSuccessListener.class);
    TestObserver<Void> observer = single(task).test();

    then(task).should().addOnSuccessListener(captor.capture());
    captor.getValue().onSuccess(null);

    observer.assertError(NullPointerException.class);
  }
}

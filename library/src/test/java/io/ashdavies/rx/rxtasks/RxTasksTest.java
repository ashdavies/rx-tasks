package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.verify;

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
    ArgumentCaptor<OnSuccessListener> captor = ArgumentCaptor.forClass(OnSuccessListener.class);

    RxTasks.completable(task).subscribe();

    verify(task).addOnSuccessListener(captor.capture());
    assertThat(captor.getValue()).isInstanceOf(CompletableEmitterSuccessListener.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldCreateSingleTask() throws Exception {
    ArgumentCaptor<OnSuccessListener> captor = ArgumentCaptor.forClass(OnSuccessListener.class);

    RxTasks.completable(task).subscribe();

    verify(task).addOnSuccessListener(captor.capture());
    assertThat(captor.getValue()).isInstanceOf(CompletableEmitterSuccessListener.class);
  }
}

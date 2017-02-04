package io.ashdavies.rx.rxtasks;

import io.reactivex.SingleEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SingleTaskListenerFactoryTest {

  private TaskListenerFactory<Void, SingleEmitter<Void>> factory;

  @Mock SingleEmitter<Void> emitter;

  @Before
  public void setUp() throws Exception {
    factory = new SingleTaskListenerFactory<>();
  }

  @Test
  public void shouldReturnCompletableEmitterSuccessListener() throws Exception {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(SingleEmitterSuccessListener.class);
  }

  @Test
  public void shouldReturnCompletableEmitterFailureListener() throws Exception {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(SingleEmitterFailureListener.class);
  }
}

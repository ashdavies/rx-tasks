package io.ashdavies.rx.rxtasks;

import io.reactivex.CompletableEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CompletableTaskListenerFactoryTest {

  private TaskListenerFactory<Void, CompletableEmitter> factory;

  @Mock CompletableEmitter emitter;

  @Before
  public void setUp() throws Exception {
    factory = new CompletableTaskListenerFactory();
  }

  @Test
  public void shouldReturnCompletableEmitterSuccessListener() throws Exception {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(CompletableEmitterSuccessListener.class);
  }

  @Test
  public void shouldReturnCompletableEmitterFailureListener() throws Exception {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(CompletableEmitterFailureListener.class);
  }
}

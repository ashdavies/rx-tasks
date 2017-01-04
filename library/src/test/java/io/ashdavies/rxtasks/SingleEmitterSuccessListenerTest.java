package io.ashdavies.rxtasks;

import io.reactivex.SingleEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SingleEmitterSuccessListenerTest {

  private static final String RESULT = "SUCCESS";

  private SingleEmitterSuccessListener<String> listener;

  @Mock SingleEmitter<String> emitter;

  @Before
  public void setUp() throws Exception {
    listener = new SingleEmitterSuccessListener<>(emitter);
  }

  @Test
  public void shouldCallOnSuccess() throws Exception {
    listener.onSuccess(RESULT);

    verify(emitter, times(1)).onSuccess(RESULT);
    verify(emitter, never()).onError(any(Throwable.class));
  }
}

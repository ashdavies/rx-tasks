package io.ashdavies.rx.rxtasks;

import io.reactivex.SingleEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class SingleEmitterFailureListenerTest {

  private SingleEmitterFailureListener<String> listener;

  @Mock SingleEmitter<String> emitter;
  @Mock Exception exception;

  @Before
  public void setUp() throws Exception {
    listener = new SingleEmitterFailureListener<>(emitter);
  }

  @Test
  public void shouldCallOnErrorWithException() throws Exception {
    listener.onFailure(exception);

    then(emitter).should(never()).onSuccess(anyString());
    then(emitter).should().onError(exception);
  }
}

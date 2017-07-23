package io.ashdavies.rx.rxtasks;

import io.reactivex.SingleEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;

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

    then(emitter).should().onSuccess(RESULT);
    then(emitter).should(never()).onError(any(Throwable.class));
  }

  @Test
  public void shouldEmitErrorOnNull() throws Exception {
    listener.onSuccess(null);

    then(emitter).should().onError(any(NullPointerException.class));
  }
}

package io.ashdavies.rx.rxtasks;

import io.reactivex.CompletableEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class CompletableEmitterFailureListenerTest {

  private CompletableEmitterFailureListener listener;

  @Mock CompletableEmitter emitter;
  @Mock Exception exception;

  @Before
  public void setUp() throws Exception {
    listener = new CompletableEmitterFailureListener(emitter);
  }

  @Test
  public void shouldCallOnErrorWithException() throws Exception {
    listener.onFailure(exception);

    then(emitter).should(never()).onComplete();
    then(emitter).should().onError(exception);
  }
}

package io.ashdavies.rxtasks;

import io.reactivex.CompletableEmitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    verify(emitter, never()).onComplete();
    verify(emitter, times(1)).onError(exception);
  }
}

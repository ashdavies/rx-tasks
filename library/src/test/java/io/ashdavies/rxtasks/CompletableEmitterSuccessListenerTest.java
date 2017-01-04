package io.ashdavies.rxtasks;

import io.reactivex.CompletableEmitter;
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
public class CompletableEmitterSuccessListenerTest {

  private CompletableEmitterSuccessListener listener;

  @Mock CompletableEmitter emitter;

  @Before
  public void setUp() throws Exception {
    listener = new CompletableEmitterSuccessListener(emitter);
  }

  @Test
  public void shouldCallOnComplete() throws Exception {
    listener.onSuccess(null);

    verify(emitter, times(1)).onComplete();
    verify(emitter, never()).onError(any(Throwable.class));
  }
}

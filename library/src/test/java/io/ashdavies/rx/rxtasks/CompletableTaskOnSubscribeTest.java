package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class CompletableTaskOnSubscribeTest {

  private CompletableOnSubscribe onSubscribe;

  @Mock Task<Void> task;
  @Mock CompletableEmitter emitter;

  @Mock TaskListenerFactory<Void, CompletableEmitter> factory;
  @Mock OnSuccessListener<Void> onSuccessListener;
  @Mock OnFailureListener onFailureListener;

  @Before
  public void setUp() throws Exception {
    onSubscribe = new CompletableTaskOnSubscribe(task, factory);
  }

  @Test
  public void shouldSubscribeWithOnSuccessListener() throws Exception {
    given(factory.createOnSuccessListener(emitter)).willReturn(onSuccessListener);

    onSubscribe.subscribe(emitter);

    then(factory).should().createOnSuccessListener(emitter);
    then(task).should().addOnSuccessListener(onSuccessListener);
  }

  @Test
  public void shouldSubscribeWithOnFailureListener() throws Exception {
    given(factory.createOnFailureListener(emitter)).willReturn(onFailureListener);

    onSubscribe.subscribe(emitter);

    then(factory).should().createOnFailureListener(emitter);
    then(task).should().addOnFailureListener(onFailureListener);
  }
}

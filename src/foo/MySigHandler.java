package foo;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class MySigHandler implements SignalHandler {
  private Boolean ign = false;
  private SignalHandler oldHandler;
  private SignalHandler handler;

  public void install(String signalName, SignalHandler handler) {
    SignalHandler oldHandler = Signal.handle(new Signal(signalName), this);
    this.setHandler(handler);
    this.setOldHandler(oldHandler);
  }

  MySigHandler(Boolean ignore) {
    this.ign = ignore;
  }

  private void setOldHandler(SignalHandler oldHandler) {
    this.oldHandler = oldHandler;
  }

  private void setHandler(SignalHandler handler) {
    this.handler = handler;
  }

  // Signal handler method
  @Override
  public void handle(Signal sig) {
    System.out.println("\nDiagnostic Signal handler called for signal " + sig);
    try {
      handler.handle(sig);

      // Chain back to previous handler, if one exists
      if (!this.ign && oldHandler != SIG_DFL && oldHandler != SIG_IGN) {
        oldHandler.handle(sig);
      }

    } catch (Exception e) {
      System.out.println("Signal handler failed, reason " + e);
    }
  }
}
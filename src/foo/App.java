package foo;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class App {
  private static String resource;

  public static void main(String[] args) {
    System.out.println("My JRE is " + System.getProperty("java.version"));
    SignalHandler contHandler = new SignalHandler() {
      @Override
      public void handle(Signal signal) {
        System.out.println("\nGot signal " + signal.getName());
      }
    };
    SignalHandler exitHandler = new SignalHandler() {
      @Override
      public void handle(Signal signal) {
          System.out.println("\nGot signal " + signal.getName());
          System.exit(0);
      }
    };
    MySigHandler hTerm = new MySigHandler(true); hTerm.install("TERM", exitHandler);
    MySigHandler hCont = new MySigHandler(true); hCont.install("CONT", contHandler);
    while (true) {
        System.out.print('.');
        Thread t = new Thread();
        try {
            t.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  }
}

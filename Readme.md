# Try Linux signal handling in Java

Tested Ok with Oracle Java 8 and OpenJDK 11 (add/switch JDK in IDEA: File>Project Structure).

List signals: `kill -l`

For contemporary signals description please see your `man 7 signal` page,
paragraph "Standard signals"
(or [on the web]( http://man7.org/linux/man-pages/man7/signal.7.html))

This proto was run in IDEA, additional Terminal window was used for sending signals like this:
```
myPid=$(pgrep java |xargs ps |grep App| awk '{ print $1; }') && kill  -CONT $myPid
myPid=$(pgrep java |xargs ps |grep App| awk '{ print $1; }') && kill  -TERM $myPid
```

derived from [2009.12.11 post in Russian](https://habr.com/ru/post/78035/) referring a defunct
[IBM developerWorks Jan 2002 article "Revelations on Java signal handling and termination" by Chris.White@uk.ibm.com saved on web.archive.org](http://web.archive.org/web/20020601213732/http://www-106.ibm.com/developerworks/ibm/library/i-signalhandling)
NB: this article lists AIX signals of the time, SIGCONT is not listed.

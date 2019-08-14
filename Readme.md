try Linux signal handling in Java

Tested Ok with Oracle Java 8 and OpenJDK 11.

List signals: `kill -l`

Signals description: http://man7.org/linux/man-pages/man7/signal.7.html paragraph "Standard signals" (or see your `man 7 signal`)

This proto was run in IDEA, additional Terminal window was used for sending signals like this:
```
myPid=$(pgrep java |xargs ps |grep App| awk '{ print $1; }') && kill  -CONT $myPid
myPid=$(pgrep java |xargs ps |grep App| awk '{ print $1; }') && kill  -TERM $myPid
```

first published as a [Gist](https://gist.github.com/mz0/ce67ca92f5a0d2b90c41894c06a0a0f2)

derived from post (in Russian) https://habr.com/ru/post/78035/

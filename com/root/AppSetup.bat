@echo off

echo %p 

IF DEFINED CONSOLE_TODO (
    echo CONSOLE_TODO is set to %CONSOLE_TODO%.
) ELSE (
    IF DEFINED p(
        setx CONSOLE_TODO %p% /m
        echo CONSOLE_TODO set to %p%
    )
)

IF DEFINED JAVA_HOME (
    javac Main.java
)

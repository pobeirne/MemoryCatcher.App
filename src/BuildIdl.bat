@echo off
set PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_20\bin\
idlj -fall -oldImplBase MemoryCatcherIDL.idl
pause
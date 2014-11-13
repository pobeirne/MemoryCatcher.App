package MemoryCatcherApp;


/**
* MemoryCatcherApp/User.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MemoryCatcherIDL.idl
* 13 November 2014 23:17:47 o'clock GMT
*/

public final class User implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String name = null;
  public String pwd = null;
  public boolean online = false;
  public int tokens = (int)0;
  public String joinDate = null;

  public User ()
  {
  } // ctor

  public User (int _id, String _name, String _pwd, boolean _online, int _tokens, String _joinDate)
  {
    id = _id;
    name = _name;
    pwd = _pwd;
    online = _online;
    tokens = _tokens;
    joinDate = _joinDate;
  } // ctor

} // class User
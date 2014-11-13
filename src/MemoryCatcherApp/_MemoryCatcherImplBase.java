package MemoryCatcherApp;


/**
* MemoryCatcherApp/_MemoryCatcherImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MemoryCatcherIDL.idl
* 13 November 2014 23:17:47 o'clock GMT
*/

public abstract class _MemoryCatcherImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements MemoryCatcherApp.MemoryCatcher, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _MemoryCatcherImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getAllUsers", new java.lang.Integer (0));
    _methods.put ("getUserByName", new java.lang.Integer (1));
    _methods.put ("getUserById", new java.lang.Integer (2));
    _methods.put ("addUser", new java.lang.Integer (3));
    _methods.put ("updateUser", new java.lang.Integer (4));
    _methods.put ("removeUser", new java.lang.Integer (5));
    _methods.put ("getAllFriends", new java.lang.Integer (6));
    _methods.put ("addFriend", new java.lang.Integer (7));
    _methods.put ("updateFriend", new java.lang.Integer (8));
    _methods.put ("removeFriend", new java.lang.Integer (9));
    _methods.put ("getAllMemories", new java.lang.Integer (10));
    _methods.put ("getAllUserMemories", new java.lang.Integer (11));
    _methods.put ("addMemory", new java.lang.Integer (12));
    _methods.put ("updateMemory", new java.lang.Integer (13));
    _methods.put ("removeMemory", new java.lang.Integer (14));
    _methods.put ("getAllResources", new java.lang.Integer (15));
    _methods.put ("addResource", new java.lang.Integer (16));
    _methods.put ("updateResource", new java.lang.Integer (17));
    _methods.put ("removeResource", new java.lang.Integer (18));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MemoryCatcherApp/MemoryCatcher/getAllUsers
       {
         MemoryCatcherApp.User $result[] = null;
         $result = this.getAllUsers ();
         out = $rh.createReply();
         MemoryCatcherApp.UserListHelper.write (out, $result);
         break;
       }

       case 1:  // MemoryCatcherApp/MemoryCatcher/getUserByName
       {
         String name = in.read_string ();
         MemoryCatcherApp.User $result = null;
         $result = this.getUserByName (name);
         out = $rh.createReply();
         MemoryCatcherApp.UserHelper.write (out, $result);
         break;
       }

       case 2:  // MemoryCatcherApp/MemoryCatcher/getUserById
       {
         int userId = in.read_long ();
         MemoryCatcherApp.User $result = null;
         $result = this.getUserById (userId);
         out = $rh.createReply();
         MemoryCatcherApp.UserHelper.write (out, $result);
         break;
       }

       case 3:  // MemoryCatcherApp/MemoryCatcher/addUser
       {
         String name = in.read_string ();
         String pass = in.read_string ();
         boolean $result = false;
         $result = this.addUser (name, pass);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // MemoryCatcherApp/MemoryCatcher/updateUser
       {
         MemoryCatcherApp.User user = MemoryCatcherApp.UserHelper.read (in);
         boolean $result = false;
         $result = this.updateUser (user);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // MemoryCatcherApp/MemoryCatcher/removeUser
       {
         int userId = in.read_long ();
         boolean $result = false;
         $result = this.removeUser (userId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // MemoryCatcherApp/MemoryCatcher/getAllFriends
       {
         int userId = in.read_long ();
         MemoryCatcherApp.User $result[] = null;
         $result = this.getAllFriends (userId);
         out = $rh.createReply();
         MemoryCatcherApp.FriendListHelper.write (out, $result);
         break;
       }

       case 7:  // MemoryCatcherApp/MemoryCatcher/addFriend
       {
         int user_a = in.read_long ();
         int user_b = in.read_long ();
         boolean $result = false;
         $result = this.addFriend (user_a, user_b);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // MemoryCatcherApp/MemoryCatcher/updateFriend
       {
         int user_a = in.read_long ();
         int user_b = in.read_long ();
         boolean active = in.read_boolean ();
         boolean $result = false;
         $result = this.updateFriend (user_a, user_b, active);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 9:  // MemoryCatcherApp/MemoryCatcher/removeFriend
       {
         int user_a = in.read_long ();
         int user_b = in.read_long ();
         boolean $result = false;
         $result = this.removeFriend (user_a, user_b);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 10:  // MemoryCatcherApp/MemoryCatcher/getAllMemories
       {
         MemoryCatcherApp.Memory $result[] = null;
         $result = this.getAllMemories ();
         out = $rh.createReply();
         MemoryCatcherApp.MemoryListHelper.write (out, $result);
         break;
       }

       case 11:  // MemoryCatcherApp/MemoryCatcher/getAllUserMemories
       {
         int userId = in.read_long ();
         MemoryCatcherApp.Memory $result[] = null;
         $result = this.getAllUserMemories (userId);
         out = $rh.createReply();
         MemoryCatcherApp.MemoryListHelper.write (out, $result);
         break;
       }

       case 12:  // MemoryCatcherApp/MemoryCatcher/addMemory
       {
         int ownerId = in.read_long ();
         String title = in.read_string ();
         String desc = in.read_string ();
         boolean $result = false;
         $result = this.addMemory (ownerId, title, desc);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 13:  // MemoryCatcherApp/MemoryCatcher/updateMemory
       {
         MemoryCatcherApp.Memory memory = MemoryCatcherApp.MemoryHelper.read (in);
         boolean $result = false;
         $result = this.updateMemory (memory);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 14:  // MemoryCatcherApp/MemoryCatcher/removeMemory
       {
         int memoryId = in.read_long ();
         boolean $result = false;
         $result = this.removeMemory (memoryId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 15:  // MemoryCatcherApp/MemoryCatcher/getAllResources
       {
         int memoryId = in.read_long ();
         MemoryCatcherApp.Resource $result[] = null;
         $result = this.getAllResources (memoryId);
         out = $rh.createReply();
         MemoryCatcherApp.ResourceListHelper.write (out, $result);
         break;
       }

       case 16:  // MemoryCatcherApp/MemoryCatcher/addResource
       {
         int memoryId = in.read_long ();
         int ownerId = in.read_long ();
         String type = in.read_string ();
         String location = in.read_string ();
         boolean $result = false;
         $result = this.addResource (memoryId, ownerId, type, location);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 17:  // MemoryCatcherApp/MemoryCatcher/updateResource
       {
         MemoryCatcherApp.Resource res = MemoryCatcherApp.ResourceHelper.read (in);
         boolean $result = false;
         $result = this.updateResource (res);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 18:  // MemoryCatcherApp/MemoryCatcher/removeResource
       {
         int resId = in.read_long ();
         boolean $result = false;
         $result = this.removeResource (resId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MemoryCatcherApp/MemoryCatcher:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _MemoryCatcherImplBase
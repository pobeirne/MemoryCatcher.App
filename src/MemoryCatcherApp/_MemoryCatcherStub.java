package MemoryCatcherApp;


/**
* MemoryCatcherApp/_MemoryCatcherStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MemoryCatcherIDL.idl
* 13 November 2014 23:17:47 o'clock GMT
*/

public class _MemoryCatcherStub extends org.omg.CORBA.portable.ObjectImpl implements MemoryCatcherApp.MemoryCatcher
{

  public MemoryCatcherApp.User[] getAllUsers ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllUsers", true);
                $in = _invoke ($out);
                MemoryCatcherApp.User $result[] = MemoryCatcherApp.UserListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllUsers (        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllUsers

  public MemoryCatcherApp.User getUserByName (String name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getUserByName", true);
                $out.write_string (name);
                $in = _invoke ($out);
                MemoryCatcherApp.User $result = MemoryCatcherApp.UserHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getUserByName (name        );
            } finally {
                _releaseReply ($in);
            }
  } // getUserByName

  public MemoryCatcherApp.User getUserById (int userId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getUserById", true);
                $out.write_long (userId);
                $in = _invoke ($out);
                MemoryCatcherApp.User $result = MemoryCatcherApp.UserHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getUserById (userId        );
            } finally {
                _releaseReply ($in);
            }
  } // getUserById

  public boolean addUser (String name, String pass)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addUser", true);
                $out.write_string (name);
                $out.write_string (pass);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addUser (name, pass        );
            } finally {
                _releaseReply ($in);
            }
  } // addUser

  public boolean updateUser (MemoryCatcherApp.User user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateUser", true);
                MemoryCatcherApp.UserHelper.write ($out, user);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateUser (user        );
            } finally {
                _releaseReply ($in);
            }
  } // updateUser

  public boolean removeUser (int userId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeUser", true);
                $out.write_long (userId);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeUser (userId        );
            } finally {
                _releaseReply ($in);
            }
  } // removeUser

  public MemoryCatcherApp.User[] getAllFriends (int userId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllFriends", true);
                $out.write_long (userId);
                $in = _invoke ($out);
                MemoryCatcherApp.User $result[] = MemoryCatcherApp.FriendListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllFriends (userId        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllFriends

  public boolean addFriend (int user_a, int user_b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addFriend", true);
                $out.write_long (user_a);
                $out.write_long (user_b);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addFriend (user_a, user_b        );
            } finally {
                _releaseReply ($in);
            }
  } // addFriend

  public boolean updateFriend (int user_a, int user_b, boolean active)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateFriend", true);
                $out.write_long (user_a);
                $out.write_long (user_b);
                $out.write_boolean (active);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateFriend (user_a, user_b, active        );
            } finally {
                _releaseReply ($in);
            }
  } // updateFriend

  public boolean removeFriend (int user_a, int user_b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeFriend", true);
                $out.write_long (user_a);
                $out.write_long (user_b);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeFriend (user_a, user_b        );
            } finally {
                _releaseReply ($in);
            }
  } // removeFriend

  public MemoryCatcherApp.Memory[] getAllMemories ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllMemories", true);
                $in = _invoke ($out);
                MemoryCatcherApp.Memory $result[] = MemoryCatcherApp.MemoryListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllMemories (        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllMemories

  public MemoryCatcherApp.Memory[] getAllUserMemories (int userId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllUserMemories", true);
                $out.write_long (userId);
                $in = _invoke ($out);
                MemoryCatcherApp.Memory $result[] = MemoryCatcherApp.MemoryListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllUserMemories (userId        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllUserMemories

  public boolean addMemory (int ownerId, String title, String desc)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addMemory", true);
                $out.write_long (ownerId);
                $out.write_string (title);
                $out.write_string (desc);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addMemory (ownerId, title, desc        );
            } finally {
                _releaseReply ($in);
            }
  } // addMemory

  public boolean updateMemory (MemoryCatcherApp.Memory memory)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateMemory", true);
                MemoryCatcherApp.MemoryHelper.write ($out, memory);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateMemory (memory        );
            } finally {
                _releaseReply ($in);
            }
  } // updateMemory

  public boolean removeMemory (int memoryId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeMemory", true);
                $out.write_long (memoryId);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeMemory (memoryId        );
            } finally {
                _releaseReply ($in);
            }
  } // removeMemory

  public MemoryCatcherApp.Resource[] getAllResources (int memoryId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllResources", true);
                $out.write_long (memoryId);
                $in = _invoke ($out);
                MemoryCatcherApp.Resource $result[] = MemoryCatcherApp.ResourceListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllResources (memoryId        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllResources

  public boolean addResource (int memoryId, int ownerId, String type, String location)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addResource", true);
                $out.write_long (memoryId);
                $out.write_long (ownerId);
                $out.write_string (type);
                $out.write_string (location);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addResource (memoryId, ownerId, type, location        );
            } finally {
                _releaseReply ($in);
            }
  } // addResource

  public boolean updateResource (MemoryCatcherApp.Resource res)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateResource", true);
                MemoryCatcherApp.ResourceHelper.write ($out, res);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateResource (res        );
            } finally {
                _releaseReply ($in);
            }
  } // updateResource

  public boolean removeResource (int resId)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeResource", true);
                $out.write_long (resId);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeResource (resId        );
            } finally {
                _releaseReply ($in);
            }
  } // removeResource

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MemoryCatcherApp/MemoryCatcher:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _MemoryCatcherStub

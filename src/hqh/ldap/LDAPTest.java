package hqh.ldap;

import  java.util.Hashtable;

import  javax.naming.Context;
import  javax.naming.NamingException;
import  javax.naming.directory.DirContext;
import  javax.naming.directory.InitialDirContext;   
    
public   class  LDAPTest {   
   public   static   void  main(String[] args) {   
    //LDAPTest LDAPTest1 =  new  LDAPTest();   
    String root =  "dc=maxcrc,dc=com" ;  //root   
    Hashtable<String,String> env =  new  Hashtable<String,String>();   
    env.put(Context.INITIAL_CONTEXT_FACTORY,  "com.sun.jndi.ldap.LdapCtxFactory" );   
    env.put(Context.PROVIDER_URL,  "ldap://localhost/"  + root);       
    env.put(Context.SECURITY_AUTHENTICATION,  "simple" );   
    env.put(Context.SECURITY_PRINCIPAL,  "cn=Manager,dc=maxcrc,dc=com" );   
    env.put(Context.SECURITY_CREDENTIALS,  "secret" );   
    DirContext ctx =  null ;   
     try  {   
      ctx =  new  InitialDirContext(env);   
      
      
      //3.添加
      DirContext   ctx   =   ...;
      String   newUserName   =   "user2 ";

      BasicAttributes   attrs   =   new   BasicAttributes();

      BasicAttribute   objclassSet   =   new   BasicAttribute( "objectclass ");
      objclassSet.add( "person ");  
      objclassSet.add( "top ");  
      objclassSet.add( "organizationalPerson ");  
      objclassSet.add( "inetOrgPerson ");

      attrs.put(objclassSet);
      attrs.put( "sn ",   newUserName);
      attrs.put( "uid ",   newUserName);

      ctx.createSubcontext( "uid= "   +   newUserName,   attributes);
      //4.删除
      String   account   =   "user2 ";
      DirContext   ctx   =   ...;
      ctx.destroySubcontext( "uid= "   +   account);


      5.修改
      String   account   =   "user2 ";
      String   newDisplayName   =   "newDisplayName ";

      ModificationItem   modificationItem[]   =   new   ModificationItem[1];
      modificationItem[0]   =
      new   ModificationItem(
      DirContext.REPLACE_ATTRIBUTE,
      new   BasicAttribute( "displayName ",   newDisplayName);

      DirContext   ctx   =   ...;
      ctx.modifyAttributes( "uid= "   +   account,   modificationItem);

      
      System.out.println( "认证成功" );   
    }   
     catch  (javax.naming.AuthenticationException e) {   
      e.printStackTrace();   
      System.out.println( "认证失败" );   
    }   
     catch  (Exception e) {   
      System.out.println( "认证出错：" );   
      e.printStackTrace();   
    }   
    
     if  (ctx !=  null ) {   
       try  {   
        ctx.close();   
      }   
       catch  (NamingException e) {   
         //ignore   
      }   
    }   
  }   
}  
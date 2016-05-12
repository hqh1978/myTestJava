package hqh.ldap;

import java.security.KeyStore.Entry.Attribute;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LDAPTest2 {
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
    	ctx   =  new  InitialDirContext(env); 
    	System.out.println( "认证成功" );  
    	SearchControls   constraints   =   new   SearchControls();
    	constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
    	//constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
    	//NamingEnumeration   en   =   ctx.search( " ",   "uid=* ",   constraints);   //查询所有用户

    		  NamingEnumeration en = ctx.search("", "uid=*", constraints);
    		  while   (en   !=   null   &&   en.hasMoreElements())
    		  {
    		          Object   obj   =   en.nextElement();
    		          if(obj   instanceof   SearchResult)
    		          {
    		                  SearchResult   si   =   (SearchResult)   obj;
    		         
    		                  System.out.println( "name:   "   +   si.getName());
    		         
    		                  Attributes   attrs   =   si.getAttributes();
    		                  if   (attrs   ==   null)
    		                  {
    		                          System.out.println( "No   attributes ");
    		                  }
    		                  else
    		                  {
    		                          for   (NamingEnumeration   ae   =   attrs.getAll();   ae.hasMoreElements();)
    		                          {
    		                                  Attribute   attr   =   (Attribute)   ae.next();
    		                                  String   attrId   =   attr.getName();
    		         
    		                                  /*for   (Enumeration   vals   =   attr.getValue();vals.hasMoreElements();)
    		                                  {
    		                                          System.out.print(attrId   +   ":   ");
    		                                          Object   o   =   vals.nextElement();
    		                                          if(o   instanceof   byte[])
    		                                                  System.out.println(new   String((byte[])o));
    		                                          else
    		                                                  System.out.println(o);
    		                                  }*/
    		                          }
    		                  }
    		          }
    		          else
    		          {
    		                  System.out.println(obj);
    		          }
    		          System.out.println();
    		  }
    		  ctx.close();
      
      
      
       
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
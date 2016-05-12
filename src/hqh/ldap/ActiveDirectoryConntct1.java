package hqh.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;	

public class ActiveDirectoryConntct1 {
	public static void main(String[] args) {
		String account = "Manager";
		String password = "secret";
		String root =  "dc=maxcrc,dc=com" ;  //root   

		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );   
		env.put(Context.PROVIDER_URL, "ldap://localhost/"  + root);  
		env.put(Context.SECURITY_AUTHENTICATION, "simple ");
		env.put(Context.SECURITY_PRINCIPAL, "cn= " + account + ", " + root);
		env.put(Context.SECURITY_CREDENTIALS, password);

		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
			System.out.println("认证成功 ");
		} catch (javax.naming.AuthenticationException e) {
			System.out.println("认证失败 ");
		} catch (Exception e) {
			System.out.println("认证出错： ");
			e.printStackTrace();
		}

		if (ctx != null) {
			try {
				ctx.close();
			} catch (NamingException e) {
				// ignore
			}
		}
		System.exit(0);
	}
}
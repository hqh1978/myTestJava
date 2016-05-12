package hqh.ldap;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NameAlreadyBoundException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class TestLDAP {
    	static final long serialVersionUID = -1240113639782150930L;

        final static String ldapServerName = "localhost:636";
        final static String rootdn = "uid=hqh,ou=users,dc=maxcrc,dc=com";
        final static String rootpass = "781006";
        final static String rootContext = "ou=users,dc=maxcrc,dc=com";

        public static void main( String[] args ) {
        	System.setProperty("javax.net.ssl.trustStore", "C:\\cacerts");


                Properties env = new Properties();
                env.put("com.sun.jndi.ldap.trace.ber", System.out);
                env.put( Context.INITIAL_CONTEXT_FACTORY,
                         "com.sun.jndi.ldap.LdapCtxFactory" );
                env.put(Context.SECURITY_PROTOCOL, "ssl");
                env.put( Context.PROVIDER_URL, "ldap://" + ldapServerName + "/" + rootContext );
                env.put( Context.SECURITY_PRINCIPAL, rootdn );
                env.put( Context.SECURITY_CREDENTIALS, rootpass );

                try {
                        // obtain initial directory context using the environment
                        DirContext ctx = new InitialDirContext( env );

                        // add LDAP entry
                        Attributes myAttrs = new BasicAttributes(true);
                        Attribute oc = new BasicAttribute("objectclass");

                        oc.add("inetOrgPerson");
                        oc.add("organizationalPerson");
                        oc.add("person");
                        oc.add("top");
                        myAttrs.put(oc);
                        myAttrs.put("cn","test996");
                        myAttrs.put("sn","test 996");

    					ctx.bind("cn=test997", myAttrs);
                } catch ( NameAlreadyBoundException nabe ) {
                        System.err.println( "value has already been bound!" );
                } catch ( Exception e ) {
                        e.printStackTrace();
                }
        }
}

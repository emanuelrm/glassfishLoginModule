package br.com.tnd;

import com.sun.appserv.security.AppservRealm;
import com.sun.enterprise.security.auth.realm.BadRealmException;
import com.sun.enterprise.security.auth.realm.InvalidOperationException;
import com.sun.enterprise.security.auth.realm.NoSuchRealmException;
import com.sun.enterprise.security.auth.realm.NoSuchUserException;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by emanuel on 19/07/17.
 */
public class LoginRealm extends AppservRealm {

    private String urlFirstLdap;
    private String urlSecondLdap;

    @Override
    protected void init(Properties props) throws BadRealmException, NoSuchRealmException {
        _logger.info("Login Realm: init()");
        urlFirstLdap = props.getProperty("url-first-ldap", "ldap:192.168.40.5:389");
        urlSecondLdap = props.getProperty("url-second-ldap", "ldap:192.168.40.1:389");
    }

    public String getAuthType() {
        return "Login Realm";
    }

    public Enumeration getGroupNames(String s) throws InvalidOperationException, NoSuchUserException {
        List groupNames = new LinkedList();
        return (Enumeration) groupNames;
    }

    public String getUrlFirstLdap() {
        return urlFirstLdap;
    }

    public String getUrlSecondLdap() {
        return urlSecondLdap;
    }
}

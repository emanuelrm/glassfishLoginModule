package br.com.tnd;

import com.sun.appserv.security.AppservPasswordLoginModule;
import org.glassfish.security.common.PrincipalImpl;

import javax.security.auth.login.LoginException;
import java.util.Set;

/**
 * Created by emanuel on 19/07/17.
 */
public class LoginModule extends AppservPasswordLoginModule {

    @Override
    protected void authenticateUser() throws LoginException {
        _logger.info("Login Module : authenticateUser for " + _username);
        LoginRealm realm = (LoginRealm) _currentRealm;

        if (!connectFirstLdap(realm) && !connectSecondLdap(realm)) {
            _logger.info("Invalid credentials.");
            throw new LoginException("Invalid credentials.");
        }

        _logger.info("User authenticated");
        Set principals = _subject.getPrincipals();
        principals.add(new PrincipalImpl(_username));

        String grpList[] = new String[1];
        grpList[0] = "Admin";
        this.commitUserAuthentication(grpList);

    }

    private boolean connectFirstLdap(LoginRealm realm) {
        _logger.info(realm.getUrlFirstLdap());
        return false;
    }

    private boolean connectSecondLdap(LoginRealm realm) {
        _logger.info(realm.getUrlSecondLdap());
        return true;
    }
}

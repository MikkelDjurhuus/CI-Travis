package exercise;

import Utils.Mailer;
import exercise.fakedatabase.UserFacadeFake;
import exercise.realdatabase.UserFacadeRealDB;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



public class AuthenticatorTestIT extends AuthenticatorTest {

  //Override in a derived test to test with alternative Facades/Mailers
  @Override
  public Authenticator makeAuthenticator(){
     Mailer mailer = mock(Mailer.class);
    if (System.getenv("TRAVIS") != null) {
     return new Authenticator(new UserFacadeRealDB("pu_mySql_travis_Integration"), mailer);
    }
     return new Authenticator(new UserFacadeRealDB("pu_localDB"), mailer);
  }
}

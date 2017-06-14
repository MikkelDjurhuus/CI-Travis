package exercise;

import exercise.fakedatabase.UserFacadeFake;
import exercise.IUserFacade;
import exercise.LoginStatus;
import exercise.realdatabase.UserFacadeRealDB;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserFacadeTestIT extends UserFacadeTest {

  //Override in a derived class to provide an alternative Facade for these tests
  @Override
  public IUserFacade makeUserFacade(){ 
    if (System.getenv("TRAVIS") != null) {
      return new UserFacadeRealDB("pu_mySql_travis_Integration");
    }
    return new UserFacadeRealDB("pu_localDB");
  }
}

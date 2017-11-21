package geco;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginGeneratorTest {

    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR",
                "JDUP", "JRAL", "JRAL1"});
    }

    @Test
    public void generateLoginPaulDurand() throws Exception {
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String pdur = loginGenerator.generateLoginForNomAndPrenom("Durand",
                "Paul");

        assertThat(pdur, is("PDUR"));
        assertThat(loginService.loginExists("PDUR"), is(true));
    }

    @Test
    public void generateLoginJohnRalling() throws Exception {
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String jral = loginGenerator.generateLoginForNomAndPrenom("Ralling",
                "John");

        assertThat(jral, is("JRAL2"));
        assertThat(loginService.loginExists("JRAL2"), is(true));
    }

    @Test
    public void generateLoginJeanRolling() throws Exception {
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String jrol = loginGenerator.generateLoginForNomAndPrenom("Rolling",
                "Jean");

        assertThat(jrol, is("JROL1"));
        assertThat(loginService.loginExists("JROL1"), is(true));
    }

    @Test
    public void generateLoginPaulDurandAccent() throws Exception {
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String pdur = loginGenerator.generateLoginForNomAndPrenom("Dùrand",
                "Paul");

        assertThat(pdur, is("PDUR"));
        assertThat(loginService.loginExists("PDUR"), is(true));
    }

}
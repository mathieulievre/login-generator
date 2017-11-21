package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService ls;

    @Before
    public void init() {
        String[] tab = new String[]{"mlievre", "celoundou", "smatthia",
                "tganthier", "aassie", "ltureau", "mkeita", "cmorin",
                "qchampeau", "hclement", "randriamiseza"};
        ls = new LoginService(tab);
    }

    @Test
    public void loginExists() throws Exception {
        String login1 = "hclement";
        String login2 = "ybarthes";
        String login3 = new String();
        assertThat(ls.loginExists(login1), is(true));
        assertThat(ls.loginExists(login2), is(false));
        assertThat(ls.loginExists(login3), is(false));
    }

    @Test
    public void addLogin() throws Exception {
        String login1 = "jpatane";
        ls.addLogin(login1);

        assertThat(ls.loginExists(login1), is(true));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        List<String> listM = ls.findAllLoginsStartingWith("m");
        List<String> listA = ls.findAllLoginsStartingWith("a");
        List<String> listZ = ls.findAllLoginsStartingWith("z");

        assertThat(listM, hasItem("mlievre"));
        assertThat(listM, hasItem("mkeita"));
        assertEquals("the list should contain 2 elements", 2, listM.size());

        assertThat(listA, hasItem("aassie"));
        assertThat(listA, not(hasItem("celoundou")));
        assertEquals("the list should contain 1 element", 1, listA.size());

        assertThat(listZ, not(hasItem("cmorin")));
        assertTrue("the list should be empty", listZ.isEmpty());
    }

    @Test
    public void findAllLogins() throws Exception {
        ls.addLogin("jpatane");
        ls.addLogin("elahrach");
        ls.addLogin("tlaurent");
        ls.addLogin("mfarouj");
        ls.addLogin("clopes");

        String[] tab = new String[]{"mlievre", "celoundou", "smatthia",
                "tganthier", "aassie", "ltureau", "mkeita", "cmorin",
                "qchampeau", "hclement", "randriamiseza", "jpatane",
                "elahrach", "tlaurent", "mfarouj", "clopes"};

        assertThat(ls.findAllLogins(), hasItems(tab));
        assertEquals("the list should contain 16 elements", 16, ls
                .findAllLogins().size());
    }
}
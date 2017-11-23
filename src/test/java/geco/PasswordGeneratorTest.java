package geco;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class PasswordGeneratorTest {

    private PasswordGenerator passwordGenerator;

    @Before
    public void setUp() {
        passwordGenerator = new PasswordGenerator();
    }

    @Test
    public void getRandomPasswordEgal() throws Exception {
        String pass1 = passwordGenerator.getRandomPassword(5, 5);
        assertThat(pass1.length(), is(5));
    }

    @Test
    public void getRandomPasswordMinInf() throws Exception {
        String pass1 = passwordGenerator.getRandomPassword(4, 8);
        assertTrue("Password is too long", pass1.length() <= 8);
        assertTrue("Password is too short", pass1.length() >= 4);
    }

    @Test(expected = AssertionError.class)
    public void getRandomPasswordMaxInf() throws AssertionError {
        String pass2 = passwordGenerator.getRandomPassword(7, 5);
    }

    @Test(expected = AssertionError.class)
    public void getRandomPasswordMoinsUn() throws AssertionError {
        String pass3 = passwordGenerator.getRandomPassword(-1, 4);
    }

    @Test(expected = AssertionError.class)
    public void getRandomPasswordZero() throws AssertionError {
        String pass4 = passwordGenerator.getRandomPassword(0, 0);
    }

}
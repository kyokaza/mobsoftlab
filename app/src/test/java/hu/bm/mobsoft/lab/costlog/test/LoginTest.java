package hu.bm.mobsoft.lab.costlog.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bm.mobsoft.lab.costlog.BuildConfig;
import hu.bm.mobsoft.lab.costlog.model.User;
import hu.bm.mobsoft.lab.costlog.ui.main.MainPresenter;
import hu.bm.mobsoft.lab.costlog.ui.main.MainScreen;
import hu.bm.mobsoft.lab.costlog.utils.RobolectricDaggerTestRunner;

import static hu.bm.mobsoft.lab.costlog.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginTest {

    private MainPresenter mianPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mianPresenter = new MainPresenter();
    }

    @Test
    public void testTodo() {
        MainScreen mainScreen = mock(MainScreen.class);
        mianPresenter.attachScreen(mainScreen);
        mianPresenter.startLogin(new User(3L, "Alma", "Alma"));

        ArgumentCaptor<String> loginsCaptor = ArgumentCaptor.forClass(String.class);
//        verify(mainScreen, times(2)).showMessage(loginsCaptor.capture());
//        System.out.println(mainScreen);
        verify(mainScreen).loginSuccess();

        List<String> capturedUsers = loginsCaptor.getAllValues();
//        System.out.println(capturedUsers);
        System.out.println("Login was successfull. - " + capturedUsers);
//        assertEquals("Alma", capturedUsers.get(0));
    }



    @After
    public void tearDown() {
        mianPresenter.detachScreen();
    }
}
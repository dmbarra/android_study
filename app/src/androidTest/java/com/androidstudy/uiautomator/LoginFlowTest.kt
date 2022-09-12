package com.androidstudy.uiautomator

import android.content.Context
import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import com.androidstudy.R
import com.androidstudy.ui.home.HomeFragment
import com.androidstudy.ui.login.LoginFragment
import okhttp3.internal.notify
import org.hamcrest.core.IsNot.not
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginFlowTest {

    private lateinit var device:UiDevice;
    private val SAMPLE_PACKAGE: String = "com.androidstudy"
    private val LAUNCH_TIMEOUT = 5000L

    @Before fun setUp() {
        device = UiDevice.getInstance(getInstrumentation())
        device.pressHome()

    }

    @Test fun shouldLoadAndLoginFragment() {
        val launcherPackage: String = device.launcherPackageName
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(SAMPLE_PACKAGE)
            ?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        context.startActivity(intent)

        device.wait(
            Until.hasObject(By.pkg(SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )

        device.findObject(UiSelector().resourceId("$SAMPLE_PACKAGE:id/toolbar")).getChild(UiSelector().index(1)).getChild(UiSelector().index(1)).click()

        device.findObject(UiSelector().textContains("Login")).click()


    }


}
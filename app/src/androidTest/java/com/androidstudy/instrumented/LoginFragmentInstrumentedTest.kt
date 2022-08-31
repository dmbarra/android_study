package com.androidstudy.instrumented

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.androidstudy.R
import com.androidstudy.ui.home.HomeFragment
import com.androidstudy.ui.login.LoginFragment
import okhttp3.internal.notify
import org.hamcrest.core.IsNot.not
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class LoginFragmentInstrumentedTest {

    @Before fun setUp() {
        val scenario = launchFragmentInContainer<LoginFragment>(
            themeResId = R.style.Theme_AppCompat
        )
    }

    @Test fun shouldLoadAndLoginFragment() {
        onView(withResourceName("username")).check(matches(isDisplayed()))
        onView(withResourceName("username")).check(matches(withHint(R.string.prompt_email)))
        onView(withResourceName("password")).check(matches(isDisplayed()))
        onView(withResourceName("password")).check(matches(withHint(R.string.prompt_password)))
        onView(withResourceName("login")).check(matches(isDisplayed()))
        onView(withResourceName("login")).check(matches(withText(R.string.action_sign_in)))
        onView(withResourceName("login")).check(matches(not(isEnabled())))
    }

    @Test fun shouldEnableButtonLogin() {
        onView(withResourceName("username")).perform(typeText("username"))
        onView(withResourceName("password")).perform(typeText("password"))
        onView(withResourceName("login")).check(matches(isEnabled()))
    }

    @Test fun shouldShowInvalidPasswordSize() {
        onView(withResourceName("username")).perform(typeText("username"))
        onView(withResourceName("password")).perform(typeText("pas"))
        onView(withResourceName("password")).check(matches(hasErrorText("Password must be >5 characters")))
    }

}
package com.androidstudy.instrumented

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.androidstudy.R
import com.androidstudy.ui.home.HomeFragment
import com.androidstudy.ui.login.LoginFragment

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class LoginFragmentInstrumentedTest {

    @Test fun shouldLoadAndLoginFragment() {
        val scenario = launchFragmentInContainer<LoginFragment>(
            themeResId = R.style.Theme_AppCompat
        )

        onView(withResourceName("username")).check(matches(isDisplayed()))
        onView(withResourceName("username")).check(matches(withHint(R.string.prompt_email)))
        onView(withResourceName("password")).check(matches(isDisplayed()))
        onView(withResourceName("password")).check(matches(withHint(R.string.prompt_password)))
        onView(withResourceName("login")).check(matches(isDisplayed()))
        onView(withResourceName("login")).check(matches(withText(R.string.action_sign_in)))
    }


}
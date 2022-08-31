package com.androidstudy.instrumented

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.androidstudy.R
import com.androidstudy.ui.home.HomeFragment

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class HomeFragmentInstrumentedTest {

    @Test fun shouldLoadAndHomeFragment() {
        val scenario = launchFragmentInContainer<HomeFragment>(
            themeResId = R.style.Theme_AppCompat
        )

        onView(withResourceName("toolbar")).check(matches(isDisplayed()))
        onView(withResourceName("frame_menu_layout")).check(matches(isDisplayed()))
    }


}
package com.muryno.cardfinder


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.muryno.cardfinder.ui.activity.CardDetailActivity
import com.muryno.cardfinder.ui.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
@LargeTest

class MainActivityUiTest {


    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "5353 5637 8763 567"
    }


    @Test
    fun checkChangeEditTextWithCardText() {
        // Edit text for .
        onView(withId(R.id.edtCardNumber))
            .perform(typeText(stringToBetyped), closeSoftKeyboard())


        onView(withId(R.id.tv_card_number))
            .check(matches(withText(stringToBetyped)))
    }









}
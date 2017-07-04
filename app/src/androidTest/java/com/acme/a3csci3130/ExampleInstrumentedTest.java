package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Esspresso Testing for CreateContactActivity.
 * @author Scott Martell
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public String name1, name2, num1, bus1, addr1, ter1;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    /**
     * Sets test variables.
     */
    @Before
    public void setString(){
        name1 = "Fish Guy";
        name2 = "Fish Market";
        num1 = "123456789";
        bus1 = "Fisher";
        addr1 = "123 Ocean St";
        ter1 = "NS";
    }

    /**
     * Tests that a business can be created given the right input.
     * @throws Exception if a test fails.
     */
    @Test
    public void createText() throws Exception {
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name1));
        onView(withId(R.id.number)).perform(typeText(num1));
        onView(withId(R.id.business)).perform(typeText(bus1));
        onView(withId(R.id.address)).perform(typeText(addr1));
        onView(withId(R.id.territory)).perform(typeText(ter1));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * Tests that a business data can be read once it has been input.
     * @throws Exception if a test fails.
     */
    @Test
    public void readTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * Tests that a business can be updated once it has been input.
     * @throws Exception if a test fails.
     */
    @Test
    public void updateTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name2));
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * Tests that a business can be deleted once it has been input.
     * @throws Exception if a test fails.
     */
    @Test
    public void deleteTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}

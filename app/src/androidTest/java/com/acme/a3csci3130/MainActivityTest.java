package com.acme.a3csci3130;


import android.support.test.espresso.DataInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUpdateButtonMain() {
        onView(withId(R.id.updateButtonMain)).perform(click());
        onView(withId(R.id.infoText)).check(matches(withText("Please select a user from list")));

    }

    @Test
    public void testDelete() {
        onView(withId(R.id.deleteButtonMain)).perform(click());
        onView(withId(R.id.infoText)).check(matches(withText("Please select a user from list")));
    }
    @Test
    public void testRulesname() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("B"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("Bob@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }

    @Test
    public void testRulesname1() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Bob"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("Bob@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }


    @Test
    public void testEmail() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Alice"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("alicedal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }
    @Test
    public void testEmail1() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Alice"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("alice@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }



    @Test
    public void testBusNumber() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Emma"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("Emma@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("12345"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }

    @Test
    public void testBusNumber1() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Emma"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("Emma@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }


    @Test
    public void testPrmNumber() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("David"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("David@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fis"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }

    @Test
    public void testPrmNumber1() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("David"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("David@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fish Monger"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());
    }


    @Test
    public void testCreate() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("yiweizhnag"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("zhangyiwei@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456789"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());


        DataInteraction textView = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),childAtPosition(
                        withClassName(is("android.support.constraint.ConstraintLayout")),
                        2)))
                .atPosition(1);
        textView.perform(click());


        onView(withId(R.id.nameDetail))
                .perform(clearText(), typeText("zhangyiwei"),closeSoftKeyboard());
        onView(withId(R.id.emailDetail))
                .perform(clearText(), typeText("yiwei@dal.ca"),closeSoftKeyboard());
        onView(withId(R.id.businessNumberDetail))
                .perform(clearText(), typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.primaryBusinessDetail))
                .perform(clearText(), typeText("Distributor"),closeSoftKeyboard());
        onView(withId(R.id.addressDetail))
                .perform(clearText(), typeText("511 st"),closeSoftKeyboard());
        onView(withId(R.id.provinceDetail))
                .perform(clearText(), typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());




        DataInteraction textView1 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),childAtPosition(
                        withClassName(is("android.support.constraint.ConstraintLayout")),
                        2)))
                .atPosition(3);
        textView1.perform(click());
        onView(withId(R.id.deleteButton)).perform(click());



    }
    @Test
    public void testRules() {
        onView(withId(R.id.createButtonMain)).perform(click());

        onView(withId(R.id.name)).
                perform(typeText("Bob"),closeSoftKeyboard());
        onView(withId(R.id.email)).
                perform(typeText("Bob@dal.ca"),closeSoftKeyboard());

        onView(withId(R.id.businessnumber)).
                perform(typeText("123456"),closeSoftKeyboard());

        onView(withId(R.id.primarybusiness)).
                perform(typeText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.address)).
                perform(typeText("501 3rd"),closeSoftKeyboard());

        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());

    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

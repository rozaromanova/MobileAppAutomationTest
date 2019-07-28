package com.freenow.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.freenow.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class LoginAndDriverSearchTest {

    private static final String userName="crazydog335";
    private static final String password="venture";


    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule permissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");
    @Test
    public void LogInAndSearchTest() {

        //login - 'happy path'
        onView(allOf(withId(R.id.edt_username), is(instanceOf(android.widget.EditText.class)),
                isDisplayed())).perform(click());
        onView(allOf(withId(R.id.edt_username), is(instanceOf(android.widget.EditText.class)),
                isDisplayed())).perform(replaceText(userName));
        onView(allOf(withId(R.id.edt_password), is(instanceOf(android.widget.EditText.class)),
                isDisplayed())).perform(click());
        onView(allOf(withId(R.id.edt_password), is(instanceOf(android.widget.EditText.class)),
                isDisplayed())).perform(replaceText(password));
        onView(withId(R.id.btn_login)).perform(click());

        //search 'sa'
        onView(allOf(withId(R.id.textSearch), is(instanceOf(android.widget.AutoCompleteTextView.class)),
                isDisplayed())).perform(click());
        onView(allOf(withId(R.id.textSearch), is(instanceOf(android.widget.AutoCompleteTextView.class)),
                isDisplayed())).perform(replaceText("sa"));

    }

}

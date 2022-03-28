package edu.gatech.seclass.jobcompare6300;

import androidx.annotation.ContentView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withInputType;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.res.Resources;

@RunWith(AndroidJUnit4.class)

public class UITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void selectSetCurrentJob(){
        onView(withId(R.id.btn_title_setJob))
                .perform(click());
        onView(withId(R.id.job_editTitle))
                .check(matches(withText("software")));


    }
    @Test
    public void selectAddOffer(){
        onView(withId(R.id.btn_title_setOffer))
                .perform(click());
        onView(withId(R.id.offer_editTitle))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editCompany))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editLocation))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editLivingCost))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editSalary))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editBonus))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editRetirementBenefits))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editRelocation))
                .check(matches(withText("")));
        onView(withId(R.id.offer_editStock))
                .check(matches(withText("")));


    }

    @Test
    public void selectWeight(){
        onView(withId(R.id.btn_title_setWeights))
                .perform(click());
        onView(withId(R.id.text_weight_salary))
                .check(matches(withText("0")));


    }

    @Test
    public void selectCompare(){
        onView(withId(R.id.btn_title_rankJobs))
                .perform(click());
        onView(withId(R.id.recyclerView))
                .check(matches(isDisplayed()));


    }


}

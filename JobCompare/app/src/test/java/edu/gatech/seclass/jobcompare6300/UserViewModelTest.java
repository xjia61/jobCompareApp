package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;



@RunWith(JUnit4.class)
public class UserViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();
    private final Application application = Mockito.mock(Application.class);

    private UserViewModel userViewModel;
    /*
    private Weight mWeight;
    private List<Job> offers;
    private Job currentJob;
    private Job mCompareJob1;
    private Job mCompareJob2;
    */

    @Mock
    Job mCurrentJob;
    @Mock
    List<Job> mJobOffers;
    @Mock
    Weight mWeight;
    @Mock
    Job mCompareJob1;
    @Mock
    Job mCompareJob2;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        Job job1 = new Job();
        job1.setBonus(10000);
        job1.setCompany("Amazon");
        job1.setLocation("New York");
        job1.setLivingCost(96);
        job1.setRelocation(2000);
        job1.setRetirementBenefits(5);
        job1.setSalary(300000);
        job1.setTitle("SDE");
        job1.setStock(20000);

        Job job2 = new Job();
        job2.setBonus(10000);
        job2.setCompany("Google");
        job2.setLocation("Settle");
        job2.setLivingCost(123);
        job2.setRelocation(2000);
        job2.setRetirementBenefits(10);
        job2.setSalary(300000);
        job2.setTitle("SDE");
        job2.setStock(20000);

        Job job3 = new Job();
        job3.setBonus(20000);
        job3.setCompany("Zoom");
        job3.setLocation("Chicago");
        job3.setLivingCost(8000);
        job3.setRelocation(6000);
        job3.setRetirementBenefits(20);
        job3.setSalary(600000);
        job3.setTitle("SDE");
        job3.setStock(40000);
        userViewModel = new UserViewModel(application);
        mJobOffers.add(job2);
        mJobOffers.add(job3);
        userViewModel.setCurrentJob(job1);
        userViewModel.setJobOffers(mJobOffers);
    }

    @After
    public void tearDown() throws Exception {
        userViewModel = null;

    }

    @Test
    public void getCurrentJobTest() {
        assertNotNull(userViewModel.getCurrentJob());
        assertEquals("SDE",userViewModel.getCurrentJob().getTitle());
        assertEquals("Amazon", userViewModel.getCurrentJob().getCompany());

    }

    @Test
    public void getWeightSetting(){
        assertNotNull(userViewModel.getWeight().getAYB());
        assertEquals(1,userViewModel.getWeight().getAYB());
    }
    @Test
    public void setWeightSeting(){
        Weight w  = new Weight();
        w.setAYB(3);
        w.setAYS(1);
        w.setRPB(2);
        w.setRS(0);
        w.setRSUA(0);
        userViewModel.setWeight(w);
        assertNotNull(userViewModel.getWeight().getAYB());
        assertEquals(3,userViewModel.getWeight().getAYB());
    }

    @Test
    public void jobScore(){
        Weight w  = new Weight();
        w.setAYB(3);
        w.setAYS(1);
        w.setRPB(0);
        w.setRS(0);
        w.setRSUA(0);
        userViewModel.setWeight(w);


        Job current = userViewModel.getCurrentJob();
        assertEquals(859.375,userViewModel.getJobScore(current),0.5);
    }




}
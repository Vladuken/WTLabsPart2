package com.vladuken.tests;


import com.vladuken.tasks.Task1.unit.Task1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        Task1Test.class,
        Task2Test.class,
        Task3Test.class,
        Task4Test.class,
        Task5Test.class,
        Task6Test.class,
        Task7Test.class,
        Task8Test.class,
        Task9Test.class,
        BookComparatorTest.class,
        BookTest.class
})

public class AllTest {

}

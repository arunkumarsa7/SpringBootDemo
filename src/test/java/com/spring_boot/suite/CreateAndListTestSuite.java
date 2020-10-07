package com.spring_boot.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.spring_boot.CreateProductTests;
import com.spring_boot.ListProductTests;

@RunWith(Suite.class)
@SuiteClasses({ CreateProductTests.class, ListProductTests.class })
public class CreateAndListTestSuite {

}

package com.spring_boot.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.spring_boot.DeleteProductTests;
import com.spring_boot.UpdateProductTests;

@RunWith(Suite.class)
@SuiteClasses({ UpdateProductTests.class, DeleteProductTests.class })
public class UpdateAndDeleteTestSuite {

}

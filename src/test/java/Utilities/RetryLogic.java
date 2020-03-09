package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{
	int count=0;
	int retry_Count=3;

	public boolean retry(ITestResult arg0) {
		if(retry_Count>count) {
			count++;
			return true;
		}
		return false;
	}

}

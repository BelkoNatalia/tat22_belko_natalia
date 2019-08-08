package test;

import org.testng.annotations.Test;
import page.CloudHomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindInitialBtnTest extends CommonConditions{
    @Test(description = "Find initial button")
    public void FindInitialBtn () {
        String expectedlBtnName = "See products";

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        String currentBtnName = cloudHomePage.openPage()
                .seeAllProductsBtnName();
        assertThat(currentBtnName, is(equalTo(expectedlBtnName)));
    }
}

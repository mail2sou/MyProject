package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import step_definitions.Hooks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChartList extends Hooks {

    //below method navigates to the page where list of movies are to be found
    public void navigateToListOfMovies() {
        WebDriverWait wait=new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='home_img']")));
        if(driver.findElement(By.xpath("//*[contains(text(),'Sign ')]")).getText().equals("Sign In")){
            driver.findElement(By.xpath("//label[@id='imdbHeader-navDrawerOpen--desktop']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Top Rated Movies']")));
            WebElement element = driver.findElement(By.xpath("//*[text()='Top Rated Movies']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
        }
        else
            driver.findElement(By.xpath("(//a[text()='Top Rated Movies'])[2]")).click();
    }

    //below method prints the list of movies along with ratings and year and also check whether it is sorted as per ratings
    public void printAndVerifyListOfMovies() throws IOException, FileNotFoundException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='titleColumn']")));
        List<WebElement> title  = driver.findElements(By.xpath("//td[@class='titleColumn']"));//list all names and years of movies
        List<String> titleTexts = title.stream().map(WebElement::getText).collect(Collectors.toList());//converts list to String
        List<WebElement> rating  = driver.findElements(By.xpath("//*[@class='titleColumn']//parent::*//child::*[@class='ratingColumn imdbRating']"));//lists all ratings of movies
        List<String> ratingValue = rating.stream().map(WebElement::getText).collect(Collectors.toList());//converts list to String
        List<Float> ratingToFloat = convertStringToFloat(ratingValue, Float::parseFloat);//converts list to Float
        boolean checkSorting=isSorted(ratingToFloat);
        /*if list is not sorted, program terminates as that is the basic verification as per problem statement
        The list is sorted as per ratings, so the list which contains ratings in Float data type, is validated and checked whether
        the same is sorted and displayed as per rating
         */
        Assert.assertTrue(checkSorting);
        final String filePath = ".\\target\\results\\result.txt";
        BufferedWriter bw = new BufferedWriter (new FileWriter(filePath));
        //below loop writes the names, years and ratings of movies to the text file and also to the console
        for(int i=0;i<titleTexts.size();i++){
            String name = titleTexts.get(i);
            String rate = ratingValue.get(i);
            System.out.println(name + "\t" + rate);
            ArrayList<String> titleList = new ArrayList();
            titleList.add(name + "\t" + rate);
            for (String line : titleList) {
                bw.write(line + "\n");
            }
        }
        bw.close ();
    }

    //below method is to check whether the Float list is sorted
    private static boolean isSorted(List<Float> listOfFloat) {
        Iterator<Float> it = listOfFloat.iterator();
        float current, previous = it.next();
        while (it.hasNext()) {
            current = it.next();
            if (previous<current) {
                System.out.println(previous+"\t"+current);
                return false;
            }
            previous = current;
        }
        return true;
    }

    //below method is to convert the rating in data type 'String' to data type 'Float'
    private static <T, U> List<U> convertStringToFloat(List<T> listOfString, Function<T, U> function) {
        return listOfString.stream().map(function).collect(Collectors.toList());
    }
}

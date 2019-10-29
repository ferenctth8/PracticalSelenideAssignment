package com.feritoth.selenide.test;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class VodafoneTest {

    /* The logger reference used for tracing operation outcome */
    private static final Logger LOGGER = LoggerFactory.getLogger(VodafoneTest.class);

    //Define the list of constants used in the current application
    //Step 1
    private static final String VODAFONE_HOMEPAGE = "https://www.vodafone.cz";
    //Step 2
    private static final String SECOND_LINK_TEXT = "Telefony a zařízení";
    //Step 3
    private static final String THIRD_CLASS_NAME = "fakeLink";
    private static final String THIRD_TEXT_MATCH = "Více o telefonech";
    //Step 4
    //Global section
    private static final String FOURTH_CSS_ITEM_SELECTOR = "#device_list_container article";
    private static final String PHONE_CSS_PURCHASE_SELECTOR = "a[class='add_to_cart_button button smallTypo ']";
    //Local section
    private static final String FOURTH_TELEHPONE_NAME_A = "Huawei P smart 2019";
    private static final String FOURTH_TELEPHONE_NAME_B = "Huawei P30 Lite";
    //Step 5
    private static final String FIFTH_CLASS_NAME = "change";
    private static final String FIFTH_ID = "#hs_detail_variant_huep30litew";
    private static final String FIFTH_LINK_TEXT = "Změnit";
    //Step 6
    //Global section
    private static final String SIXTH_CLASS_NAME = "col";
    private static final String SIXTH_ATTRIBUTE_NAME = "alt";
    private static final String SIXTH_ATTRIBUTE_VALUE = "Pouzdro 3D Prismatic Huawei P Smart (2019), modrá";
    //Local section
    private static final String SIXTH_BUTTON_TEXT_A = "Vybrat něco navíc ";
    private static final String SIXTH_BUTTON_TEXT_B = "Přidat";
    private static final String SIXTH_ACCESSORY_LINK_SELECTOR = "a[data-product='accessory']";
    private static final String SIXTH_ACCESSORY_IMG_SELECTOR = "img[alt='Pouzdro 3D Prismatic Huawei P Smart (2019), modrá']";
    private static final String ACCESSORY_CSS_PURCHASE_SELECTOR = "a[class='add_to_cart_button button smallTypo ']";
    //Steps 7 and 9
    private static final String RIGHT_TOTAL_CLASS_SELECTOR = "right";
    private static final String PRICE_CLASS_SELECTOR = "price";
    private static final String ANGLE_BRACKET = ">";
    private static final String PARAGRAPH_ENDER = "</p>";
    private static final String LETTER_INDEX_PATTERN = "\\D+";
    private static final String STARTER_WORD = "měsíčně";
    private static final String EMPTY_STRING = "";
    private static final String SPACE_STRING = " ";
    //Step 8
    private static final String REMOVAL_CLASS_SELECTOR = "remove";
    //Step 10
    private static final String CART_SUBMISSION_SELECTOR = "a[class='button bigButton nextButton CartSubmitButton']";
    private static final String TENTH_BUTTON_TEXT = "Pokračovat v objednávce";
    //Step 11
    private static final String ELEVENTH_ID = "#summaryOneTimePrice";
    //Step 12
    private static final String MAIN_PAGE_REDIRECT_SELECTOR = "a[itemprop='url']";
    private static final String TWELFTH_LINK_TEXT = "Úvod";
    //Step 13 //Here unfortunately I was not able to display the given pop-up box while navigating back to the main page
    //The selectors enumerated below would be some of the input data which may be used for accessing the given box
    //private static final String THIRTEENTH_LINK_TEXT = "Zavřít menu";
    //private static final String THIRTEENTH_CSS_SELECTOR_A = "button[class='vf-nav-viewport__close']";
    //private static final String THIRTEENTH_CSS_SELECTOR_B = "div[class='vf-nav-dropdown-box -basket-box -cart-info-box']";
    //Step 14
    private static final Integer CART_CONTENT_VOLUME = 1;
    private static final String CART_VOLUME_SELECTOR = "i[class='nav-count -cart-count']";

    @Test
    public void automateTelephonePurchaseScenario() throws InterruptedException {
        //use Thread.sleep() to ensure a slower transition between each of the steps
        //Step 1: open a browser with the selected homepage
        open(VODAFONE_HOMEPAGE);
        Thread.sleep(2000);
        //Step 2: Select menu item "Telefony a zařízení"
        $(By.linkText(SECOND_LINK_TEXT)).click();
        Thread.sleep(2000);
        //Step 3: Select item "Telefony"
        $(By.className(THIRD_CLASS_NAME)).shouldHave(Condition.text(THIRD_TEXT_MATCH)).click();
        Thread.sleep(2000);
        //Step 4: Pick 2 phones and add them to basket
        //Step 4A: Pick the first item and it to the basket
        $$(FOURTH_CSS_ITEM_SELECTOR).find(Condition.matchesText(FOURTH_TELEHPONE_NAME_A)).click();
        $(By.cssSelector(PHONE_CSS_PURCHASE_SELECTOR)).click();
        Thread.sleep(2000);
        //Step 4B: Navigate back to the telephone catalogue (repeat steps 2 and 3)
        $(By.linkText(SECOND_LINK_TEXT)).click();
        $(By.className(THIRD_CLASS_NAME)).shouldHave(Condition.text(THIRD_TEXT_MATCH)).click();
        Thread.sleep(2000);
        //Step 4C: Pick up the second item and add it to the basket
        $$(FOURTH_CSS_ITEM_SELECTOR).find(Condition.text(FOURTH_TELEPHONE_NAME_B)).click();
        $(By.cssSelector(PHONE_CSS_PURCHASE_SELECTOR)).click();
        Thread.sleep(2000);
        //Step 5: Change the colour of the second item
        //Click on the change link near the item
        $$(By.className(FIFTH_CLASS_NAME)).find(Condition.exactText(FIFTH_LINK_TEXT)).click();
        //We are redirected to the telephone page - relocate here the product and access it
        $$(FOURTH_CSS_ITEM_SELECTOR).find(Condition.matchesText(FOURTH_TELEPHONE_NAME_B)).click();
        //Change the colour - Possible future extension: Check next if colour change would be possible
        $(FIFTH_ID).click();
        //Re-add the item to the basket for confirming the change
        $(By.cssSelector(PHONE_CSS_PURCHASE_SELECTOR)).click();
        Thread.sleep(2000);
        //Step 6: Add an accessory to one of the phones
        //Step 6A: Next up locate the button "Vybrat něco navíc" and click it
        $$(By.className(SIXTH_CLASS_NAME)).findBy(Condition.exactText(SIXTH_BUTTON_TEXT_A)).click();
        Thread.sleep(2000);
        //Step 6B: Find the corresponding button for opening the accessory page and click it
        $(SIXTH_ACCESSORY_LINK_SELECTOR).shouldHave(Condition.text(SIXTH_BUTTON_TEXT_B)).click();
        Thread.sleep(2000);
        //Step 6C: Choose an accessory and add it to the basket
        $(SIXTH_ACCESSORY_IMG_SELECTOR).shouldHave(Condition.attribute(SIXTH_ATTRIBUTE_NAME, SIXTH_ATTRIBUTE_VALUE)).click();
        $(By.cssSelector(ACCESSORY_CSS_PURCHASE_SELECTOR)).click();
        Thread.sleep(2000);
        //Step 7: check that the displayed total truly matches the total basket value
        Integer initialBasketPrice = checkDisplayedTotalAgainstComputedBasketSum();
        //Step 8: Remove one item from basket - for simplicity we will remove the first one
        $(ByClassName.className(REMOVAL_CLASS_SELECTOR)).click();
        Thread.sleep(2000);
        //Step 9: Repeat step 7 for the remaining item from the basket
        Integer finalBasketPrice = checkDisplayedTotalAgainstComputedBasketSum();
        //As extra assertion: check that the first and the second sum are not equal to each other
        Assert.assertNotEquals(finalBasketPrice, initialBasketPrice);
        LOGGER.info("The initial cart price was " + initialBasketPrice + " Kč, while the final one is " + finalBasketPrice + " Kč - the value of the difference is equal to the that of the previously removed item!");
        //Step 10: Find and click the button "Pokračovat v objednávce"
        $(By.cssSelector(CART_SUBMISSION_SELECTOR)).shouldHave(Condition.text(TENTH_BUTTON_TEXT)).click();
        Thread.sleep(2000);
        //Step 11: Check that the final basket value retrieved at step 9 is equal to the final order value
        String orderPriceToken = $(ELEVENTH_ID).getText();
        Integer orderPrice = Integer.valueOf(orderPriceToken.replaceAll(LETTER_INDEX_PATTERN, EMPTY_STRING).replaceAll(SPACE_STRING, EMPTY_STRING));
        Assert.assertEquals(finalBasketPrice, orderPrice);
        //Step 12: Navigate back to main page
        $(MAIN_PAGE_REDIRECT_SELECTOR).shouldHave(Condition.exactText(TWELFTH_LINK_TEXT)).click();
        //Step 13: Try to get the alert for help on purchasing and close it
        //At this step unfortunately the pop-up box is not always displayed during navigation
        //There will be a need to change somehow the visibility of the HTML element associated to this box
        //Unfortunately, up to the current moment, I have not yet found a solution inside Selenide for this issue
        //$$(By.name("session[username_or_email]")).filter(visible).get(0).setValue("name")
        //$$(THIRTEENTH_CSS_SELECTOR).filter(Condition.not(Condition.visible)).get(0).click();
        //$(THIRTEENTH_CSS_SELECTOR_B)
        //$(THIRTEENTH_CSS_SELECTOR_A).setValue("visible:true");
        //Step 14: Check the cart content volume
        Integer displayedCartVolume = Integer.valueOf($(CART_VOLUME_SELECTOR).getText());
        Assert.assertEquals(CART_CONTENT_VOLUME, displayedCartVolume);
        LOGGER.info("The current cart content is: " + displayedCartVolume + " - therefore it matches the enforced condition!");
    }

    //method for checking the equality of the displayed total against the computed basket value
    private Integer checkDisplayedTotalAgainstComputedBasketSum() {
        String newTotalPriceToken = $(By.className(RIGHT_TOTAL_CLASS_SELECTOR)).getText();
        String newFinalPriceToken = newTotalPriceToken.replaceAll(LETTER_INDEX_PATTERN, EMPTY_STRING);
        List<Object> allFinalPriceObjects = Arrays.asList($$(By.className(PRICE_CLASS_SELECTOR)).toArray());
        Integer finalSum = processPriceObjectArray(allFinalPriceObjects);
        Assert.assertEquals(Integer.valueOf(newFinalPriceToken), finalSum);
        LOGGER.info("The displayed price value is:" + Integer.valueOf(newFinalPriceToken) + " Kč, while the computed price value is " + finalSum + " Kč - therefore they match!");
        return finalSum;
    }

    //method for processing the array of selected objects which are located under "price" class inside the examined web page
    private Integer processPriceObjectArray(List<Object> allPriceObjects) {
        List<Integer> allItemPrices = new ArrayList<>();
        allPriceObjects.forEach(priceObject -> {
            String itemPriceString = priceObject.toString();
            String intermediateItem = itemPriceString.substring(itemPriceString.indexOf(ANGLE_BRACKET) + 1, itemPriceString.indexOf(PARAGRAPH_ENDER));
            if (!StringUtils.startsWithIgnoreCase(intermediateItem, STARTER_WORD)){
                String finalItem = intermediateItem.replaceAll(LETTER_INDEX_PATTERN, EMPTY_STRING).replaceAll(SPACE_STRING, EMPTY_STRING);
                if (StringUtils.isNumeric(finalItem)){
                    allItemPrices.add(Integer.valueOf(finalItem));
                }
            }
        });
        Integer finalSum = allItemPrices.stream().reduce(0, Integer::sum);
        return finalSum;
    }

}
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void simpleCheckTest(){
    open("https://github.com");
    $("[placeholder='Search or jump to...']").click();
    $("#query-builder-test").setValue("selenide").pressEnter();
    $("[data-testid='results-list']").find("span").click();
    $("#wiki-tab").click();
    $(".markdown-body").$("ul").$$("li").shouldHave(CollectionCondition.itemWithText("Soft assertions"));
    $(byText("Soft assertions")).click();
    $("#user-content-3-using-junit5-extend-test-class").shouldHave(text("3. Using JUnit5 extend test class:"));
    $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(exactText("@ExtendWith({SoftAssertsExtension.class})" +
                        "\n" +
                        "class Tests {\n" +
                        "@Test\n" +
                        "void test() {\n" +
                        "Configuration.assertionMode = SOFT;\n" +
                        "open(\"page.html\");\n" +
                        "\n" +
                        "$(\"#first\").should(visible).click();\n" +
                        "$(\"#second\").should(visible).click();\n" +
                        "}\n" +
                        "}"));

    }
}


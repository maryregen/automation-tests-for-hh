package ui.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class EmployerSearchPage extends MainPage {
    public EmployerSearchPage getSearchHeader() {
        $("div.resume-search-header div[data-qa='bloko-header-3']");
        return this;
    }
}

package DataService;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

//Способ запуска тестов в DataService package - через лаунчер из junit-platform-launcher
public class DataServiceTestLauncher {
    public static void main(String[] args) {
        //создадим лаунчер через LauncherFactory
        var launcher = LauncherFactory.create();
        //используем RequestBuilder для создания запроса на запуск
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
//for ex:       .selectors(DiscoverySelectors.selectClass(DataService.class)//отдельныйм классом
                .selectors(DiscoverySelectors.selectPackage("DataService"))//где реквест будет искать наши тесты /Dir
                .build();

        //используем уже настроенные Лисенеры  (хотя можно создать свои)
        //статистика по выполненым тестам и передадим его в execute ниже
        var summaryGeneratingListener = new SummaryGeneratingListener();

        launcher.execute(request, summaryGeneratingListener);//запуск созданного/билдованного реквеста с лисереном
        //execute возвращает на void, поэтому нужна статистика по итогу выполнения тестов в консоль
        summaryGeneratingListener.getSummary().printTo(new PrintWriter(System.out));
    }
}

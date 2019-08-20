package controller;

import io.prometheus.client.Gauge;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Random;

public class GaugeController extends Controller {

        private static Gauge daniel_gauge = Gauge.build().name("daniel_gauge").help("Gauge Metric").create().register();

    public Result startGauge()  throws InterruptedException {

        beginProcess();
        return ok();
    }

    private void beginProcess()  throws InterruptedException {
        int n = 0;
        while (n < 10000) {
            Random random = new Random();
            int randomNumber = random.nextInt(200);
            daniel_gauge.set(randomNumber);
            Thread.sleep(500);
        }
    }
}

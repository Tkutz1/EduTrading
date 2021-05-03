package com.edutrading.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StockService {
    String AAPL_price;
    String GME_price;
    String TSLA_price;
    String MSFT_price;
    String KO_price;
    String V_price;
    String WMT_price;
    String HD_price;
    String DIS_price;
    String AMZN_price;
    String FB_price;

    public void price() throws IOException{

        URL AAPL_url = new URL("https://markets.businessinsider.com/stocks/aapl-stock");
        URL GME_url = new URL("https://markets.businessinsider.com/stocks/gme-stock");
        URL TSLA_url = new URL("https://markets.businessinsider.com/stocks/tsla-stock");
        URL MSFT_url = new URL("https://markets.businessinsider.com/stocks/msft-stock");
        URL KO_url = new URL("https://markets.businessinsider.com/stocks/ko-stock");
        URL V_url = new URL("https://markets.businessinsider.com/stocks/v-stock");
        URL WMT_url = new URL("https://markets.businessinsider.com/stocks/wmt-stock");
        URL HD_url = new URL("https://markets.businessinsider.com/stocks/hd-stock");
        URL DIS_url = new URL("https://markets.businessinsider.com/stocks/dis-stock");
        URL AMZN_url = new URL("https://markets.businessinsider.com/stocks/amzn-stock");
        URL FB_url = new URL("https://markets.businessinsider.com/stocks/fb-stock");

        AAPL_price = getPrice(AAPL_url);
        GME_price =  getPrice(GME_url);
        TSLA_price = getPrice(TSLA_url);
        MSFT_price = getPrice(MSFT_url);
        KO_price = getPrice(KO_url);
        V_price = getPrice(V_url);
        WMT_price = getPrice(WMT_url);
        HD_price = getPrice(HD_url);
        DIS_price = getPrice(DIS_url);
        AMZN_price = getPrice(AMZN_url);
        FB_price = getPrice(FB_url);



    }

    public static String getPrice(URL url) throws IOException{

        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String line = buff.readLine();
        String price = "not found";
        while(line != null){
            if(line.contains("progress__label snapshot__price-label")){
                int target = line.indexOf("progress__label snapshot__price-label");
                int deci = line.indexOf(".",target);
                int start = deci;

                while(line.charAt(start) != '>'){
                    start--;
                }
                price = line.substring(start + 1, deci + 3);
            }
            line = buff.readLine();
        }

        return price;

    }
}

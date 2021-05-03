package com.edutrading.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StockService {
    public static void main(String[] args) throws IOException{

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

        String AAPL_price = getPrice(AAPL_url);
        String GME_price =  getPrice(GME_url);
        String TSLA_price = getPrice(TSLA_url);
        String MSFT_price = getPrice(MSFT_url);
        String KO_price = getPrice(KO_url);
        String V_price = getPrice(V_url);
        String WMT_price = getPrice(WMT_url);
        String HD_price = getPrice(HD_url);
        String DIS_price = getPrice(DIS_url);
        String AMZN_price = getPrice(AMZN_url);
        String FB_price = getPrice(FB_url);



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

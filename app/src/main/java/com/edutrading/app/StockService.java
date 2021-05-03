package com.edutrading.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class StockService {

    public static String AAPL_price;
    public static String GME_price;
    public static String TSLA_price;
    public static String MSFT_price;
    public static String KO_price;
    public static String V_price;
    public static String WMT_price;
    public static String HD_price;
    public static String DIS_price;
    public static String AMZN_price;
    public static String FB_price;


    public StockService() throws IOException{

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

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                try {
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
                } catch(IOException err){}
            }
        },5000,5000);
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

    public static String getAAPL_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/aapl-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getGME_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/gme-stock");
        String price = getPrice(url);
        return price;

    }
    public static String getTSLA_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/tsla-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getMSFT_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/msft-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getKO_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/ko-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getV_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/v-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getWMT_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/wmt-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getHD_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/hd-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getDIS_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/dis-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getAMZN_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/amzn-stock");
        String price = getPrice(url);
        return price;
    }
    public static String getFB_price() throws IOException{
        URL url = new URL("https://markets.businessinsider.com/stocks/fb-stock");
        String price = getPrice(url);
        return price;
    }

}

package net.samagames.hydroangeas.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class InternetUtils
{
    public static String readURL(String url)
    {
        try
        {
            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            String inputLine = in.readLine();
            in.close();

            return inputLine;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static String getExternalIp()
    {
        try
        {
            URL ipURL = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(ipURL.openStream()));

            return in.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}

package com.accesshq.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig extends Properties
{
	public ReadConfig()
	{
		File propertiesFile = new File("./config.properties");
		FileInputStream stream = null;

        try
        {
            stream = new FileInputStream(propertiesFile);
            load( stream );
        }
        catch ( FileNotFoundException e )
        {
        	e.printStackTrace();
        }
        catch ( IOException e )
        {
        	e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( stream != null )
                {
                    stream.close();
                }
            }
            catch ( IOException e )
            {
            	e.printStackTrace();
            }
        }
	}

	public void loadConfig()
	{
		Configurations.URL = get("URL").toString();
		Configurations.BROWSER_NAME = get("BROWSER_NAME").toString();
		Configurations.SCREENSHOT_LOCATION = get("SCREENSHOT_LOCATION").toString();
		Configurations.CHROME_DRIVER_LOCATION = get("CHROME_DRIVER_LOCATION").toString();
	}
	public static void main(String args[])
	{
		ReadConfig readConfig = new ReadConfig();
		String url = (String) readConfig.get("URL");
		System.out.println(url);
	}
}
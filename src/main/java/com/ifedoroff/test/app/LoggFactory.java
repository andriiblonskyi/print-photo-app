package com.ifedoroff.test.app;

import org.apache.log4j.Logger;

/**
 * Created by Rostik on 27.05.2017.
 */
public class LoggFactory {
    final static Logger logger = Logger.getLogger(LoggFactory.class);

    public  static  void writeLog(String msg)
    {
        logger.debug(msg);
    }
}

package example;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    private static String driverClass = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String args[]) {
      String PWD = System.getenv("PWD");

      PropertyConfigurator.configure(PWD + "/src/main/resources/log4j.xml");

      final String connectionStr = "jdbc:hive2://hive-server:10000";

      example.chain.ILink obj = new example.chain.Driver();

      if (obj.hasResource(driverClass, "root", "", connectionStr)){
        example.db.print.output.IOutput output = new example.db.print.output.ToConsole();
        for ( String tbl : new String[]{"animal.dog"})
          example.db.DBQuery.query("root", "", connectionStr, tbl, output);
      }

    }
}

package config;

import java.util.UUID;

public class Env {
    /*
    Adicionar essa configuração dentro server.xml do tomacat
     <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

        <!-- SingleSignOn valve, share authentication between web applications
             Documentation at: /docs/config/valve.html -->
        <!--
        <Valve className="org.apache.catalina.authenticator.SingleSignOn" />
        -->
          <Context path="/jornal_do_brasil/storage/thumb" docBase="E:/jornal-do-brasil/src/main/webapp/storage/thumb" />
        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
     */

    public String uuid = new UUID(0, 0).randomUUID().toString();
//     public static final String PATH_BASE = "C:\\Users\\anast\\OneDrive\\Documents\\jornal-do-brasil";
//     public static final String PATH_BASE = "E:\\jornal-do-brasil";
    public static final String PATH_BASE = "C:\\jornal-do-brasil";
    public static final String db_USER = "root";
    public static final String db_PASSWORD = "123456";
    public static final String db_URL = "jdbc:mysql://127.0.0.1:3306/db_jornal_do_brasil";
    public static final String db_DRIVER = "com.mysql.jdbc.Driver";
}
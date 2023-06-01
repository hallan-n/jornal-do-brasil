package config;

import java.util.UUID;

public class Env {
    public String uuid = new UUID(0, 0).randomUUID().toString();
    public String pathBase = "E:\\jornal-do-brasil";
}
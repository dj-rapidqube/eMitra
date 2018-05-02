package utils;

public interface Constants {

    String TIMEZONE_UTC = "Etc/UTC";

    String EMPTY_STRING = "";
    String NA_STRING = "N/A";
    String UNDERSCORE = "_";
    String HYPHEN = "-";
    String QUOTE = "\"";
    String SPACE = " ";
    String COLON = ":";
    String COMMA = ",";
    String HASH = "#";
    String PIPE = "|";
    String TAB = "\t";
    String DOT = ".";
    String AT = "@";
    String QUESTION = "?";
    String FORWARD_SLASH = "/";
    String NEW_LINE = "\n";
    String SINGLE_QUOTE = "'";

    String TRUE_STR = "true";
    String FALSE_STR = "false";

    String EXTENSION_TXT = ".txt";

    String STATUS_SUCCESS = "SUCCESS";
    String STATUS_FAILURE = "FAILURE";

    String VAR_STAGE = "stage";
    String ENV_TYPE_PROD = "prod";
    String ENV_TYPE_DEV = "dev";

    Object LOCK_OBJ = new Object();
    
    public interface HTTP {

        int SOCKET_TIMEOUT = 30 * 60 * 1000; // 30 mins
        int CONNECTION_TIMEOUT = 10 * 1000; // 10 secs

        int MAX_OPEN_CONNECTIONS = 10;
        int MAX_CONCURRENT_CONNECTION_PER_ROUTE = 5;
    }
    
    
    
    
    
}

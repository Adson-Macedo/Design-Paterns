package utils;

public class Colors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    private static final String colors[] = { ANSI_GREEN, ANSI_YELLOW, ANSI_RED };

    public static String getStatusColor(int status){
        return colors[status];
    }
}
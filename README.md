# MBLogger
Android logger that i use in my projects

# Example
```
MBLogger logger;

logger = new MBLogger.Builder()
                .setTag(this) // here u can give object, or string ang logger will get the tag from it
                .setIsOnlyInDebug(true) // if u want log messages to appear only in debug mode
                .createLogger();
                
                
try {
    UtilsFile.getInstance();
    Globals.rootDir = UtilsFile.getInstance().getRootDir();
} catch (Exception e) {
    logger.error(e);
}

logger.debug("Debugging");

logger.info("This is information: Successfully logged");

logger.wtf("Very dengerous horrible error", exception);

logger.wtf("Very dengerous horrible error has just happened");
```

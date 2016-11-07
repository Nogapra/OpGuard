package com.rezzedup.opguard.api.config;

import java.util.List;

public interface OpGuardConfig extends Config
{
    long getOpListInspectionInterval();
    
    boolean canOnlyOpIfOnline();
    
    boolean canManagePasswordInGame();
    
    boolean canDisableOtherPlugins();
    
    boolean canRenameOtherPlugins();
    
    boolean canShutDownOnDisable();
    
    boolean isLocked();
    
    boolean loggingIsEnabled();
    
    boolean canLogPluginAttempts();
    
    boolean canLogConsoleAttempts();
    
    boolean canLogPlayerAttempts();
    
    String getWarningPrefix();
    
    String getWarningEmphasisColor();
    
    boolean canSendPluginAttemptWarnings();
    
    boolean canSendConsoleOpAttemptWarnings();
    
    boolean canSendConsoleOpGuardAttemptWarnings();
    
    boolean canSendPlayerOpAttemptWarnings();
    
    boolean canSendPlayerOpGuardAttemptWarnings();
    
    String getSecurityPrefix();
    
    boolean canSendSecurityWarnings();
    
    String getOkayPrefix();
    
    boolean canPunishPluginAttempts();
    
    boolean canPunishConsoleOpAttempts();
    
    boolean canPunishConsoleOpGuardAttempts();
    
    List<String> getPunishmentCommands();
    
    boolean metricsAreEnabled();
    
    String getVersion();
}
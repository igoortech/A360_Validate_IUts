package com.automationanywhere.botcommand.samples.commands.basic.desktopoperation;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DesktopOperationSampleClassCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(DesktopOperationSampleClassCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    DesktopOperationSampleClass command = new DesktopOperationSampleClass();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("desktopOperationSelectAttribute") && parameters.get("desktopOperationSelectAttribute") != null && parameters.get("desktopOperationSelectAttribute").get() != null) {
      convertedParameters.put("desktopOperationSelectAttribute", parameters.get("desktopOperationSelectAttribute").get());
      if(!(convertedParameters.get("desktopOperationSelectAttribute") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","desktopOperationSelectAttribute", "String", parameters.get("desktopOperationSelectAttribute").get().getClass().getSimpleName()));
      }
    }

    if(parameters.containsKey("desktopOperationButtonAttribute") && parameters.get("desktopOperationButtonAttribute") != null && parameters.get("desktopOperationButtonAttribute").get() != null) {
      convertedParameters.put("desktopOperationButtonAttribute", parameters.get("desktopOperationButtonAttribute").get());
      if(!(convertedParameters.get("desktopOperationButtonAttribute") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","desktopOperationButtonAttribute", "String", parameters.get("desktopOperationButtonAttribute").get().getClass().getSimpleName()));
      }
    }

    if(parameters.containsKey("optionName") && parameters.get("optionName") != null && parameters.get("optionName").get() != null) {
      convertedParameters.put("optionName", parameters.get("optionName").get());
      if(!(convertedParameters.get("optionName") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","optionName", "String", parameters.get("optionName").get().getClass().getSimpleName()));
      }
    }

    if(parameters.containsKey("optionCode") && parameters.get("optionCode") != null && parameters.get("optionCode").get() != null) {
      convertedParameters.put("optionCode", parameters.get("optionCode").get());
      if(!(convertedParameters.get("optionCode") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","optionCode", "String", parameters.get("optionCode").get().getClass().getSimpleName()));
      }
    }

    if(parameters.containsKey("aBooleanTypeAttribute") && parameters.get("aBooleanTypeAttribute") != null && parameters.get("aBooleanTypeAttribute").get() != null) {
      convertedParameters.put("aBooleanTypeAttribute", parameters.get("aBooleanTypeAttribute").get());
      if(!(convertedParameters.get("aBooleanTypeAttribute") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aBooleanTypeAttribute", "Boolean", parameters.get("aBooleanTypeAttribute").get().getClass().getSimpleName()));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.execute((String)convertedParameters.get("desktopOperationSelectAttribute"),(String)convertedParameters.get("desktopOperationButtonAttribute"),(String)convertedParameters.get("optionName"),(String)convertedParameters.get("optionCode"),(Boolean)convertedParameters.get("aBooleanTypeAttribute")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","execute"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
